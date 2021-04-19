package com.example.androlearn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.models.Category


class CategoryAdapter(var categoryList:ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val background: ImageView = itemView.findViewById<ImageView>(R.id.backgroundImage)
        val subTitle : TextView=itemView.findViewById(R.id.subtitle)
        val title: TextView=itemView.findViewById(R.id.title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.category_item,parent,false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryItem= categoryList[position]
        holder.background.setBackgroundResource(categoryItem.imageUrl)
        holder.subTitle.text=categoryItem.subtitle
        holder.title.text=categoryItem.title
    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }
}
