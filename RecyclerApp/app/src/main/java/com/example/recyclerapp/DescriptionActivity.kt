package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rintent = intent
        val food = rintent.getSerializableExtra("food") as Food
        descriptionImageView.setImageResource(food.image)
        titleTextView.text = food.name
        descriptionTextView.text = food.recipe
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}