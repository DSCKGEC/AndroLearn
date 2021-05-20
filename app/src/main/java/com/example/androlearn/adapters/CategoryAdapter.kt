package com.example.androlearn.adapters

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.androlearn.R
import com.example.androlearn.models.Category
//import com.example.androlearn.models.Component
import com.example.androlearn.screens.CategoryItems


class CategoryAdapter(var categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val background: ImageView = itemView.findViewById<ImageView>(R.id.backgroundImage)
        val subTitle: TextView = itemView.findViewById(R.id.subtitle)
        val title: TextView = itemView.findViewById(R.id.title)
        var compList: ArrayList<String> = ArrayList()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val displayMetrics : DisplayMetrics = DisplayMetrics()
//        (holder.itemView.context as Activity).windowManager.defaultDisplay.getRealMetrics(displayMetrics)
//        val width: Int = displayMetrics.widthPixels;

        //Toast.makeText(holder.itemView.context, ""+width, Toast.LENGTH_LONG).show()

        val categoryItem = categoryList[position]
        //Toast.makeText(holder.itemView.context, categoryItem.imageUrl, Toast.LENGTH_LONG).show()
        Glide.with(holder.itemView.context)
            .load(categoryItem.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.background)
            .error(R.drawable.background)
            .timeout(60000)
            .into(holder.background)
//        holder.background.setBackgroundResource(categoryItem.imageUrl)
        holder.subTitle.text = categoryItem.subtitle
        holder.title.text = categoryItem.title
        holder.compList = categoryItem.complist

        //Toast.makeText(holder.itemView.context, ""+holder.compList[0], Toast.LENGTH_LONG).show()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CategoryItems::class.java)
            if(holder.compList.size > 0){
                intent.putExtra("compList", holder.compList)
                intent.putExtra("categoryTitle", holder.title.text.toString())
                holder.itemView.context.startActivity(intent)
            }else{
                Toast.makeText(holder.itemView.context, "Component List isn't added yet!!!",Toast.LENGTH_SHORT).show()
            }
            //intent.putExtra("title", "${categoryItem.title}")

            //intent.putStringArrayListExtra("compList", holder.compList)

        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}
