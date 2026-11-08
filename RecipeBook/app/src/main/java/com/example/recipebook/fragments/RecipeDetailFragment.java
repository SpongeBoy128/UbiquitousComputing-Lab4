package com.example.recipebook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.recipebook.R;

public class RecipeDetailFragment extends Fragment {

    private static final String INGREDIENTS = "ingredients";
    private static final String METHOD = "method";

    public static RecipeDetailFragment newInstance(
            String ingredients,
            String method) {

        RecipeDetailFragment fragment =
                new RecipeDetailFragment();

        Bundle args = new Bundle();

        args.putString(INGREDIENTS, ingredients);
        args.putString(METHOD, method);

        fragment.setArguments(args);

        return fragment;
    }

    public RecipeDetailFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        Log.d("FRAGMENT_TEST", "RecipeDetailFragment created");

        View view = inflater.inflate(
                R.layout.fragment_recipe_detail,
                container,
                false
        );

        TextView txtIngredients =
                view.findViewById(R.id.txtIngredients);

        TextView txtMethod =
                view.findViewById(R.id.txtMethod);

        Button btnBack =
                view.findViewById(R.id.btnBack);

        if (getArguments() != null) {

            txtIngredients.setText(
                    "Ingredients:\n\n" +
                            getArguments().getString(INGREDIENTS)
            );

            txtMethod.setText(
                    "Method:\n\n" +
                            getArguments().getString(METHOD)
            );
        }

        boolean isLandscape =
                requireActivity()
                        .findViewById(R.id.detail_container) != null;

        if (isLandscape) {

            btnBack.setVisibility(View.GONE);

        } else {

            btnBack.setOnClickListener(v ->
                    requireActivity()
                            .getSupportFragmentManager()
                            .popBackStack()
            );
        }

        return view;
    }
}