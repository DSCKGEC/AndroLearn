package com.example.androlearn.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
//import com.example.androlearn.models.Component
import com.example.androlearn.screens.CategoryItems
import com.example.androlearn.screens.ComponentDetails

class ComponentsAdapter(var componentList: ArrayList<String>) :
    RecyclerView.Adapter<ComponentsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.componentName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.component_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = componentList[position]
        holder.title.text = item
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ComponentDetails::class.java)
            intent.putExtra("compTitle", holder.title.text)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return componentList.size
    }
}