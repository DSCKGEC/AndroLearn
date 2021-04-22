package com.example.androlearn.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.adapters.ComponentsAdapter
import com.example.androlearn.models.Category
import com.example.androlearn.models.Component

class CategoryItems : AppCompatActivity() {
    private lateinit var categoryItemsRV : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var categoryTitle : String? = intent.getStringExtra("title")

        setContentView(R.layout.activity_category_items)
        categoryItemsRV=findViewById(R.id.categoryItemsRV)
        var componentList: ArrayList<Component> = ArrayList()
        componentList.add(Component("$categoryTitle"))
        componentList.add(Component("$categoryTitle"))
        componentList.add(Component("$categoryTitle"))
        val componentItemsAdapter = ComponentsAdapter(componentList)
        categoryItemsRV.layoutManager = LinearLayoutManager(this)
        categoryItemsRV.adapter =componentItemsAdapter

    }
}