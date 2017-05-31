package appwork.almayce.foodmix.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.concurrent.TimeUnit;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityFridgeBinding;
import appwork.almayce.foodmix.presenter.FridgePresenter;
import appwork.almayce.foodmix.presenter.adapters.CustomGridViewAdapter;
import appwork.almayce.foodmix.view.swipe.SwipeDetector;
import appwork.almayce.foodmix.view.swipe.SwipeInterface;

public class FridgeActivity extends MvpAppCompatActivity implements FridgeView, SwipeInterface {

    @InjectPresenter
    FridgePresenter fridgePresenter;

    private ActivityFridgeBinding binding;
    private InputMethodManager imm;
    private SwipeDetector swipeDetector;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onResume() {
        super.onResume();
        binding.gvItems.clearAnimation();
        binding.rlPanel.setOnTouchListener(swipeDetector);
        fridgePresenter.onSwitchSwipeMessageVisibility();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_fridge);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        swipeDetector = new SwipeDetector(this);

        displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        ScaleAnimation scaleAnim = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, Animation.RELATIVE_TO_PARENT, 0.5F, Animation.RELATIVE_TO_PARENT, 0.5F);
        scaleAnim.setFillAfter(true);
        scaleAnim.setDuration(1000);

        binding.ivFridge.startAnimation(scaleAnim);
        binding.ivFridge.setOnClickListener(v -> fridgePresenter.onFridgeClick());

        // 2.43
        binding.til1.getLayoutParams().width = (int) (displayMetrics.heightPixels / 2.43);
        binding.tvSwipeMessage.getLayoutParams().width = (int) (displayMetrics.heightPixels / 2.43);
        binding.gvItems.getLayoutParams().width = (int) (displayMetrics.heightPixels / 2.43);
        binding.gvItems.getLayoutParams().height = (int) (displayMetrics.heightPixels / 2.43);
        binding.gvItems.setAdapter(new CustomGridViewAdapter(this));

        binding.rlPanel.setOnTouchListener(swipeDetector);

        binding.actvSearch.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fridgePresenter.getAll()));
        binding.actvSearch.setOnItemClickListener((parent, view, position, id) -> {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            binding.actvSearch.setText("");
            TextView target = (TextView) view;
            fridgePresenter.onSearchListItemClick(target.getText().toString());
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
        Snackbar.make(binding.gvItems, "Ингредиент \"" + name + "\" удален.", Snackbar.LENGTH_SHORT).setAction("ОТМЕНИТЬ", v -> fridgePresenter.onSnackDismissClick()).show();
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
        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0, displayMetrics.heightPixels);
        transAnim.setDuration(1000);
        transAnim.setFillAfter(true);
        transAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.tvSwipeMessage.setVisibility(View.INVISIBLE);
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
        binding.gvItems.startAnimation(transAnim);
    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(this, BlenderActivity.class));
    }

    @Override
    public void bottom2top(View v) {

    }

    @Override
    public void left2right(View v) {

    }

    @Override
    public void right2left(View v) {

    }

    @Override
    public void top2bottom(View v) {
        fridgePresenter.onSwipe();
    }
}
