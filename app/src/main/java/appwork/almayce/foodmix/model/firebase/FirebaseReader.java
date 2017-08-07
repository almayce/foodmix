package appwork.almayce.foodmix.model.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import appwork.almayce.foodmix.model.recipes.Recipe;

/**
 * Created by almayce on 24.07.17.
 */

public class FirebaseReader {
    public static FirebaseReader instance = new FirebaseReader();

    public static FirebaseReader getInstance() {
        return instance;
    }

    public static boolean isInit = false;

    private FirebaseReader() {
    }

    private List<Recipe> recipes;
    private FirebaseDatabase database;

    public void init() {
        // Read from the database
        recipes = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        database.getReference().addValueEventListener(new ValueEventListener() {

            StringBuilder name = new StringBuilder();
            StringBuilder desc = new StringBuilder();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot kind : dataSnapshot.getChildren())
                    for (DataSnapshot recipe : kind.getChildren()) {
                        List<String> ingr = new ArrayList<>();
                        for (DataSnapshot inner : recipe.getChildren()) {
                            if (inner.getKey().equals("ingredients"))
                                for (DataSnapshot searchIngred : inner.getChildren())
                                    ingr.add(searchIngred.getValue(String.class));
                            if (inner.getKey().equals("name"))
                                name.append(inner.getValue(String.class));
                            if (inner.getKey().equals("description"))
                                desc.append(inner.getValue(String.class));
                        }

                        recipes.add(new Recipe(kind.getKey(),
                                name.toString(),
                                ingr,
                                desc.toString()));
                        name.setLength(0);
                        desc.setLength(0);
                    }
                isInit = true;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                isInit = false;
                Log.w("DB", "Failed to read value.", error.toException());
            }
        });
    }

    public List<Recipe> getRecipes(String kind) {
        List<Recipe> target = new ArrayList<>();
        for (Recipe rec : recipes) {
            if (rec.getKind().equals(kind))
                target.add(rec);
        }
        return target;
    }
}
