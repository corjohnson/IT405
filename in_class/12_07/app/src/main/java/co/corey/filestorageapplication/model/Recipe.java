package co.corey.filestorageapplication.model;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by corey on 12/7/17.
 */

public class Recipe {
    public String title;
    public String href;
    public List<Ingredient> ingredients;
    public String thumbnail;

    public Recipe(JSONObject jsonObject){
        try {
            title = jsonObject.getString("title");
            href = jsonObject.getString("href");
            ingredients = Ingredient.getIngredientList(jsonObject.getString("ingredients"));
            thumbnail = jsonObject.getString("thumbnail");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
