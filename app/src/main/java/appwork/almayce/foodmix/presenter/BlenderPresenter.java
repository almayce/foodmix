package appwork.almayce.foodmix.presenter;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;
import appwork.almayce.foodmix.view.BlenderView;

/**
 * Created by almayce on 30.05.17.
 */

@InjectViewState
public class BlenderPresenter extends MvpPresenter<BlenderView> {
    public BlenderPresenter() {
        onIntroAnimationStartFirst();
    }

    public void onIntroAnimationStartFirst() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                for (int o = 0; o < IngredientsDataBase.changedIngredients.size(); o++) {
                    publishProgress(o);
                    sleep(400);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                int imageId = IngredientsDataBase.changedIngredients.get(values[0]).getImageId();
                getViewState().addAnimatedImageView(imageId);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                onIntroAnimationStartSecond();
            }
        };
        asyncTask.execute();
    }

    public void onIntroAnimationStartSecond() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                sleep(500);
                publishProgress(R.drawable.blender2);
                sleep(1000);
                publishProgress(R.drawable.blender3);
                sleep(1000);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setImage(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().startNextActivity();
            }

        };
        asyncTask.execute();
    }

    private void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float generateTranslation(int min, int max) {
        return (float) (Math.random()*(max - min)) + min;
    }
}
