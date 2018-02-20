package com.example.ardin.galaxionapps.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Planetary(
        val date: String,
        val explanation: String,
        val hdurl: String,
        val service_version: String,
        val title: String,
        val url: String,
        val media_type: String
) : Parcelable