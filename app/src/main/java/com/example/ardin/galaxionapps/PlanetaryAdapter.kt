package com.example.ardin.galaxionapps

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ardin.galaxionapps.data.model.Planetary
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_layout.view.*

class PlanetaryAdapter(val lists: List<Planetary>) : RecyclerView.Adapter<PlanetaryItem>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlanetaryItem {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return PlanetaryItem(v)
    }

    override fun getItemCount() = lists.size

    override fun onBindViewHolder(holder: PlanetaryItem?, position: Int) {
        holder?.bindData(lists[position])
    }
}

class PlanetaryItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(planetary: Planetary) {
        itemView.itemTitle.text = planetary.title
        itemView.itemDescription.text = planetary.explanation
        Picasso.with(itemView.context).load(planetary.hdurl).into(itemView.itemImage)

    }
}