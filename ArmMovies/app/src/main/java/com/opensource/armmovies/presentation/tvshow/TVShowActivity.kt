package com.opensource.armmovies.presentation.tvshow

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityTvShowBinding
import com.opensource.armmovies.presentation.di.interfaces.Injector
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion.factory
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityTvShowBinding
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var tvShowAdapter: TVShowAdapter

    @Inject
    lateinit var factory: TVShowViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTVShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TVShowViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        bindingUtil.tvShowList.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TVShowAdapter()
        bindingUtil.tvShowList.adapter = tvShowAdapter

        displayPopularTVShows()
    }

    private fun displayPopularTVShows() {
        bindingUtil.tvShowProgressBar.visibility = View.VISIBLE
        val responseData = tvShowViewModel.getTVShows()
        responseData.observe(this) {

            when {
                it != null -> {
                    tvShowAdapter.setList(it)
                    tvShowAdapter.notifyDataSetChanged()
                    bindingUtil.tvShowProgressBar.visibility = View.GONE
                }

                else -> {
                    bindingUtil.tvShowProgressBar.visibility = View.GONE
                }
            }
        }
    }
}