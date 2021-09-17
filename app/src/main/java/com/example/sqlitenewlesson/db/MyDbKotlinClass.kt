package com.example.sqlitenewlesson.db

import android.provider.BaseColumns // интерфейс работающий с базой данных, уже имеющий в себе переменную id


object MyDbKotlinClass : BaseColumns {
    const val TABLE_NAME = "my_table" // название таблицы внутри базы данных
    const val  COLUMN_NAME_TITLE = "title" // первая колонка таблицы
    const val  COLUMN_NAME_SUBTITLE = "subtitle" // вторая колонка таблицы

    const val DATABASE_VERSION = 1 //
    const val DATABASE_NAME = "MyLessonDb.db" // название базы данных, тип 'DATABASE name . расширение'
    
}