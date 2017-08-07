package appwork.almayce.foodmix.view.swipe;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by almayce on 30.05.17.
 */

public class HorizontalSwipeDetector implements View.OnTouchListener {

    static final String logTag = "VerticalSwipeDetector";
    private HorizontalSwipeInterface activity;
    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;

    public HorizontalSwipeDetector(HorizontalSwipeInterface activity){
        this.activity = activity;
    }

    public void onRightToLeftSwipe(View v){
        Log.i(logTag, "RightToLeftSwipe!");
        activity.rightToLeft(v);
    }

    public void onLeftToRightSwipe(View v){
        Log.i(logTag, "LeftToRightSwipe!");
        activity.leftToRight(v);
    }

    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
                downY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                upX = event.getX();
                upY = event.getY();

                float deltaX = downX - upX;
                float deltaY = downY - upY;

                if(Math.abs(deltaX) > MIN_DISTANCE){
                    if(deltaX < 0) { this.onLeftToRightSwipe(v); return true; }
                    if(deltaX > 0) { this.onRightToLeftSwipe(v); return true; }
                }
                else {
                    Log.i(logTag, "Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                }
            }
        }
        return false;
    }
}
