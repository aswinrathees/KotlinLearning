package com.opensource.samples.activities.rssfeed.helpers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

object RssFeedHandler {

    fun getRssFeed(url: String): LiveData<ArrayList<RssFeedModel>> {
        val liveData = MutableLiveData<ArrayList<RssFeedModel>>()
        CoroutineScope(Dispatchers.IO).launch {
            val data = getInputStream(URL(url))
            withContext(Dispatchers.Main) {
                liveData.value = data
            }
        }
        return liveData
    }

    suspend fun getInputStream(url: URL): ArrayList<RssFeedModel> = withContext(Dispatchers.IO) {
        val inputStreamData: ArrayList<RssFeedModel> = ArrayList()
        try {
            val connection = url.openConnection() as HttpURLConnection
            connection.inputStream.use {
                inputStreamData.addAll(getXmlParsedResult(it))
            }
        } catch (e: IOException) {
            inputStreamData.clear()
        }
        inputStreamData
    }

    fun getXmlParsedResult(inputStream: InputStream): ArrayList<RssFeedModel> {
        var title = ""
        var link = ""
        val rssFeedList = ArrayList<RssFeedModel>()

        return try {
            val parserFactory = XmlPullParserFactory.newInstance()
            parserFactory.isNamespaceAware = false

            val xmlPullParser = parserFactory.newPullParser()
            xmlPullParser.setInput(inputStream, "UTF_8")

            var isInsideItem = false
            var eventType = xmlPullParser.eventType

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (xmlPullParser.name == "item") {
                        isInsideItem = true
                    } else if (xmlPullParser.name == "title") {
                        if (isInsideItem) {
                            title = xmlPullParser.nextText()
                        }
                    } else if (xmlPullParser.name == "link") {
                        if (isInsideItem) {
                            link = xmlPullParser.nextText()
                        }
                    }

                    if (title.isNotEmpty() && link.isNotEmpty()) {
                        rssFeedList.add(RssFeedModel(title, link))
                    }
                } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.name == "item") {
                    isInsideItem = false
                }
                eventType = xmlPullParser.next()
            }
            Log.e("RssFeedActivity", "rssFeedList $rssFeedList")
            rssFeedList

        } catch (t: Throwable) {
            rssFeedList
        }
    }
}