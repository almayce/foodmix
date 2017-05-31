package appwork.almayce.foodmix.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityBlenderBinding;
import appwork.almayce.foodmix.presenter.BlenderPresenter;

/**
 * Created by almayce on 30.05.17.
 */

public class BlenderActivity extends MvpAppCompatActivity implements BlenderView {

    @InjectPresenter
    BlenderPresenter blenderPresenter;

    private ActivityBlenderBinding binding;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_blender);
        displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        binding.ivBlender.setPivotY(displayMetrics.heightPixels / 2);
    }

    @Override
    public void addAnimatedImageView(int imageId) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(imageId);
        iv.setLayoutParams(binding.ivItem.getLayoutParams());
        binding.rlScene.addView(iv);

        TranslateAnimation transAnim = new TranslateAnimation(blenderPresenter.generateTranslation(-displayMetrics.widthPixels, displayMetrics.widthPixels), 0, -binding.ivBlender.getPivotY(), binding.ivBlender.getPivotY() + binding.ivItem.getPivotY());
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
}
