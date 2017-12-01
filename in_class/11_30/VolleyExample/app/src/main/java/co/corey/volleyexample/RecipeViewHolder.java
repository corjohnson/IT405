package co.corey.volleyexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by corey on 11/30/17.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    Button goButton;

    public RecipeViewHolder(View itemView) {
        super(itemView);

        locateViews(itemView);
    }

    void locateViews(View view){
        title = view.findViewById(R.id.recipeTitle);
        goButton = view.findViewById(R.id.goToUrlButton);
    }

    void bindData(final Recipe recipe){
        if(recipe == null) return;

        if(title != null) title.setText(recipe.title);

        if(goButton != null) {
            goButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(recipe.href));
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
