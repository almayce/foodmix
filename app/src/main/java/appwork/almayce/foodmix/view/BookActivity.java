package appwork.almayce.foodmix.view;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityBookBinding;
import appwork.almayce.foodmix.model.recipes.RecipesFinder;
import appwork.almayce.foodmix.presenter.BookPresenter;

/**
 * Created by almayce on 30.05.17.
 */

public class BookActivity extends MvpAppCompatActivity implements BookView {

    @InjectPresenter
    BookPresenter bookPresenter;

    private ActivityBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);
    }

    @Override
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выберите:");
        builder.setItems(R.array.kind, (dialogInterface, i) -> {
            bookPresenter.onDialogItemClick(i);
            dialogInterface.cancel();
        });
        builder.setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void printRecipes(int stringId) {
        binding.tvPrint.setText(RecipesFinder.findRecipes(getResources().getString(stringId)));
    }
}
