package appwork.almayce.foodmix.view.customviews;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by almayce on 02.06.17.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }

    public CustomTextView(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(CustomTypeFace.getInstance(context).getTypeFace());
    }
}
