package com.example.pr2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, Locate::class.java)
            startActivity(intent)
        }
        val textView = findViewById<TextView>(R.id.textView14)
        textView.setOnClickListener {
            val intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }
    }
}
