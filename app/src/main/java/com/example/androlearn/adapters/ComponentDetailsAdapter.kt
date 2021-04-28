package com.example.androlearn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.models.AttributeDetail

class ComponentDetailsAdapter(var attributeDetailsList: ArrayList<AttributeDetail>) :
    RecyclerView.Adapter<ComponentDetailsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.detailTitle)
        val info: TextView = itemView.findViewById(R.id.detailInfo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.detail_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = attributeDetailsList[position]
        holder.title.text = item.att_name
        holder.info.text = item.att_desc
    }

    override fun getItemCount(): Int {
        return attributeDetailsList.size
    }
}