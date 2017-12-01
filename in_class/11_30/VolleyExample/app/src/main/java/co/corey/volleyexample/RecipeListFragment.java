package co.corey.volleyexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by corey on 11/30/17.
 */

public class RecipeListFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipe_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recipeRecycler);
        recyclerView.setAdapter(new RecipeRecyclerAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    public void updateData(List<Recipe> recipeList){
        RecipeRecyclerAdapter adapter = (RecipeRecyclerAdapter)recyclerView.getAdapter();
        adapter.updateRecipes(recipeList);
    }
}
