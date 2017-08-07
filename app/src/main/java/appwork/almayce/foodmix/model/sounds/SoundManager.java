package appwork.almayce.foodmix.model.sounds;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by almayce on 05.06.17.
 */

public class SoundManager {

    private SoundPool sp;

    private int fridge;
    private int add;
    private int remove;
    private int clap;
    private int page;
    private int blender;

    public SoundManager(Context context) {
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 100);
        try {
            fridge = sp.load(context.getAssets().openFd("sounds/fridge.mp3"), 1);
            add = sp.load(context.getAssets().openFd("sounds/add.mp3"), 1);
            remove = sp.load(context.getAssets().openFd("sounds/remove.mp3"), 1);
            clap = sp.load(context.getAssets().openFd("sounds/clap.mp3"), 1);
            page = sp.load(context.getAssets().openFd("sounds/page.mp3"), 1);
            blender = sp.load(context.getAssets().openFd("sounds/blender.mp3"), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound(Sounds soundName) {
        switch (soundName) {
            case FRIDGE: sp.play(fridge, 1, 1, 0, 0, 1);break;
            case ADD: sp.play(add, 1, 1, 0, 0, 1);break;
            case REMOVE: sp.play(remove, 1, 1, 0, 0, 1);break;
            case CLAP: sp.play(clap, 1, 1, 0, 0, 1);break;
            case PAGE: sp.play(page, 1, 1, 0, 0, 1);break;
            case BLENDER: sp.play(blender, 1, 1, 0, 0, 1);break;
        }

    }


}
