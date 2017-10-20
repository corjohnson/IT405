package co.miniforge.corey.api_example.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 10/19/17.
 */

public class Recipe {
    public String title = "";
    public String url = "";
    public List<Ingredient> ingredients = new LinkedList<>();
    public String thumbnail = "";

    public Recipe(JSONObject json){
        try {
            this.title = json.getString("title");
            this.url = json.getString("href");
            this.ingredients = getIngredientsFromJson(json);
            this.thumbnail = json.getString("thumbnail");
        } catch (JSONException e){

        }
    }

    private List<Ingredient> getIngredientsFromJson(JSONObject jsonObject){
        List<Ingredient> result = new LinkedList<>();

        try {
            String ingredientString = jsonObject.getString("ingredients");
            String[] ingredientArray = ingredientString.split(", ");
            for (String s : ingredientArray){
                result.add(new Ingredient(s));
            }
        } catch (Exception e){
            Log.e("TEST", new StringBuilder()
                    .append("Something went wrong: ")
                    .append(e.getMessage()).toString());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("Title: ").append(title).append(",");
        builder.append("URL: " + url + ",");
        builder.append("[");
        for (Ingredient i : ingredients){
            builder.append("ingredient: " + i.toString());
        }
        builder.append("],");
        builder.append("Thumbnail: " + thumbnail + ",");

        return builder.toString();
    }
}
