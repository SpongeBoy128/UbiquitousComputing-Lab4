package com.example.recipebook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipebook.R;
import com.example.recipebook.adapters.RecipeAdapter;
import com.example.recipebook.models.Recipe;
import com.example.recipebook.utils.JsonHelper;

import java.util.ArrayList;

public class RecipeListFragment extends Fragment
        implements RecipeAdapter.OnRecipeClickListener {

    public RecipeListFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        Log.d("FRAGMENT_TEST", "RecipeListFragment created");

        View view = inflater.inflate(
                R.layout.fragment_recipe_list,
                container,
                false
        );

        RecyclerView recyclerView =
                view.findViewById(R.id.recyclerRecipes);

        ArrayList<Recipe> recipes =
                JsonHelper.loadRecipes(requireContext());

        RecipeAdapter adapter =
                new RecipeAdapter(recipes, this);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext())
        );

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onRecipeClick(Recipe recipe) {

        String ingredients =
                String.join(
                        "\n",
                        recipe.getIngredients()
                );

        RecipeDetailFragment detailFragment =
                RecipeDetailFragment.newInstance(
                        ingredients,
                        recipe.getMethod()
                );

        boolean isLandscape =
                requireActivity()
                        .findViewById(
                                R.id.detail_container
                        ) != null;

        if (isLandscape) {

            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.detail_container,
                            detailFragment
                    )
                    .commit();

        } else {

            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragment_container,
                            detailFragment
                    )
                    .addToBackStack(null)
                    .commit();
        }
    }
}