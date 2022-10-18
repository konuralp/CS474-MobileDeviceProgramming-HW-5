package com.example.recyclerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var foodList: ArrayList<Food> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFoods()

        // Set the Layout Manager
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(foodList)
        // Set adapter to your RecyclerView
        recyclerView.adapter = adapter

        adapter.onItemClick = { food ->
            val rintent = Intent(this, DescriptionActivity::class.java)
            rintent.putExtra("food", food)
            startActivity(rintent)
        }
    }

    fun loadFoods(){
        val titles = resources.getStringArray(R.array.food_titles)
        val recipes = resources.getStringArray(R.array.food_recipes)
        val images = resources.obtainTypedArray(R.array.food_images)

        for (i in titles.indices) {
            foodList.add(Food(titles[i], recipes[i], images.getResourceId(i, 0)))
        }
        images.recycle()
    }
}