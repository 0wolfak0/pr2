package com.example.pr2

import android.graphics.Region
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val textView16: TextView = findViewById(R.id.textView16)
        textView16.setOnClickListener {
            val intent = Intent(this, Reg::class.java)
            startActivity(intent)
        }
    }
}
