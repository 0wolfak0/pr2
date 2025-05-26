package com.example.pr2
<<<<<<< HEAD

import android.content.Intent
import android.os.Bundle
import android.widget.Button
=======
<<<<<<< HEAD
import android.content.Intent;
import android.widget.Button
=======

>>>>>>> c7606140166bd29dd96c56df128a369413cd9f6c
import android.os.Bundle
>>>>>>> 9cc41b80ee6cc05723fec7e3efa0d5f6da0169ce
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
=======
<<<<<<< HEAD
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
=======
>>>>>>> c7606140166bd29dd96c56df128a369413cd9f6c
>>>>>>> 9cc41b80ee6cc05723fec7e3efa0d5f6da0169ce
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}