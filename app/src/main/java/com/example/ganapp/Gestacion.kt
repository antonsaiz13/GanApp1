package com.example.ganapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestacion.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.bottomNavigationView

class Gestacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestacion)

        navegacionInferior()

        but_Calen.setOnClickListener {
            val calendarioIntent = Intent(this, Calendario::class.java)
            startActivity(calendarioIntent)
        }

        but_anadirGestacion.setOnClickListener {
            val gestIntent = Intent(this, AnadirGestacion::class.java)
            startActivity(gestIntent)
        }

    }

    private fun navegacionInferior() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_gestacion-> {
                    val gestacionIntent = Intent(this, Gestacion::class.java)
                    startActivity(gestacionIntent)
                }
                R.id.item_animales -> {
                    val animalesIntent = Intent(this, Animales::class.java)
                    startActivity(animalesIntent)
                }
                R.id.item_home -> {
                    val homeIntent = Intent(this, HomeActivity::class.java)
                    startActivity(homeIntent)
                }
                R.id.item_gastos -> {
                    val gastosIntent = Intent(this, Gastos::class.java)
                    startActivity(gastosIntent)
                }
                R.id.item_info -> {
                    val infoIntent = Intent(this, Informacion::class.java)
                    startActivity(infoIntent)
                }
            }
            true
        }
    }
}