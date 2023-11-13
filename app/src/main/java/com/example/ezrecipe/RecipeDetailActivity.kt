package com.example.ezrecipe

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            // Handle the back action
            finish()
        }

        // Retrieve the character details passed from the previous activity
        val recipeName = intent.getStringExtra("RECIPE_TITLE")
        val recipeDescription = intent.getStringExtra("RECIPE_INSTRUCTION")
        val recipeImageUrl = intent.getStringExtra("RECIPE_IMAGE_URL")
        val recipeIngredients = intent.getStringExtra("RECIPE_INGREDIENTS")

        // Get references to the layout views
        val imageView: ImageView = findViewById(R.id.dishimageDetail)
        val nameTextView: TextView = findViewById(R.id.recipetitleDetail)
        val descriptionTextView: TextView = findViewById(R.id.recipedescriptionDetail)
        val ingredientsTextView: TextView = findViewById(R.id.recipeingredientsDetail)

        // Update the views with the recipe details
        recipeName?.let { nameTextView.text = it }
        recipeDescription?.let { descriptionTextView.text = it }
        recipeIngredients?.let{ingredientsTextView.text = it}

        // Load the character image into the ImageView using Glide
        recipeImageUrl?.let {
            Glide.with(this)
                .load(it)
                .into(imageView)
        }
    }
}
