package com.example.ganapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_anadir_animales.*
import java.util.*


var boton: Button? = null
var cajaFecha: EditText? = null

class AnadirAnimales : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_animales)



        val spinner = findViewById<Spinner>(R.id.spinner_sexo)
        //val lista = listOf("Macho", "Hembra")
        val lista = resources.getStringArray(R.array.sexo)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)

        spinner.adapter = adaptador

        inicializarComponentes()

        but_anadirAnim_volver.setOnClickListener {
            val volverIntent = Intent(this, Animales::class.java)
            startActivity(volverIntent)
        }
    }

    private fun inicializarComponentes(){
        boton = findViewById(R.id.but_fechaNac1)
        cajaFecha = findViewById(R.id.caja_fechaNac1)
        boton?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val Dialogfecha = DatePickerFragment{year, month, day -> mostrarResultado(year, month, day)}
        Dialogfecha.show(supportFragmentManager, "DatePicker")
    }

    private fun mostrarResultado(year: Int, month: Int, day: Int) {
        cajaFecha?.setText("$year/$month/$day")
    }

    class DatePickerFragment (val listener : (year:Int, month:Int, day:Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener{

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val c = Calendar.getInstance()
            var year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            var day = c.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(requireActivity(), this, year, month, day)
        }

        override fun onDateSet(p0: DatePicker?, year:Int, month:Int, day:Int) {
            listener(year, month, day)
        }

    }


}