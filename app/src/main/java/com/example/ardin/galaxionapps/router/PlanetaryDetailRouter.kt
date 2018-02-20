package com.example.ardin.galaxionapps.router

import android.content.Context
import android.content.Intent
import com.example.ardin.galaxionapps.PlanetaryDetail

/**
 * Created by ardin on 19/02/18.
 */

fun Context.openPlanetaryDetail(explanation: String = "-",
                        photoUrl: String? = null) {
    val showPhotoIntent = Intent(this, PlanetaryDetail::class.java)
            .apply {
                putExtra("explanation", explanation)
                putExtra("photoUrl", photoUrl)
            }
    startActivity(showPhotoIntent)
}