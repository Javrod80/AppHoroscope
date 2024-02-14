package com.example.apphoroscope.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apphoroscope.R
import com.example.apphoroscope.data.Horoscope

class HoroscopeAdapter(val items:List<Horoscope>) : RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)

        return HoroscopeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.nameTextView.text = holder.itemView.context.getString(items[position].name)
    }

}

class HoroscopeViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val nameTextView:TextView = view.findViewById(R.id.nameTextView)

}