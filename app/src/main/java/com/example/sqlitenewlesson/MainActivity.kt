package com.example.sqlitenewlesson

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlitenewlesson.db.MyDbManager

class MainActivity : AppCompatActivity() {
    lateinit var edit_title: EditText
    lateinit var edit_content: EditText
    lateinit var tv_text: TextView
    lateinit var on_click_save: Button

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_title = findViewById<EditText>(R.id.edit_title)
        edit_content = findViewById(R.id.edit_content)
        tv_text = findViewById(R.id.tv_text)
        on_click_save = findViewById(R.id.on_click_save)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dateList = myDbManager.readDbData()
        for (item in dateList) {
            tv_text.append(item)
            tv_text.append("\n")
        }
    }

    fun onClickSave(view: android.view.View) {
        tv_text.text = ""
        myDbManager.insertToDb(edit_title.text.toString(), edit_content.text.toString())
        val dateList = myDbManager.readDbData()
        for (item in dateList) {
            tv_text.append(item)
            tv_text.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}