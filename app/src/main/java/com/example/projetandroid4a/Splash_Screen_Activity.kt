package com.example.projetandroid4a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetandroid4a.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash__screen_.*

class Splash_Screen_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen_)

        splash_button.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }


}
