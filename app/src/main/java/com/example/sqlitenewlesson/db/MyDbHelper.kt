package com.example.sqlitenewlesson.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(
    context: Context
): SQLiteOpenHelper(
    context,
    MyDbKotlinClass.DATABASE_NAME,
null,
    MyDbKotlinClass.DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDbKotlinClass.CREATE_TABLE)
        // создание базы данных

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDbKotlinClass.SQL_DELETE_TABLE)
        onCreate(db)
        // обнивление базы данных

    }

}