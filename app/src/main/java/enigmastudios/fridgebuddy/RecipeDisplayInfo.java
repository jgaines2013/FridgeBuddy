package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by jerry on 4/26/18.
 */

public class RecipeDisplayInfo extends AppCompatActivity {
    TextView tx;
    ImageView image;
    Recipe recipe;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Recipes");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);

        recipe = (Recipe) getIntent().getSerializableExtra(RecipeFragment.TAG_recipe);
        tx = findViewById(R.id.recipe_title);
        tx.setText(recipe.getTitle());
        image = findViewById(R.id.recipe_descript);
        new DownLoadImageTask(image).execute(recipe.getUrl());
    }
}