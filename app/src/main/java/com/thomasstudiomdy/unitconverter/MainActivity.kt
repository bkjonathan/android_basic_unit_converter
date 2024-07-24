package com.thomasstudiomdy.unitconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt : EditText = findViewById(R.id.kilo_edt)
        val btn : Button = findViewById(R.id.convert_btn)
        val resultTxt : TextView = findViewById(R.id.result_text)

        btn.setOnClickListener(){
            val kilos = edt.text.toString().toDouble()
            resultTxt.text = (convertToPounds(kilos))
        }

    }

    fun convertToPounds(kilos:Double):String{
        val pound = kilos * 2.20462
        return String.format("%.2f",pound)
    }
}