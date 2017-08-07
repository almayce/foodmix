package appwork.almayce.foodmix.presenter;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import appwork.almayce.foodmix.R;
//import appwork.almayce.foodmix.model.firebase.FirebaseReader;
import appwork.almayce.foodmix.model.firebase.FirebaseReader;
import appwork.almayce.foodmix.model.ingredients.Ingredient;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;
import appwork.almayce.foodmix.view.FridgeView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by almayce on 30.05.17.
 */

@InjectViewState
public class FridgePresenter extends MvpPresenter<FridgeView> {

    public FridgePresenter() {
        FirebaseReader.getInstance().init();

        IngredientsDataBase.changedIngredients.getOnAddObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ingredient>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ingredient ingredient) {
                        onSwitchSwipeMessageVisibility();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        IngredientsDataBase.changedIngredients.getOnRemoveObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ingredient>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ingredient ingredient) {
                        getViewState().removeSnack(ingredient.getShortName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void onFridgeClick() {
        getViewState().setFridgeClickableFalse();
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                publishProgress(R.drawable.fridge2_titled);
                sleep(400);
                publishProgress(R.drawable.fridge3_titled);
                sleep(400);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setImage(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showPanel();
            }
        };
        asyncTask.execute();
    }

    public void onSnackDismissClick() {
        IngredientsDataBase.changedIngredients.resurrect();
    }

    public ArrayList getAllNames() {
        return IngredientsDataBase.getAllNames();
    }

    public void onSearchListItemClick(String name) {
        if (IngredientsDataBase.changedIngredients.size() < 5)
            if (!IngredientsDataBase.changedIngredients.contains(IngredientsDataBase.getAll().get(name))) {
                IngredientsDataBase.changedIngredients.add(IngredientsDataBase.getAll().get(name));
            } else getViewState().showToast("Уже выбрано");
        else getViewState().showToast("Максимум пять ингредиентов");
    }

    public void onSwipe() {
        if (IngredientsDataBase.changedIngredients.isEmpty())
            getViewState().showToast("Выберите ингредиенты");
        else getViewState().startSwipeAnimation();
    }

    public void onSwitchSwipeMessageVisibility() {
        getViewState().setOnSwipeMessageVisibility(IngredientsDataBase.changedIngredients.isEmpty());
    }

    public void onSwipeAnimationEnd() {
        getViewState().startNextActivity();
    }

    private void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


