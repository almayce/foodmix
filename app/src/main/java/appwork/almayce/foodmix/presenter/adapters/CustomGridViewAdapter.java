package appwork.almayce.foodmix.presenter.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.GvItemBinding;
import appwork.almayce.foodmix.model.ingredients.Ingredient;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by almayce on 30.05.17.
 */

public class CustomGridViewAdapter extends BaseAdapter {

    private Context context;
    private DisplayMetrics displayMetrics;

    public CustomGridViewAdapter(Context context, DisplayMetrics displayMetrics) {
        this.context = context;
        this.displayMetrics = displayMetrics;

        IngredientsDataBase.changedIngredients.getOnAddObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ingredient>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ingredient ingredient) {
                        notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        IngredientsDataBase.changedIngredients.getOnRemoveObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ingredient>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ingredient ingredient) {
                        notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public int getCount() {
        return IngredientsDataBase.changedIngredients.size();
    }

    @Override
    public Object getItem(int position) {
        return IngredientsDataBase.changedIngredients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        float translation = generateTranslation(-20, 20);

        GvItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.gv_item, parent, false);
        convertView = binding.getRoot();
        binding.rlItemContainer.getLayoutParams().height = displayMetrics.heightPixels / 8;

        binding.rlItem.setBackgroundResource(IngredientsDataBase.changedIngredients.get(position).getImageId());
        binding.rlItem.setTranslationX(translation);
        binding.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredientsDataBase.changedIngredients.remove(position);
            }
        });

        binding.tvItem.setText(IngredientsDataBase.changedIngredients.get(position).getShortName());
        binding.tvItem.setTranslationX(translation);

        return convertView;
    }

    public float generateTranslation(int min, int max) {
        return (float) (Math.random() * (max - min)) + min;
    }
}
