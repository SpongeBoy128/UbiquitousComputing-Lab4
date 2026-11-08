package com.example.recipebook.utils;

import android.content.Context;

import com.example.recipebook.models.Recipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    public static ArrayList<Recipe> loadRecipes(Context context) {

        ArrayList<Recipe> recipes = new ArrayList<>();

        try {

            InputStream is = context.getAssets().open("recipes.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            String json = new String(buffer, "UTF-8");

            JSONObject rootObject = new JSONObject(json);

            JSONArray recipesArray = rootObject.getJSONArray("recipes");

            for (int i = 0; i < recipesArray.length(); i++) {

                JSONObject recipeObject = recipesArray.getJSONObject(i);

                String name = recipeObject.getString("name");

                JSONArray ingredientsArray =
                        recipeObject.getJSONArray("ingredients");

                List<String> ingredients = new ArrayList<>();

                for (int j = 0; j < ingredientsArray.length(); j++) {
                    ingredients.add(
                            ingredientsArray.getString(j)
                    );
                }

                String method =
                        recipeObject.getString("method");

                Recipe recipe = new Recipe(
                        name,
                        ingredients,
                        method
                );

                recipes.add(recipe);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return recipes;
    }
}