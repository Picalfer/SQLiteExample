package com.example.sqlitetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlitetest.database.MyDbManager
import com.example.sqlitetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        b.button2.setOnClickListener {
            b.tvResult.text = ""
            myDbManager.insertToDb(b.edTitle.text.toString(), b.edContent.text.toString())
            val dataList = myDbManager.readDbData()
            for (item in dataList) {
                b.tvResult.append(item)
                b.tvResult.append("\n")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()
        for (item in dataList) {
            b.tvResult.append(item)
            b.tvResult.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}