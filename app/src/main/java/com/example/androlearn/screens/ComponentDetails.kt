package com.example.androlearn.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.adapters.ComponentDetailsAdapter
import com.example.androlearn.models.ComponentDetail

class ComponentDetails : AppCompatActivity() {
    private  lateinit var necessaryRV : RecyclerView
    private  lateinit var optionalRV : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_details)
        necessaryRV=findViewById(R.id.necessaryRV)
        optionalRV=findViewById(R.id.optionalRV)
        var necessaryComponentDetailsList : ArrayList<ComponentDetail> = ArrayList()
        var optionalComponentDetailsList : ArrayList<ComponentDetail> = ArrayList()

      necessaryComponentDetailsList.add(ComponentDetail("layout_height","Gives a definite height to the view , it can be match_parent , wrap_content or any user definitive amount"))
        necessaryComponentDetailsList.add(ComponentDetail("layout_width","Gives a definite width to the view , it can be match_parent , wrap_content or any user definitive amount"))
        necessaryComponentDetailsList.add(ComponentDetail("text","Gives a text to the view"))


       optionalComponentDetailsList.add(ComponentDetail("layout_height","Gives a definite height to the view , it can be match_parent , wrap_content or any user definitive amount"))
        optionalComponentDetailsList.add(ComponentDetail("layout_width","Gives a definite width to the view , it can be match_parent , wrap_content or any user definitive amount"))
        optionalComponentDetailsList.add(ComponentDetail("text","Gives a text to the view"))
        necessaryRV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        optionalRV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        necessaryRV.adapter=ComponentDetailsAdapter(necessaryComponentDetailsList)

        optionalRV.adapter=ComponentDetailsAdapter(optionalComponentDetailsList)



    }
}