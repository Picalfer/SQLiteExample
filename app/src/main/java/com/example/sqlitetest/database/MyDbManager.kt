package com.example.sqlitetest.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    private val myDbHelper = MyDbHelper(context) // создаем базу данных
    var db: SQLiteDatabase? = null // инструмент с помощью которого мы будем что-то делать с бд

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDbData() : ArrayList<String> { // если хотим считать информацию с базы данных
        val dataList = ArrayList<String>()

        val cursor = db?.query(MyDbNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null)

        while (cursor?.moveToNext()!!) {
            val dataText = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NAME_TITLE))
            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }

    fun closeDb() {
        myDbHelper.close()
    }
}

// этот класс нужен чтобы кратко с помощью его функций пользоваться бд
// https://www.youtube.com/watch?v=tQot9NMbtiw&t=324s&ab_channel=NecoRu