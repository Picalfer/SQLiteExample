package com.example.sqlitetest.database

import android.provider.BaseColumns

object MyDbNameClass {
    // BaseColumns чтобы автоматически каждой ячейке создавался идентификатор
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "content"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyTestDb.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," + // указываем, что в первой колонне идентификаторы
            "$COLUMN_NAME_TITLE TEXT," + // во второй колонне будет лежать название
            "$COLUMN_NAME_CONTENT TEXT)" // в третьей колонне будет лежать контент

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}

        // 0        title       content