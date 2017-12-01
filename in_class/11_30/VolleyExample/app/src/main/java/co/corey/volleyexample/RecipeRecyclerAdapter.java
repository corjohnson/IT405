package co.corey.volleyexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by corey on 11/30/17.
 */

public class RecipeRecyclerAdapter extends RecyclerView.Adapter {
    List<Recipe> recipeList = new LinkedList<>();

    public void updateRecipes(List<Recipe> recipeList){
        this.recipeList = recipeList;

        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item_view, parent, false);

        return new RecipeViewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecipeViewHolder)holder).bindData(recipeList.get(position));
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
