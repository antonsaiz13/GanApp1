package com.example.ganapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_gestacion.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.bottomNavigationView
import kotlinx.android.synthetic.main.activity_informacion.*
import kotlinx.android.synthetic.main.activity_registrarse.*

class Informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        navegacionInferior()
        setup()
    }

    private fun setup(){

        title = "Información"

        but_info.setOnClickListener {
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            FirebaseAuth.getInstance().signOut()
            val pantInicioIntent = Intent(this, AuthActivity::class.java)
            startActivity(pantInicioIntent)
        }
    }

    private fun navegacionInferior() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_animales-> {
                    val animalesIntent = Intent(this, Animales::class.java)
                    startActivity(animalesIntent)
                }
                R.id.item_gestacion -> {
                    val gestacionIntent = Intent(this, Gestacion::class.java)
                    startActivity(gestacionIntent)
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