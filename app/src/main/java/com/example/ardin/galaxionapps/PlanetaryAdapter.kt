package com.example.ardin.galaxionapps

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ardin.galaxionapps.`interface`.RecyclerListener
import com.example.ardin.galaxionapps.data.model.Planetary
import com.example.ardin.galaxionapps.util.loadImageUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_layout.view.*
import kotlinx.android.synthetic.main.planetary_image_slider.view.*

class PlanetaryAdapter(val lists: List<Planetary>, private val clickListener: RecyclerListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val PLANETARY: Int = 0
    private val IMAGE_PLANETARY: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder

        when (viewType) {
            IMAGE_PLANETARY -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.planetary_image_slider, parent, false)
                viewHolder = PlanetaryImage(v)
            }
            else -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
                viewHolder = PlanetaryItem(v)
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
                Log.d("PlanetaryAdapter", lists[position].toString())
                vh2.bindData(lists[position])
            }
        }
    }

    inner class PlanetaryItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener.onClick(lists[adapterPosition])
                }
            }
        }

        fun bindData(planetary: Planetary) {
            itemView.itemTitle.text = planetary.title
            itemView.itemDescription.text = planetary.explanation
            itemView.itemImage.loadImageUrl(planetary.url)
        }
    }

    inner class PlanetaryImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(planetary: Planetary) {
            Picasso.with(itemView.context).load(planetary.url).into(itemView.imagePlanetary)
        }
    }
}