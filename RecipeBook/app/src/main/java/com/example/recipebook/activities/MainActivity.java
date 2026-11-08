package com.example.recipebook.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipebook.R;
import com.example.recipebook.fragments.RecipeDetailFragment;
import com.example.recipebook.fragments.RecipeListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isLandscape =
                findViewById(R.id.list_container) != null;

        if (isLandscape) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.list_container,
                            new RecipeListFragment()
                    )
                    .replace(
                            R.id.detail_container,
                            RecipeDetailFragment.newInstance(
                                    "Select a recipe",
                                    ""
                            )
                    )
                    .commit();

        } else {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragment_container,
                            new RecipeListFragment()
                    )
                    .commit();
        }
    }
}