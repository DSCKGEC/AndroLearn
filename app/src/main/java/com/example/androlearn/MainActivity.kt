package com.example.androlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.firestorequery.FireStoreQuery
import com.example.androlearn.adapters.CategoryAdapter
import com.example.androlearn.models.Category
import com.example.androlearn.screens.CategoryItems
import com.google.android.gms.tasks.OnSuccessListener

class MainActivity : AppCompatActivity() {

    private val fireStoreQuery: FireStoreQuery = FireStoreQuery()

    private lateinit var categoryRV: RecyclerView
    private lateinit var categoryList: ArrayList<Category>
    private lateinit var RVadapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryRV = findViewById(R.id.categoryRV)

        categoryList = ArrayList()

        loadCategory()

        RVadapter = CategoryAdapter(categoryList)
        Log.i("RVV", "${categoryList.size}")
        categoryRV.layoutManager = LinearLayoutManager(this)
        categoryRV.adapter = RVadapter
    }

    private fun loadCategory() {
        fireStoreQuery.getCategories()
            .addOnSuccessListener { results ->
                if(!results.isEmpty){
                    for(result in results) {
                        categoryList.add(result.toObject(Category::class.java))
                    }
                    RVadapter.categoryList = categoryList
                    RVadapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this, "No Such data Exist!!!", Toast.LENGTH_SHORT).show()
                }

            }
            .addOnCanceledListener {
                Toast.makeText(this, "Something went wrong!!!", Toast.LENGTH_SHORT).show()
            }
    }
}