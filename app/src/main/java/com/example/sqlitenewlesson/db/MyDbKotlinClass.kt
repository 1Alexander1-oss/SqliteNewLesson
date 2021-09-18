package com.example.sqlitenewlesson.db

import android.os.FileObserver.CREATE
import android.provider.BaseColumns // интерфейс работающий с базой данных, уже имеющий в себе переменную id
import java.text.Collator.PRIMARY


object MyDbKotlinClass : BaseColumns {
    const val TABLE_NAME = "my_table" // название таблицы внутри базы данных
    const val COLUMN_NAME_TITLE = "title" // первая колонка таблицы
    const val COLUMN_NAME_CONTENT = "content" // вторая колонка таблицы

    const val DATABASE_VERSION = 1 //
    const val DATABASE_NAME =
        "MyLessonDb.db" // название базы данных, тип 'DATABASE name . расширение'

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXIST $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT, $COLUMN_NAME_CONTENT TEXT)" // в данной строке указана простейшая структура базы данных, с указанием названия структурных элементов + указание типов данных для этих элементов
}