package com.tutorials.photon.ui.theme.network

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class School(

    @Expose
    @SerializedName("dbn")
    val dbn: String,

    @Expose
    @SerializedName("school_name")
    val name: String,

    @Expose
    @SerializedName("overview_paragraph")
    val overview: String,

    @Expose
    @SerializedName("academicopportunities1")
    val academicopportunities1: String,


    @Expose
    @SerializedName("academicopportunities2")
    val academicopportunities2: String


) : Parcelable