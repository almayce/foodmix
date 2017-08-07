package appwork.almayce.foodmix.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 31.05.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BlenderView extends MvpView{
    void addAnimatedImageView(int imageId);
    void setImage(int imageId);
    void startNextActivity();
    void playSound();
}
