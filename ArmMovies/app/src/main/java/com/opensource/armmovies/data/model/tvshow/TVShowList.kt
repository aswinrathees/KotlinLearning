package com.opensource.armmovies.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val results: List<TVShow>
)