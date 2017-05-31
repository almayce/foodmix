package appwork.almayce.foodmix.presenter.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ItemBinding;
import appwork.almayce.foodmix.model.ingredients.IngredientsDataBase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by almayce on 30.05.17.
 */

public class CustomGridViewAdapter extends BaseAdapter {

    private Context context;

    public CustomGridViewAdapter(Context context) {
        this.context = context;

        IngredientsDataBase.changedIngredients.getOnAddObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ingredient -> notifyDataSetChanged());

        IngredientsDataBase.changedIngredients.getOnRemoveObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ingredient -> notifyDataSetChanged());
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item, parent, false);
        convertView = binding.getRoot();
        binding.rlItem.setBackgroundResource(IngredientsDataBase.changedIngredients.get(position).getImageId());
        binding.rlItem.setTranslationX(generateTranslation(-50, 50));
        binding.rlItem.setOnClickListener(v -> IngredientsDataBase.changedIngredients.remove(position));
        binding.tvItem.setText(IngredientsDataBase.changedIngredients.get(position).getShortName());
        return convertView;
    }

    public float generateTranslation(int min, int max) {
        return (float) (Math.random()*(max - min)) + min;
    }
}
