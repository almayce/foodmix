package appwork.almayce.foodmix.model.recipes;

import android.util.Log;

import java.util.List;

/**
 * Created by almayce on 24.07.17.
 */

public class Recipe {
    private String kind;
    private String name;
    private List<String> ingredients;
    private String description;

    public Recipe(String kind, String name, List<String> ingredients, String description) {
        this.kind = kind;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredientsList() {
        return ingredients;
    }

    public String getIngredientsString() {
        StringBuilder target = new StringBuilder();
        Log.d("ingredients.size()", String.valueOf(ingredients.size()));

        for (String s : ingredients)
            target.append(s).append("\n");
        target.append("\n");
        return target.toString();
    }

    public String getDescription() {
        return description;
    }
}
