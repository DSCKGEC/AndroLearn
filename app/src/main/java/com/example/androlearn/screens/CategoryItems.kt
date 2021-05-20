package com.example.androlearn.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.adapters.ComponentsAdapter
import com.example.androlearn.models.Category
//import com.example.androlearn.models.Component

class CategoryItems : AppCompatActivity() {
    private lateinit var categoryItemsRV : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val categoryTitle : String? = intent.getStringExtra("title")
        val compList : ArrayList<String> = intent.getStringArrayListExtra("compList") as ArrayList<String>

        setContentView(R.layout.activity_category_items)

        val categoryTitle: String? = intent.getStringExtra("categoryTitle")
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = categoryTitle

        Toast.makeText(this, ""+ categoryTitle, Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, ""+ compList[1], Toast.LENGTH_SHORT).show()

        categoryItemsRV=findViewById(R.id.categoryItemsRV)
        var componentList: ArrayList<String> = ArrayList()
        componentList = compList

//        componentList.add(Component("$categoryTitle"))
//        componentList.add(Component("$categoryTitle"))
//        componentList.add(Component("$categoryTitle"))
        val componentItemsAdapter = ComponentsAdapter(componentList)
        categoryItemsRV.layoutManager = LinearLayoutManager(this)
        categoryItemsRV.adapter =componentItemsAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}