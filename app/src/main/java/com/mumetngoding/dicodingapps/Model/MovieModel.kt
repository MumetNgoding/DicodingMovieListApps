package com.mumetngoding.dicodingapps.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel( var photo : Int? = null, var name: String? = null,
                       var description : String? = null, var leaguage : String? = null,
                       var status : String? = null, var runtime: String? = null): Parcelable