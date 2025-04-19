package com.opensource.armmovies.presentation.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        setContentView(bindingUtil.root)
    }
}