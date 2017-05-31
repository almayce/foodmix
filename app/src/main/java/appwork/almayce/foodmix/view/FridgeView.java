package appwork.almayce.foodmix.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 30.05.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FridgeView extends MvpView {
    void setImage(int id);
    void showPanel();
    void removeSnack(String name);
    void showToast(String message);
    void setFridgeClickableFalse();
    void setOnSwipeMessageVisibility(boolean visible);
    void startSwipeAnimation();
    void startNextActivity();
}
