package com.example.ardin.galaxionapps

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ardin.galaxionapps.`interface`.RecyclerListener
import com.example.ardin.galaxionapps.data.model.Planetary
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_layout.view.*

class PlanetaryAdapter(val lists: List<Planetary>, private val clickListener: RecyclerListener)
    : RecyclerView.Adapter<PlanetaryItem>(), PlanetaryListener {
    override fun onItemClick(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            clickListener.onClick(lists[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlanetaryItem {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return PlanetaryItem(v, this)
    }

    override fun getItemCount() = lists.size

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }

    override fun onBindViewHolder(holder: PlanetaryItem?, position: Int) {
        holder?.bindData(lists[position])
    }
}

interface PlanetaryListener {
    fun onItemClick(position: Int)
}

class PlanetaryItem(itemView: View, val planetaryListener: PlanetaryListener) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            planetaryListener.onItemClick(adapterPosition)
        }
    }

    fun bindData(planetary: Planetary) {
        itemView.itemTitle.text = planetary.title
        itemView.itemDescription.text = planetary.explanation
        Picasso.with(itemView.context).load(planetary.hdurl).into(itemView.itemImage)

    }
}

