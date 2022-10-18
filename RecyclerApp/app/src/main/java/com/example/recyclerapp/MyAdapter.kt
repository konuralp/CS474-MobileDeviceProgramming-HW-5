package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food_list.view.*

class MyAdapter(var fList: ArrayList<Food>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var onItemClick: ((Food) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_food_list, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val food = fList[position]
        holder.itemView.name.text = food.name
        holder.itemView.imageView.setImageResource(food.image)
    }

    override fun getItemCount(): Int {
        return fList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(fList[adapterPosition])
            }
        }
    }

}
