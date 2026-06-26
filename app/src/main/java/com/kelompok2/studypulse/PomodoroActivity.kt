package com.kelompok2.studypulse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PomodoroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomodoro)

        findViewById<android.widget.ImageView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<android.widget.LinearLayout>(R.id.btnMulaiSesi).setOnClickListener {
            startActivity(Intent(this, SessionActivity::class.java))
        }
    }
}