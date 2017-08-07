package appwork.almayce.foodmix.view.customviews;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by almayce on 02.06.17.
 */

public class CustomAutoCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    public CustomAutoCompleteTextView(Context context) {
        super(context);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }
}
