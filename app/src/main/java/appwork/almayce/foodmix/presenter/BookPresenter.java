package appwork.almayce.foodmix.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;
import appwork.almayce.foodmix.view.BookView;

/**
 * Created by almayce on 30.05.17.
 */

@InjectViewState
public class BookPresenter extends MvpPresenter<BookView> {

    public BookPresenter() {
        if (IngredientsDataBase.changedIngredients.size() < 3)
            getViewState().printRecipes(R.string.recipes_patterns);
        else getViewState().showDialog();
    }

    public void onDialogItemClick(int index) {
        switch (index) {
            case 0:
                getViewState().printRecipes(R.string.recipes_soups);
                break;
            case 1:
                getViewState().printRecipes(R.string.recipes_hots);
                break;
            case 2:
                getViewState().printRecipes(R.string.recipes_salads);
                break;
            case 3:
                getViewState().printRecipes(R.string.recipes_breakfasts);
                break;
            case 4:
                getViewState().printRecipes(R.string.recipes_desserts);
                break;
            case 5:
                getViewState().printRecipes(R.string.recipes_drinks);
                break;
        }
    }
}
