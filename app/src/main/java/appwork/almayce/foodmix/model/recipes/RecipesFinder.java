package appwork.almayce.foodmix.model.recipes;

import appwork.almayce.foodmix.model.ingredients.Ingredient;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;

/**
 * Created by almayce on 30.05.17.
 */

public class RecipesFinder {
    public static String findRecipes(String recipes) {

        StringBuilder printString = new StringBuilder();
        int counter = 0;

        for (String recipe : recipes.split("recipe_tag")) {
            for (Ingredient i : IngredientsDataBase.changedIngredients.getList()) {
                if (recipe.contains(i.getSearchName()))
                    counter++;
            }
            if (counter == IngredientsDataBase.changedIngredients.size())
                printString.append(recipe).append("\n\n");
            counter = 0;
        }
        if (printString.toString().equals(""))
            printString.append("Рецепт не найден");

        return printString.toString();
    }
}
