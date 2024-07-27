package com.opensource.samples.activities.fragmentSamples.fragments.placeholder

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    fun setItems(items: Pair<Array<String>, Array<String>>) {
        val (title, content) = items
        for ((index, item) in title.zip(content).withIndex()) {
            val position = index + 1
            addItem(PlaceholderItem(position.toString(), item.first, item.second))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String = "", val content: String, val details: String) {
        override fun toString(): String = content
    }
}