package appwork.almayce.foodmix.presenter;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.model.firebase.FirebaseReader;
import appwork.almayce.foodmix.model.recipes.Recipe;
import appwork.almayce.foodmix.model.sounds.Sounds;
import appwork.almayce.foodmix.view.BookView;

/**
 * Created by almayce on 30.05.17.
 */

@InjectViewState
public class BookPresenter extends MvpPresenter<BookView> {

    public void runAnimation() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected void onPreExecute() {
                getViewState().hideText();
            }

            @Override
            protected Void doInBackground(Void... params) {
                sleep(600);
                publishProgress(R.drawable.book2);
                sleep(600);
                getViewState().playSound(Sounds.PAGE);
                publishProgress(R.drawable.book3);
                sleep(600);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setImage(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showText();
            }
        };
        asyncTask.execute();
    }

    public void nextPage() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {

            @Override
            protected void onPreExecute() {
                getViewState().hideText();
            }

            @Override
            protected Void doInBackground(Void... params) {
                sleep(400);
                publishProgress(R.drawable.book4);
                sleep(400);
                getViewState().playSound(Sounds.PAGE);
                publishProgress(R.drawable.book3);
                sleep(400);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setImage(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showText();
            }
        };
        asyncTask.execute();
    }

    public void prevPage() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {

            @Override
            protected void onPreExecute() {
                getViewState().hideText();
            }

            @Override
            protected Void doInBackground(Void... params) {
                sleep(400);
                publishProgress(R.drawable.book4);
                sleep(400);
                getViewState().playSound(Sounds.PAGE);
                publishProgress(R.drawable.book3);
                sleep(400);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setImage(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showText();
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

    public List<Recipe> getRecipes(String kind, List<String> changed) {
        return FirebaseReader.getInstance().getRecipes(kind);
        // TODO: 24.07.17
    }

}
