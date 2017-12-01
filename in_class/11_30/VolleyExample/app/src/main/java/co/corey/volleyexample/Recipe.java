package co.corey.volleyexample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 11/30/17.
 */

public class Recipe {
    public String title;
    public String href;
    public List<Ingredient> ingredientsList;
    public String thumbnail;

    public Recipe(JSONObject recipeObject){
        try {
            this.title = recipeObject.getString("title");
            this.href = recipeObject.getString("href");
            this.ingredientsList = Ingredient.ingredientsForString(recipeObject.getString("ingredients"));
            this.thumbnail = recipeObject.getString("thumbnail");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static List<Recipe> recipesForJSONArray(JSONArray array){
        List<Recipe> recipeList = new LinkedList<>();

        if(array != null && array.length() > 0){
            try {
                for(int i = 0; i < array.length(); i++){
                    recipeList.add(new Recipe(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return recipeList;
    }
}
