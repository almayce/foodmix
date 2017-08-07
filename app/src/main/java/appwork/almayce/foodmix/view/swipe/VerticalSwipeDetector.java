package appwork.almayce.foodmix.view.swipe;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by almayce on 30.05.17.
 */

public class VerticalSwipeDetector implements View.OnTouchListener {

    static final String logTag = "VerticalSwipeDetector";
    private VerticalSwipeInterface activity;
    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;

    public VerticalSwipeDetector(VerticalSwipeInterface activity){
        this.activity = activity;
    }

    public void onTopToBottomSwipe(View v){
        Log.i(logTag, "onTopToBottomSwipe!");
        activity.topToBottom(v);
    }

    public void onBottomToTopSwipe(View v){
        Log.i(logTag, "onBottomToTopSwipe!");
        activity.bottomToTop(v);
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

                if(Math.abs(deltaY) > MIN_DISTANCE){
                    if(deltaY < 0) { this.onTopToBottomSwipe(v); return true; }
                    if(deltaY > 0) { this.onBottomToTopSwipe(v); return true; }
                }
                else {
                    Log.i(logTag, "Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                }
            }
        }
        return false;
    }
}
