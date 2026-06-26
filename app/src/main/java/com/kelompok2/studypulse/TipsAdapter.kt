package com.kelompok2.studypulse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(private val tips: ArrayList<Tip>) :
    RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconBg: FrameLayout = view.findViewById(R.id.iconBg)
        val icon: ImageView = view.findViewById(R.id.ivTipIcon)
        val title: TextView = view.findViewById(R.id.tvTipTitle)
        val desc: TextView = view.findViewById(R.id.tvTipDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.title.text = tip.title
        holder.desc.text = tip.description
        holder.icon.setImageResource(tip.iconRes)
        holder.iconBg.setBackgroundResource(tip.iconBgRes)
        holder.icon.setColorFilter(tip.iconTint)
    }

    override fun getItemCount(): Int = tips.size
}