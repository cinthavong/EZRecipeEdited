package com.example.ezrecipe

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class RecipeAdapter(private val recipeList: MutableList<RecipeResponse>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishImage: ImageView
        val recipeTitle: TextView
        val recipeIngredients: TextView
        val recipeItem:View




        init {
            // Find our RecyclerView item's views for future use
            dishImage = view.findViewById(R.id.dishimage)
            recipeTitle = view.findViewById(R.id.recipetitle)
            recipeIngredients = view.findViewById(R.id.recipesummary)
            recipeItem = view.findViewById(R.id.recipeItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curRecipe = recipeList[position]
        val recipeid = curRecipe.recipeid
        // Convert the ingredients list to a single string
        val ingredientsString = curRecipe.ingredients.joinToString(",")

        // Load the image using Glide
        Glide.with(holder.itemView)
            .load(curRecipe.imageUrl)
            .circleCrop()
            .into(holder.dishImage)

        // Set the character name and description
        holder.recipeTitle.text = curRecipe.name
        holder.recipeIngredients.text = ingredientsString

        //set clicker for detailed view
        holder.recipeItem.setOnClickListener {
            // Create an intent for the RecipeDetailActivity
            val intent = Intent(holder.itemView.context, RecipeDetailActivity::class.java)
            // Pass data to the RecipeDetailActivity
            intent.putExtra("RECIPE_TITLE", curRecipe.name)
            intent.putExtra("RECIPE_INSTRUCTION", curRecipe.instruction)
            intent.putExtra("RECIPE_IMAGE_URL", curRecipe.imageUrl)
            intent.putExtra("RECIPE_INGREDIENTS", ingredientsString)
            // Start the new activity
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = recipeList.size
}