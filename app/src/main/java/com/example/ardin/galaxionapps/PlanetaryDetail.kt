package com.example.ardin.galaxionapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ardin.galaxionapps.util.loadImageUrl
import kotlinx.android.synthetic.main.activity_planetary_detail.*

/**
 * Created by ardin on 19/02/18.
 */
class PlanetaryDetail : AppCompatActivity() {
    val selectedExplanation: String by lazy {
        intent.getStringExtra("explanation") ?: "-"

    }
    val selectedPhoto: String? by lazy {
        intent.getStringExtra("photoUrl")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planetary_detail)

        photoImageView?.loadImageUrl(selectedPhoto)
        photoDescription?.text = selectedExplanation
    }
}