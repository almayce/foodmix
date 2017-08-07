package appwork.almayce.foodmix.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.foodmix.App;
import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityBlenderBinding;
import appwork.almayce.foodmix.model.sounds.Sounds;
import appwork.almayce.foodmix.presenter.BlenderPresenter;

/**
 * Created by almayce on 30.05.17.
 */

public class BlenderActivity extends MvpAppCompatActivity implements BlenderView {

    @InjectPresenter
    BlenderPresenter blenderPresenter;

    private ActivityBlenderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_blender);
        binding.ivBlender.getLayoutParams().height = App.displayMetrics.heightPixels / 2;
    }

    @Override
    public void addAnimatedImageView(int imageId) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(imageId);
        iv.setLayoutParams(binding.ivItem.getLayoutParams());
        binding.rlScene.addView(iv);

        TranslateAnimation transAnim = new TranslateAnimation(blenderPresenter.generateTranslation(-App.displayMetrics.widthPixels, App.displayMetrics.widthPixels), 0, -App.displayMetrics.heightPixels / 4, App.displayMetrics.heightPixels / 2);
        transAnim.setDuration(800);
        transAnim.setFillAfter(true);
        iv.startAnimation(transAnim);
    }

    @Override
    public void setImage(int imageId) {
        binding.ivBlender.setImageResource(imageId);
    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(this, BookActivity.class));

    }

    @Override
    public void playSound() {
        App.getSoundManagerInstance().playSound(Sounds.BLENDER);
    }

}
