package com.example.androlearn.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.adapters.CategoryAdapter
import com.example.androlearn.adapters.ComponentDetailsAdapter
import com.example.androlearn.firestorequery.FireStoreQuery
import com.example.androlearn.models.AttributeDetail
import com.example.androlearn.models.ComponentDetail

class ComponentDetails : AppCompatActivity() {

    private lateinit var necessaryRV: RecyclerView
    private lateinit var optionalRV: RecyclerView
    private lateinit var componentDesc: TextView
    private lateinit var componentImg: ImageView
    private lateinit var componentDetailList: ArrayList<ComponentDetail>
    private lateinit var necessaryAttributeDetailsList: ArrayList<AttributeDetail>
    private lateinit var optionalAttributeDetailsList: ArrayList<AttributeDetail>
    private lateinit var nessAttAdapter : ComponentDetailsAdapter
    private lateinit var othAttAdapter : ComponentDetailsAdapter
    private val fireStoreQuery: FireStoreQuery = FireStoreQuery()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_details)

        necessaryRV = findViewById(R.id.necessaryRV)
        optionalRV = findViewById(R.id.optionalRV)
        componentImg = findViewById(R.id.componentImg)
        componentDesc = findViewById(R.id.componentDesc)

        val compTitle : String? = intent.getStringExtra("compTitle")

        componentDetailList = ArrayList()
        necessaryAttributeDetailsList = ArrayList()
        optionalAttributeDetailsList = ArrayList()

        if (compTitle != null) {
            loadComponentDetail(compTitle)
        }

        nessAttAdapter = ComponentDetailsAdapter(necessaryAttributeDetailsList)
        othAttAdapter = ComponentDetailsAdapter(optionalAttributeDetailsList)

        necessaryRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        optionalRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        necessaryRV.adapter = nessAttAdapter
        optionalRV.adapter = othAttAdapter

    }

    private fun loadComponentDetail(compTitle : String) {

        fireStoreQuery.getComponents(compTitle)
            .addOnSuccessListener { results ->

                if (!results.isEmpty){

                    for (result in results) {
                        componentDetailList.add(result.toObject(ComponentDetail::class.java))
                    }
                    componentDesc.text = componentDetailList[0].comp_desc

                    for (nessAttDetail in componentDetailList[0].comp_ness_att) {
                        necessaryAttributeDetailsList.add(AttributeDetail(nessAttDetail["att_desc"], nessAttDetail["att_name"]))
                    }

                    for(othAttDetail in componentDetailList[0].comp_oth_att) {
                        optionalAttributeDetailsList.add(AttributeDetail(othAttDetail["att_desc"], othAttDetail["att_name"]))
                    }

                    nessAttAdapter.attributeDetailsList = necessaryAttributeDetailsList
                    othAttAdapter.attributeDetailsList = optionalAttributeDetailsList

                    nessAttAdapter.notifyDataSetChanged()
                    othAttAdapter.notifyDataSetChanged()

                }else{
                    Toast.makeText(this, "No Such data Exist!!!", Toast.LENGTH_SHORT).show()
                }

            }
            .addOnCanceledListener {
                Toast.makeText(this, "Something went wrong!!!", Toast.LENGTH_SHORT).show()
            }
    }
}