package com.example.sqlitenewlesson.db

import android.provider.BaseColumns


object MyDbKotlinClass : BaseColumns {
    const val TABLE_NAME = "my_table" // название таблицы внутри базы данных
    const val COLUMN_NAME_TITLE = "title" // первая колонка таблицы
    const val COLUMN_NAME_CONTENT = "content" // вторая колонка таблицы

    const val DATABASE_VERSION = 1 //
    const val DATABASE_NAME =
        "MyLessonDb.db" // название базы данных, тип 'DATABASE name . расширение( формат .db)'

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXIST $TABLE_NAME (" +
            /**
             * в данной строке указана простейшая структура базы данных, с указанием названия
             * структурных элементов + указание типов данных для этих элементов
             * */
            "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
            "$COLUMN_NAME_TITLE TEXT, " +
            "$COLUMN_NAME_CONTENT TEXT" +
            ")"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}