package appwork.almayce.foodmix.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 31.05.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface BookView extends MvpView{
    void printRecipes(int stringId);
    void showDialog();
}
