package com.opensource.armmovies.presentation.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityTvShowBinding

class TVShowActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}