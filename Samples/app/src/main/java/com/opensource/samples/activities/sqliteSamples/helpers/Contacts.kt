package com.opensource.samples.activities.sqliteSamples.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object ContactTable {

    val KEY_ROW_ID: String = "_id"
    val KEY_NAME: String = "contact_name"
    val KEY_MOBILE: String = "contact_number"

    val DATABASE_NAME: String = "contacts"
    val DATABASE_TABLE: String = "contacts_table"
    val DATABASE_VERSION: Int = 1
}

class Contacts(private val context: Context) {

    var dbHelper: DBHelper? = null
    var sqlite: SQLiteDatabase? = null

    class DBHelper(context: Context): SQLiteOpenHelper(context, ContactTable.DATABASE_NAME, null, ContactTable.DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase?) {
            val sqlQuery = "CREATE TABLE ${ContactTable.DATABASE_TABLE} ( ${ContactTable.KEY_ROW_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${ContactTable.KEY_NAME} TEXT NOT NULL, ${ContactTable.KEY_MOBILE} TEXT UNIQUE NOT NULL )"
            db?.execSQL(sqlQuery)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS ${ContactTable.DATABASE_TABLE}")
            onCreate(db)
        }

    }

    fun open(): Contacts {
        dbHelper = DBHelper(context)
        sqlite = dbHelper?.writableDatabase
        return this
    }

    fun close() {
        dbHelper?.close()
    }

    fun addEntry(name: String, mobile: String): Long {
        val contentValues = ContentValues()
        contentValues.put(ContactTable.KEY_NAME, name)
        contentValues.put(ContactTable.KEY_MOBILE, mobile)
        return sqlite?.insert(ContactTable.DATABASE_TABLE, null, contentValues)!!
    }

    fun getData(): String {
        var columns = arrayOf(ContactTable.KEY_ROW_ID, ContactTable.KEY_NAME, ContactTable.KEY_MOBILE)
        val cursor = sqlite?.query(ContactTable.DATABASE_TABLE, columns, null, null, null, null, null)
        var data = ""

        val rowIdIndex = cursor?.getColumnIndex(ContactTable.KEY_ROW_ID)
        val nameIndex = cursor?.getColumnIndex(ContactTable.KEY_NAME)
        val mobileIndex = cursor?.getColumnIndex(ContactTable.KEY_MOBILE)

        for (i in 0 until cursor?.count!!) {
            cursor.moveToNext()
            data = data + cursor.getString(rowIdIndex!!) + " " + cursor.getString(nameIndex!!) + " " + cursor.getString(mobileIndex!!) + "\n"
        }

        cursor.close()

        return data
    }

    fun deleteEntry(rowId: String): Int {
        return sqlite?.delete(ContactTable.DATABASE_TABLE, ContactTable.KEY_ROW_ID + "=?", arrayOf(rowId)) ?: 0
    }

    fun updateEntry(rowId: String, name: String, mobile: String): Int {
        val contentValues = ContentValues()
        contentValues.put(ContactTable.KEY_NAME, name)
        contentValues.put(ContactTable.KEY_MOBILE, mobile)
        return sqlite?.update(ContactTable.DATABASE_TABLE, contentValues, ContactTable.KEY_ROW_ID + "=?", arrayOf(rowId)) ?: 0
    }
}