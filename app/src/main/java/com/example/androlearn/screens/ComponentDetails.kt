package com.example.androlearn.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R

class ComponentDetails : AppCompatActivity() {
    private  lateinit var necessaryRV : RecyclerView
    private  lateinit var optionalRV : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_details)
        necessaryRV=findViewById(R.id.necessaryRV)
//        optionalRV=findViewById(R.id.optionalRV)
    }
}