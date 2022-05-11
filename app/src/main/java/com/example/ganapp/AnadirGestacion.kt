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
import kotlinx.android.synthetic.main.activity_anadir_gestacion.*
import kotlinx.android.synthetic.main.activity_gestacion.*
import java.util.*


var boton2: Button? = null
var cajaFecha2: EditText? = null


class AnadirGestacion : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_gestacion)

        val spinner = findViewById<Spinner>(R.id.spinner_gestacion)
        val lista = resources.getStringArray(R.array.tipos_gestacion)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)

        spinner.adapter = adaptador

        but_anadirGest_volver.setOnClickListener {
            val volverIntent = Intent(this, Gestacion::class.java)
            startActivity(volverIntent)
        }

        inicializarComponentes()
    }
    private fun inicializarComponentes(){
        boton2 = findViewById(R.id.but_fechaGest)
        cajaFecha2 = findViewById(R.id.caja_fechaGest)
        boton2?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val Dialogfecha = DatePickerFragment{year, month, day -> mostrarResultado(year, month, day)}
        Dialogfecha.show(supportFragmentManager, "DatePicker")
    }

    private fun mostrarResultado(year: Int, month: Int, day: Int) {
        cajaFecha2?.setText("$year/$month/$day")
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

