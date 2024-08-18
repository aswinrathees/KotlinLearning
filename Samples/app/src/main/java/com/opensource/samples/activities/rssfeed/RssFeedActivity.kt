package com.opensource.samples.activities.rssfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opensource.samples.R
import com.opensource.samples.activities.rssfeed.helpers.RssFeedAdapter
import com.opensource.samples.activities.rssfeed.helpers.RssFeedHandler.getRssFeed

class RssFeedActivity : AppCompatActivity() {

    lateinit var rssFeedList: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var rssFeedAdapter: RssFeedAdapter

    val rssFeedUrl = "https://feeds.capi24.com/v1/Search/articles/fin24/tech/rss"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_rss_feed)
        rssFeedList = findViewById(R.id.rv_rss_feed_list)
        layoutManager =  LinearLayoutManager(this)
        rssFeedList.layoutManager = layoutManager

        val feedData = getRssFeed(rssFeedUrl)
        feedData.observe(this) { data ->
            if (data.isNotEmpty()) {
                rssFeedAdapter = RssFeedAdapter(data)
                rssFeedList.adapter = rssFeedAdapter
            }
        }
    }
}