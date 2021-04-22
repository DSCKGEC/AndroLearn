package com.example.androlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.adapters.CategoryAdapter
import com.example.androlearn.models.Category

class MainActivity : AppCompatActivity() {
    private lateinit var categoryRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryRV = findViewById(R.id.categoryRV)
        var categoryList: ArrayList<Category> = ArrayList()

        categoryList.add(Category(R.drawable.background, "Common", "Get started right here !"))
        categoryList.add(Category(R.drawable.background, "Text", "Getting User Input..."))
        categoryList.add(Category(R.drawable.background, "Buttons", "User Actions "))
        categoryList.add(Category(R.drawable.background, "Widgets", "Different widgets"))
        categoryList.add(Category(R.drawable.background, "Layouts", "How to Arrange your views?"))
        categoryList.add(Category(R.drawable.background, "Containers", "Definite size solutions"))
        categoryList.add(Category(R.drawable.background, "Third Party", "Open source libraries"))
        categoryList.add(Category(R.drawable.background, "Legacy", "Legacy widgets..."))
        val RVadapter = CategoryAdapter(categoryList)
        Log.i("RVV", "${categoryList.size}")
        categoryRV.layoutManager = LinearLayoutManager(this)
        categoryRV.adapter = RVadapter
    }
}