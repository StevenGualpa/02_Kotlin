package com.geek.a02_volley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activa()
    }

    private fun activa()
    {
        var boton: Button=findViewById(R.id.btnenviar)
        boton.setOnClickListener{
            val intent= Intent(this,getVolley::class.java)
            startActivity(intent)
        }
    }
}