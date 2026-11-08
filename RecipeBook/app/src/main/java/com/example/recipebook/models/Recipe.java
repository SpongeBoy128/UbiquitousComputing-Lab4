package com.example.recipebook.models;

import java.util.List;

public class Recipe {

    private String name;
    private List<String> ingredients;
    private String method;

    public Recipe(String name, List<String> ingredients, String method) {
        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getMethod() {
        return method;
    }
}