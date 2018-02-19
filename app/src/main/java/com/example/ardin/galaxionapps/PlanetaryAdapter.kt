package com.example.ardin.galaxionapps

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ardin.galaxionapps.`interface`.RecyclerListener
import com.example.ardin.galaxionapps.data.model.Planetary
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_layout.view.*
import kotlinx.android.synthetic.main.planetary_image_slider.view.*

class PlanetaryAdapter(val lists: List<Planetary>, private val clickListener: RecyclerListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), PlanetaryListener {

    private val PLANETARY: Int = 0
    private val IMAGE_PLANETARY: Int = 1

    override fun onItemClick(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            clickListener.onClick(lists[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder

        when (viewType) {
            PLANETARY -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
                viewHolder = PlanetaryItem(v, this)
            }
            IMAGE_PLANETARY -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.planetary_image_slider, parent, false)
                viewHolder = PlanetaryImage(v)
            }
            else -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
                viewHolder = PlanetaryItem(v, this)
            }
        }
        return viewHolder
    }

    override fun getItemCount() = lists.size

    override fun getItemViewType(position: Int): Int {
        if (position == PLANETARY) {
            return PLANETARY
        } else if (position == IMAGE_PLANETARY) {
            return IMAGE_PLANETARY
        }

        return -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder?.itemViewType) {
            PLANETARY -> {
                val vh1 = holder as PlanetaryItem
                vh1.bindData(lists[position])
            }
            IMAGE_PLANETARY -> {
                val vh2 = holder as PlanetaryImage
                Log.d("PLANETARY_IMAGE", lists[position].toString())
                vh2.bindData(lists[position])
            }
        }
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
    }
}


class PlanetaryImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(planetary: Planetary) {
        Log.d("NTAK", planetary.toString())
        Picasso.with(itemView.context).load(planetary.hdurl).into(itemView.imageSlider)
    }
}
