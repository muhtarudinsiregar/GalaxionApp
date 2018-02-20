package com.example.ardin.galaxionapps.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ardin on 19/02/18.
 */

fun ImageView.loadImageUrl(imageUrl: String?) {
    if(imageUrl != null) {
        Picasso.with(context)
                .load(imageUrl)
                .into(this)
    }
}