package com.example.preferencias

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activitymain.*
import android.widget.Button

class MainActivity : AppCompatActivity() {
    
    //Declaramos variables preferencias y keyvalues
    
    val PREFS_NAME = "com.example.preferencias"
    val STRING = "STRING"
    val NUMBER = "NUMBER"
    val BOOLEAN = "BOOLEAN"

    lateinit var preferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

        setValues()

        button.setOnClickListener {
            
            //para obtener los valores de las vistas

            val string = etString.text.toString()
            val number = etNumber.text.toString().toFloat()
            val checked = switch1.isChecked

            //para asignar dichos valores a nuestra colección

            preferences.edit()
                .putString(STRING, string)
                .putBoolean(BOOLEAN, checked)
                .putFloat(NUMBER, number)
                .apply()
        }
    }

            fun setValues(){

        //para obtener los valores desde las preferencias

        val string = preferences.getString(STRING,"")
        val boolean = preferences.getBoolean(BOOLEAN, false)
        val number = preferences.getFloat(NUMBER,0f)

        //y luego atarlos a sus vistas
        etString.setText(string)
        switch1.isChecked = boolean
        etNumber.setText(number.toString())
    }


    }