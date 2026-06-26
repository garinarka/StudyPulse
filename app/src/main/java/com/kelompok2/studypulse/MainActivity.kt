package com.kelompok2.studypulse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMulaiBelajar = findViewById<android.widget.LinearLayout>(R.id.btnMulaiBelajar)
        val btnTeknikPomodoro = findViewById<android.widget.LinearLayout>(R.id.btnTeknikPomodoro)
        val btnTipsFokus = findViewById<android.widget.LinearLayout>(R.id.btnTipsFokus)
        val btnTentang = findViewById<android.widget.LinearLayout>(R.id.btnTentang)

        btnMulaiBelajar.setOnClickListener {
            startActivity(Intent(this, SessionActivity::class.java))
        }

        btnTeknikPomodoro.setOnClickListener {
            startActivity(Intent(this, PomodoroActivity::class.java))
        }

        btnTipsFokus.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }

        btnTentang.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}