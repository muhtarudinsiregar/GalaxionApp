package com.example.ardin.galaxionapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ListAdapter(this, getLists())
    }

    fun getLists(): ArrayList<String> {
        val lists = ArrayList<String>()
        lists.add("Android")
        lists.add("Kotlin")
        lists.add("Java")

        return lists
    }
}
