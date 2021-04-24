package com.example.androlearn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androlearn.R
import com.example.androlearn.models.ComponentDetail

 class ComponentDetailsAdapter(var componentDetailsList : ArrayList<ComponentDetail>) : RecyclerView.Adapter<ComponentDetailsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val title : TextView= itemView.findViewById(R.id.detailTitle)
        val info : TextView= itemView.findViewById(R.id.detailInfo)

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val layoutInflater= LayoutInflater.from(parent.context)
         val view : View = layoutInflater.inflate(R.layout.detail_item,parent,false)
         return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item = componentDetailsList[position]
         holder.title.text=item.title
         holder.info.text=item.details
     }

     override fun getItemCount(): Int {
         return componentDetailsList.size
     }
 }