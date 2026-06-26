package com.kelompok2.studypulse

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TipsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        findViewById<android.widget.ImageView>(R.id.btnBack).setOnClickListener { finish() }

        val tips = arrayListOf(
            Tip(
                "Matikan Notifikasi",
                "Hindari gangguan dari notifikasi ponsel.",
                R.drawable.ic_bell,
                R.drawable.bg_icon_soft_purple,
                Color.parseColor("#8B7BD8")
            ), Tip(
                "Rapikan Meja",
                "Meja yang rapi membuat pikiran lebih jernih.",
                R.drawable.ic_desk,
                R.drawable.bg_icon_soft_green,
                Color.parseColor("#4CAF6D")
            ), Tip(
                "Minum Air",
                "Tubuh terhidrasi membuat otak bekerja lebih baik.",
                R.drawable.ic_water,
                R.drawable.bg_icon_soft_blue,
                Color.parseColor("#4A90D9")
            ), Tip(
                "Fokus pada Tujuan",
                "Ingat tujuanmu dan jangan mudah terdistraksi.",
                R.drawable.ic_target,
                R.drawable.bg_icon_soft_red,
                Color.parseColor("#E8765C")
            ), Tip(
                "Gunakan Headset / Musik",
                "Musik instrumental dapat meningkatkan fokus.",
                R.drawable.ic_headset,
                R.drawable.bg_icon_soft_orange,
                Color.parseColor("#F5A623")
            )
        )

        val rv = findViewById<RecyclerView>(R.id.rvTips)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = TipsAdapter(tips)
    }
}