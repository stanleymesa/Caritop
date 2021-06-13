package com.example.caritop

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelLaptop(
    var merk: String = "",
    var name: String = "",
    var photo: Int = 0,
    var desc: String = "",
    var harga: String = ""
) : Parcelable