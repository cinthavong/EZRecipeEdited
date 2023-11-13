package com.example.ezrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import okhttp3.Headers

import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder


data class RecipeResponse(
    val name: String,
    val instruction:String,
    val imageUrl:String,
    val recipeid:Int,
    val ingredients: List<String>
)

class MainActivity : AppCompatActivity() {

    private lateinit var recipeList: MutableList<RecipeResponse>
    private lateinit var rvRecipes: RecyclerView
    private lateinit var recipesTextView: TextView
    private lateinit var searchBar: EditText
    private lateinit var searchButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recipesTextView = findViewById(R.id.ezrecipeLabel)
        searchBar = findViewById(R.id.searchBar)
        searchButton = findViewById(R.id.searchbutton)
        rvRecipes = findViewById(R.id.recipe_list)
        recipeList = mutableListOf()
        getRecipeObjects()

        // Set a click listener for the search button
        searchButton.setOnClickListener {
            val searchTerm = searchBar.text.toString().trim()
            if (searchTerm.isNotEmpty()) {
                searchRecipes(searchTerm)
            } else {
                Toast.makeText(this, "Please enter an ingredient", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun searchRecipes(searchTerm: String) {
        val client = AsyncHttpClient()
        val encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8")
        val url = "https://food-recipes-with-images.p.rapidapi.com/?q=$encodedSearchTerm&rapidapi-key=771ec8f635msh9a436b3d85bf796p1eeb3ajsnbc2bc1d21eac"

        client.get(url, object: JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                recipeList.clear() // Clear existing data

                json?.jsonObject?.getJSONArray("d")?.let { results ->
                    for (i in 0 until results.length()) {
                        val recipeObject = results.getJSONObject(i)
                        val name = recipeObject.getString("Title")
                        val instruction = recipeObject.getString("Instructions")
                        val recipeid = recipeObject.getInt("id")
                        val ingredientsObject = recipeObject.optJSONObject("Ingredients")

                        val ingredientsList = mutableListOf<String>()
                        ingredientsObject?.let { ingrObj ->
                            for (key in ingrObj.keys()) {
                                ingredientsList.add(ingrObj.getString(key))
                            }
                        }

                        val thumbnailObject = recipeObject.getString("Image")
                        val imageUrl = "https:$thumbnailObject"

                        val curRecipe = RecipeResponse(name, instruction, imageUrl, recipeid, ingredientsList)
                        recipeList.add(curRecipe)
                    }

                    updateRecyclerView()
                }
            }

            override fun onFailure(statusCode: Int, headers: okhttp3.Headers?, errorResponse: String, throwable: Throwable?) {
                Log.d("Recipe Error", errorResponse)
            }
        })
    }

    private fun updateRecyclerView() {
        rvRecipes.adapter?.notifyDataSetChanged()
        // Optionally reset the adapter if you face issues with notifyDataSetChanged:
        // rvRecipes.adapter = RecipeAdapter(recipeList)
    }



    private fun getRecipeObjects() {
        val client = AsyncHttpClient()

        client["https://food-recipes-with-images.p.rapidapi.com/?q=dinner&rapidapi-key=771ec8f635msh9a436b3d85bf796p1eeb3ajsnbc2bc1d21eac", object :
            JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers?,
                json: JsonHttpResponseHandler.JSON?
            ) {
                Log.d("Recipe Success", "$json")
                val jsonObject = json?.jsonObject
                val results = jsonObject?.getJSONArray("d")

                results?.let {
                    for (i in 0 until it.length()) {
                        val recipeObject = it.getJSONObject(i)
                        val name = recipeObject.getString("Title")
                        val instruction = recipeObject.getString("Instructions")
                        val recipeid = recipeObject.getInt("id")
                        val ingredientsObject = recipeObject.optJSONObject("Ingredients")

                        val ingredientsList = mutableListOf<String>()
                        ingredientsObject?.let { ingrObj ->
                            for (key in ingrObj.keys()) {
                                ingredientsList.add(ingrObj.getString(key))
                            }
                        }

                        val thumbnailObject = recipeObject.getString("Image")
                        val imageUrl = "https:$thumbnailObject"

                        val curRecipe = RecipeResponse(name, instruction, imageUrl,recipeid,ingredientsList)
                        recipeList.add(curRecipe)
                    }

                    val adapter = RecipeAdapter(recipeList)
                    rvRecipes.adapter = adapter
                    rvRecipes.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvRecipes.addItemDecoration(
                        DividerItemDecoration(
                            this@MainActivity,
                            LinearLayoutManager.VERTICAL
                        )
                    )
                }
            }




            override fun onFailure(
                statusCode: Int,
                headers: okhttp3.Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe Error", errorResponse)
            }
        }]
    }
}


