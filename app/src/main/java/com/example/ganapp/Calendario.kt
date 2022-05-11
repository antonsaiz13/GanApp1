package com.example.ganapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calendario.*

class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        but_Calen_info.setOnClickListener {
            val volverIntent = Intent(this, Gestacion::class.java)
            startActivity(volverIntent)
        }
    }


}