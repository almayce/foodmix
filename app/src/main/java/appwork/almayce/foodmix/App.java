package appwork.almayce.foodmix;

import android.app.Application;
import android.util.DisplayMetrics;

import appwork.almayce.foodmix.model.sounds.SoundManager;

/**
 * Created by almayce on 13.06.17.
 */

public class App extends Application {

    private static SoundManager soundManager;
    public static DisplayMetrics displayMetrics;

    @Override
    public void onCreate() {
        super.onCreate();
        soundManager = new SoundManager(getApplicationContext());
        displayMetrics = new DisplayMetrics();
    }

    public static SoundManager getSoundManagerInstance() {
        return soundManager;
    }
}
