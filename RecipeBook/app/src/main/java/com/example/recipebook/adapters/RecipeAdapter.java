package com.example.recipebook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipebook.R;
import com.example.recipebook.models.Recipe;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private ArrayList<Recipe> recipes;
    private OnRecipeClickListener listener;

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe recipe);
    }

    public RecipeAdapter(
            ArrayList<Recipe> recipes,
            OnRecipeClickListener listener) {

        this.recipes = recipes;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtRecipeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRecipeName =
                    itemView.findViewById(R.id.txtRecipeName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item_recipe,
                        parent,
                        false
                );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        Recipe recipe = recipes.get(position);

        holder.txtRecipeName.setText(
                recipe.getName()
        );

        holder.itemView.setOnClickListener(v ->
                listener.onRecipeClick(recipe)
        );
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
