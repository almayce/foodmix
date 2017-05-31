package appwork.almayce.foodmix.model.ingredients;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by almayce on 30.05.17.
 */

public class IngredientsObservableList<T> {
    private List<T> list;
    private PublishSubject<T> onRemove;
    private PublishSubject<T> onAdd;
    private T backup;

    public IngredientsObservableList() {
        this.list = new ArrayList<T>();
        this.onRemove = PublishSubject.create();
        this.onAdd = PublishSubject.create();
    }

    public void add(T val) {
        onAdd.onNext(val);
        list.add(val);
    }

    public void remove(T val) {
        backup = val;
        onRemove.onNext(val);
        list.remove(val);
    }

    public void remove(int position) {
        backup = list.get(position);
        onRemove.onNext(list.get(position));
        list.remove(position);
    }

    public boolean contains(T val) {
        return list.contains(val);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void resurrect() {
        onAdd.onNext(backup);
        list.add(backup);
    }

    public int size() {
        return list.size();
    }

    public T get(int position) {
        return list.get(position);
    }

    public List<T> getList() {
        return list;
    }

    public PublishSubject<T> getOnAddObservable(){
        return onAdd;
    }

    public PublishSubject<T> getOnRemoveObservable(){
        return onRemove;
    }
}
