package co.miniforge.corey.api_example.model;

import org.json.JSONObject;

/**
 * Created by corey on 10/19/17.
 */

public class Ingredient {
    public String name = "";

    public Ingredient(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Name: %s", name);
    }
}
