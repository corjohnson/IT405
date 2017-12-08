package co.corey.filestorageapplication.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 12/7/17.
 */

public class Ingredient {
    public String value;

    public Ingredient(String value){
        this.value = value;
    }

    public static List<Ingredient> getIngredientList(String input) {
        final String delimiter = ",";
        List<Ingredient> ingredients = new LinkedList<>();

        String[] splitInput = input.split(delimiter);
        for (String s :
                splitInput) {
            ingredients.add(new Ingredient(s));
        }

        return ingredients;
    }
}
