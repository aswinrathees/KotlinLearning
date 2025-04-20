package com.opensource.armmovies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityHomeBinding
import com.opensource.armmovies.presentation.artist.ArtistActivity
import com.opensource.armmovies.presentation.movie.MovieActivity
import com.opensource.armmovies.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_home)
        initViews()
    }

    private fun initViews() {
        bindingUtil.movieButton.setOnClickListener {
            startActivity(MovieActivity::class.java)
        }

        bindingUtil.tvShowButton.setOnClickListener {
            startActivity(TVShowActivity::class.java)
        }

        bindingUtil.artistButton.setOnClickListener {
            startActivity(ArtistActivity::class.java)
        }
    }

    private fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}