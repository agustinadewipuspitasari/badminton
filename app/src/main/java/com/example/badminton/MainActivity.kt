package com.example.badminton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.badminton_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this,items)

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.badminton_name)
        val image = resources.obtainTypedArray(R.array.badminton_image)

        items.clear()

        for (i in name.indices){
            items.add(Item(name[i],image.getResourceId(i,0)))
        }

        image.recycle()
    }
}



