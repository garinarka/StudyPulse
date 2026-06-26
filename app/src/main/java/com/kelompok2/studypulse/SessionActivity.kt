package com.kelompok2.studypulse

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SessionActivity : AppCompatActivity() {

    private var timeLeft: Int = 1500          // 25 menit dalam detik
    private val totalTime: Int = 1500
    private var isRunning: Boolean = false
    private var isBreakTime: Boolean = false
    private var sessionCount: Int = 1
    private var timer: CountDownTimer? = null

    private lateinit var tvTimer: TextView
    private lateinit var tvStatus: TextView
    private lateinit var circularProgress: CircularProgressView
    private lateinit var btnMulai: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)

        tvTimer = findViewById(R.id.tvTimer)
        tvStatus = findViewById(R.id.tvStatus)
        circularProgress = findViewById(R.id.circularProgress)
        btnMulai = findViewById(R.id.btnMulaiSession)

        findViewById<android.widget.ImageView>(R.id.btnBack).setOnClickListener { finish() }

        circularProgress.maxValue = totalTime
        circularProgress.currentValue = timeLeft
        updateTimerText()

        btnMulai.setOnClickListener {
            if (!isRunning) startTimer() else pauseTimer()
        }

        findViewById<LinearLayout>(R.id.btnJeda).setOnClickListener { pauseTimer() }
        findViewById<LinearLayout>(R.id.btnReset).setOnClickListener { resetTimer() }
    }

    private fun startTimer() {
        isRunning = true
        timer = object : CountDownTimer(timeLeft * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                circularProgress.currentValue = timeLeft
                updateTimerText()
            }

            override fun onFinish() {
                isRunning = false
                handleSessionFinish()
            }
        }.start()
    }

    private fun pauseTimer() {
        isRunning = false
        timer?.cancel()
    }

    private fun resetTimer() {
        timer?.cancel()
        isRunning = false
        isBreakTime = false
        timeLeft = totalTime
        circularProgress.currentValue = timeLeft
        tvStatus.text = getString(R.string.status_belajar)
        updateTimerText()
    }

    private fun handleSessionFinish() {
        if (!isBreakTime) {
            // selesai sesi belajar -> masuk istirahat
            isBreakTime = true
            timeLeft = if (sessionCount % 4 == 0) 1200 else 300 // istirahat panjang vs singkat
            tvStatus.text = "Istirahat"
        } else {
            // selesai istirahat -> sesi belajar baru
            isBreakTime = false
            sessionCount++
            timeLeft = totalTime
            tvStatus.text = getString(R.string.status_belajar)
        }
        circularProgress.maxValue = timeLeft
        circularProgress.currentValue = timeLeft
        updateTimerText()
    }

    private fun updateTimerText() {
        val minutes = timeLeft / 60
        val seconds = timeLeft % 60
        tvTimer.text = String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}