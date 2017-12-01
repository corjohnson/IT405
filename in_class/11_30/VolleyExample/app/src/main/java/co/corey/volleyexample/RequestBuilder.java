package co.corey.volleyexample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 11/30/17.
 */

public class RequestBuilder {
    //FIELDS
    // URL
    private String url;
    // LIST OF INGREDIENTS
    private List<String> ingredientList = new LinkedList<>();
    // QUERY PARAM
    private String query = null;

    //Constructor
    public RequestBuilder(){
        setUrl("http://www.recipepuppy.com/api/?");
    }

    //Set url
    public RequestBuilder setUrl(String url) {
        this.url = url;

        return this;
    }

    //Add ingredient(s)
    public RequestBuilder addIngredients(String... ingredients){
        Collections.addAll(ingredientList, ingredients);

        return this;
    }

    //Clear ingredients
    public RequestBuilder clearIngredients() {
        ingredientList.clear();

        return this;
    }

    //Set query param
    public RequestBuilder setQueryParam(String param) {
        this.query = param;

        return this;
    }

    public String build() {
        StringBuilder result = new StringBuilder();

        result.append(url);

        if(!ingredientList.isEmpty()){
            //Add ingredients
            result.append("&i=");

            for(int i = 0; i < ingredientList.size(); i++) {
                result.append(ingredientList.get(i));

                if(i + 1 != ingredientList.size()){
                    result.append(",");
                }
            }
        }

        if(query != null && !query.isEmpty()) {
            //Add query
            result.append("&q=").append(query);
        }

        return result.toString();
    }
}
