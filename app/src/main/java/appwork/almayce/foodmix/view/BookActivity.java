package appwork.almayce.foodmix.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import appwork.almayce.foodmix.App;
import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityBookBinding;
import appwork.almayce.foodmix.databinding.LayoutKindBinding;
import appwork.almayce.foodmix.model.recipes.Recipe;
import appwork.almayce.foodmix.model.sounds.Sounds;
import appwork.almayce.foodmix.presenter.BookPresenter;
import appwork.almayce.foodmix.view.swipe.HorizontalSwipeDetector;
import appwork.almayce.foodmix.view.swipe.HorizontalSwipeInterface;

/**
 * Created by almayce on 30.05.17.
 */

public class BookActivity extends MvpAppCompatActivity implements BookView, HorizontalSwipeInterface {

    @InjectPresenter
    BookPresenter bookPresenter;

    private ActivityBookBinding binding;
    private AlertDialog alert;
    private List<Recipe> changedRecipes;
    private int pageNumber;
    private HorizontalSwipeDetector detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changedRecipes = new ArrayList<>();
        detector = new HorizontalSwipeDetector(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);
        binding.svPrint.setOnTouchListener(detector);
        binding.rlSendRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecipeSendingActivity.class));
            }
        });
        initMenu();
    }

    private void initMenu() {
        LayoutKindBinding kindBinding = DataBindingUtil
                .inflate(LayoutInflater.from(this), R.layout.layout_kind, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(kindBinding.getRoot());
        builder.setCancelable(false);
        alert = builder.create();
        alert.show();
        alert.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


    }

    public void onKindClick(View v) {
        // TODO: 25.07.17 contentDescription
        changedRecipes = bookPresenter.getRecipes("hots", null);
        alert.cancel();
        bookPresenter.runAnimation();
    }

    @Override
    public void setImage(int imageId) {
        binding.ivBook.setImageResource(imageId);
    }

    @Override
    public void showText() {
        if (!changedRecipes.isEmpty()) {
            Recipe target = changedRecipes.get(pageNumber);
            StringBuilder recipe = new StringBuilder();
            recipe.append(target.getName())
                    .append("\n").append("\n")
                    .append(target.getIngredientsString())
                    .append(target.getDescription());
            binding.tvPrint.setText(recipe.toString());
            binding.svPrint.setOnTouchListener(detector);
        } else {
            binding.tvPrint.setText("Рецепт не найден");
        }
        binding.tvPrint.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideText() {
        binding.tvPrint.setVisibility(View.INVISIBLE);
        binding.svPrint.setOnTouchListener(null);
    }

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }

    @Override
    public void leftToRight(View v) {
        bookPresenter.prevPage();
        if (pageNumber != 0)
            pageNumber--;
    }

    @Override
    public void rightToLeft(View v) {
        bookPresenter.nextPage();
        if (pageNumber < changedRecipes.size())
            pageNumber++;
    }
}
