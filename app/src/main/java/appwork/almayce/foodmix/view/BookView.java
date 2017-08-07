package appwork.almayce.foodmix.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import appwork.almayce.foodmix.model.sounds.Sounds;

/**
 * Created by almayce on 31.05.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface BookView extends MvpView{
    void setImage(int imageId);
    void showText();
    void hideText();
    void playSound(Sounds sound);
}
