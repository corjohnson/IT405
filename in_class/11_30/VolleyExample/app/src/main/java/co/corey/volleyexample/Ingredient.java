package co.corey.volleyexample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 11/30/17.
 */

public class Ingredient {
    public String name;

    public Ingredient(String name){
        this.name = name;
    }

    public static List<Ingredient> ingredientsForString(String s){
        List<Ingredient> result = new LinkedList<>();

        if(s != null) {
            String[] split = s.split(",");

            for (String ingredient : split) {
                result.add(new Ingredient(ingredient));
            }
        }

        return result;
    }
}
