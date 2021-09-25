package com.example.sqlitenewlesson.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null // класс для открытия базы

    fun openDb() {
        db = myDbHelper.writableDatabase
    } // создание функции отвечающей за дальнейший функционал базы

    fun insertToDb(title: String, content: String) { // функция для сохранения базы данных
        val values = ContentValues().apply {
            put(MyDbKotlinClass.COLUMN_NAME_TITLE, title)
            put(MyDbKotlinClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDbKotlinClass.TABLE_NAME, null, values)

    }

    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>() // функция для считывания базы данных
        val cursor = db?.query(MyDbKotlinClass.TABLE_NAME, null, null,
            null, null, null, null)// метод дя считывания базы данных


        while (cursor?.moveToNext()!!) {
            val titleIndex = cursor.getColumnIndex(MyDbKotlinClass.COLUMN_NAME_TITLE)
            if (titleIndex >= 0) {
                val dateText = cursor.getString(titleIndex)
                dataList.add(dateText.toString()) // курсор
            }
        }
        cursor.close()
        return dataList
    }
    fun closeDb() {
        myDbHelper.close()
    }
}