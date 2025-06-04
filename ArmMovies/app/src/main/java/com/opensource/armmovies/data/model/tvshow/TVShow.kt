package com.opensource.armmovies.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tv_shows")
data class TVShow(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdropPath")
    val backdropPath: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("originalLanguage")
    val originalLanguage: String,
    @SerializedName("originalTitle")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("posterPath")
    val posterPath: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("voteAverage")
    val voteAverage: Double,
    @SerializedName("voteCount")
    val voteCount: Int
)