package appwork.almayce.foodmix.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.foodmix.App;
import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityFridgeBinding;
import appwork.almayce.foodmix.model.firebase.FirebaseReader;
import appwork.almayce.foodmix.model.sounds.Sounds;
import appwork.almayce.foodmix.presenter.FridgePresenter;
import appwork.almayce.foodmix.presenter.adapters.CustomGridViewAdapter;
import appwork.almayce.foodmix.view.swipe.VerticalSwipeDetector;
import appwork.almayce.foodmix.view.swipe.VerticalSwipeInterface;

public class FridgeActivity extends MvpAppCompatActivity implements FridgeView, VerticalSwipeInterface {

    @InjectPresenter
    FridgePresenter fridgePresenter;

    private ActivityFridgeBinding binding;
    private VerticalSwipeDetector swipeDetector;

    @Override
    protected void onResume() {
        super.onResume();
        binding.til1.setVisibility(View.VISIBLE);
        binding.gvItems.clearAnimation();
        binding.gvItems.setOnTouchListener(swipeDetector);
        binding.tvSwipeMessage.setOnTouchListener(swipeDetector);
        fridgePresenter.onSwitchSwipeMessageVisibility();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_fridge);
        this.getWindowManager().getDefaultDisplay().getMetrics(App.displayMetrics);

        swipeDetector = new VerticalSwipeDetector(this);

        ScaleAnimation scaleAnim = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, Animation.RELATIVE_TO_PARENT, 0.5F, Animation.RELATIVE_TO_PARENT, 0.5F);
        scaleAnim.setFillAfter(true);
        scaleAnim.setDuration(1000);
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.ivFridge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(Sounds.FRIDGE);
                        fridgePresenter.onFridgeClick();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        binding.ivFridge.startAnimation(scaleAnim);

        // 2.43
        int h = (int) (App.displayMetrics.heightPixels / 2.43);
        binding.til1.getLayoutParams().width = h;
        binding.tvSwipeMessage.getLayoutParams().width = h;
        binding.gvItems.getLayoutParams().width = h;
        binding.gvItems.getLayoutParams().height = h;
        binding.gvItems.setVerticalSpacing(App.displayMetrics.heightPixels / 71);
        binding.gvItems.setAdapter(new CustomGridViewAdapter(this, App.displayMetrics));
        binding.gvItems.setOnTouchListener(swipeDetector);

        binding.tvSwipeMessage.setOnTouchListener(swipeDetector);

        binding.actvSearch.setAdapter(new ArrayAdapter<>(this, R.layout.actv_item, fridgePresenter.getAllNames()));
        binding.actvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playSound(Sounds.ADD);
                binding.actvSearch.setText("");
                TextView target = (TextView) view;
                fridgePresenter.onSearchListItemClick(target.getText().toString());
            }
        });
    }

    @Override
    public void setImage(int id) {
        binding.ivFridge.setImageResource(id);
    }

    @Override
    public void showPanel() {
        binding.rlPanel.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeSnack(String name) {
        playSound(Sounds.REMOVE);
        Snackbar.make(binding.gvItems, "Ингредиент \"" + name + "\" удален.", Snackbar.LENGTH_SHORT)
                .setActionTextColor(Color.WHITE)
                .setAction("ОТМЕНИТЬ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound(Sounds.ADD);
                        fridgePresenter.onSnackDismissClick();
                    }
                }).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFridgeClickableFalse() {
        binding.ivFridge.setClickable(false);
    }

    @Override
    public void setOnSwipeMessageVisibility(boolean visible) {
        binding.tvSwipeMessage.setVisibility(visible ? View.INVISIBLE : View.VISIBLE);

    }

    @Override
    public void startSwipeAnimation() {
        playSound(Sounds.CLAP);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);

        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0, -App.displayMetrics.heightPixels);
        transAnim.setDuration(600);
        animationSet.addAnimation(transAnim);

        ScaleAnimation scaleAnim = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnim.setDuration(600);
        animationSet.addAnimation(scaleAnim);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.til1.setVisibility(View.INVISIBLE);
                binding.tvSwipeMessage.setVisibility(View.INVISIBLE);
                binding.tvSwipeMessage.setOnTouchListener(null);
                binding.gvItems.setOnTouchListener(null);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fridgePresenter.onSwipeAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        binding.gvItems.startAnimation(animationSet);
    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(this, BlenderActivity.class));
    }

    @Override
    public void bottomToTop(View v) {
        if (FirebaseReader.isInit)
            fridgePresenter.onSwipe();
        else {
            if (!isOnline())
                Toast.makeText(this, "Проверьте подключение", Toast.LENGTH_SHORT).show();
            else FirebaseReader.getInstance().init();
        }
    }

    @Override
    public void topToBottom(View v) {
    }

    private void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
