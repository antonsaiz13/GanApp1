package com.example.ganapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC, GOOGLE
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")

        setup(email ?: "", provider ?: "")

        // Guardado de datos

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()
    }

    private fun setup(email: String, provider: String){

        title = "Inicio"
        emailTextView.text = email
        providerTextView.text = provider

        logOutButton.setOnClickListener {
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