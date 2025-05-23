package com.opensource.roomdemoone.helpers

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opensource.roomdemoone.model.Subscriber

@Dao
interface SubscriberDao {
    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    //Can use FLow instead of LiveData here
    fun getAllSubscribers(): LiveData<List<Subscriber>>
}