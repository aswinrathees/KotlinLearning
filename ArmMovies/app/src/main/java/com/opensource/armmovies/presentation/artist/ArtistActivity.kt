package com.opensource.armmovies.presentation.artist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityArtistBinding
import com.opensource.armmovies.presentation.di.interfaces.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityArtistBinding
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var artistAdapter: ArtistAdapter

    @Inject
    lateinit var factory: ArtistViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        bindingUtil.artistList.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        bindingUtil.artistList.adapter = artistAdapter

        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        bindingUtil.artistProgressBar.visibility = View.VISIBLE
        val responseData = artistViewModel.getArtists()
        responseData.observe(this) {
            when {
                it != null -> {
                    artistAdapter.setList(it)
                    artistAdapter.notifyDataSetChanged()
                    bindingUtil.artistProgressBar.visibility = View.GONE
                }

                else -> {
                    bindingUtil.artistProgressBar.visibility = View.GONE
                }
            }
        }
    }
}