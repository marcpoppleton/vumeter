package com.orangelabs.vumeter;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by marcpoppleton on 10/03/2017.
 */

//it contains the drawable res id of all the numbers

public class VuMeter extends android.support.constraint.ConstraintLayout {

    public static String Tag = "VuMeter";
    public static int MIN_LEVEL = 0;
    public static int MAX_LEVEL = 7;

    private Context mContext;
    //private ImageView[] mIvLevels = new ImageView[MAX_LEVEL];
    private ImageView mIvLevels;
    private int mPreviousLevel = 0;
    private int[] mDrLevelsAnimOn = new int[MAX_LEVEL];
    private int[] mDrLevelsAnimOff = new int[MAX_LEVEL];
    private int[] mDrLevels = new int[MAX_LEVEL];

    private boolean[] states = new boolean[MAX_LEVEL];

    public VuMeter(Context context) {
        super(context, null);
        init(context, null, 0);
    }

    public VuMeter(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init(context, attrs, 0);
    }

    public VuMeter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void setLevel(int level) {
        // Avoid OutOfBoundException by constraining level between min and max levels.
        level = level < MIN_LEVEL  ? MIN_LEVEL : level;
        level = level > MAX_LEVEL ? MAX_LEVEL  : level;

        if (level > mPreviousLevel) {
            // For the bars under the level, turn on if not already on
            for (int i = MIN_LEVEL; i < level; i++) {
                if (!states[i]) {
                    updateImageView(mIvLevels, mDrLevelsAnimOn[i]);
                    states[i] = true;
                }
            }
        } else {
            // For the bars above the level, turn off if not already off
            for (int i = MAX_LEVEL - 1; i > level -1; i--) {
                if (states[i]) {
                    updateImageView(mIvLevels, mDrLevelsAnimOff[i]);
                    states[i] = false;
                }
            }
        }
        mPreviousLevel = level;
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mContext = context;
        View.inflate(context, R.layout.view_vumeter, this);
        initStates();
        initView();
        initDrawables();
    }

    private void initStates() {
        for (int i = 0; i < states.length; i++) {
            states[i] = false;
        }
    }

    private void initView() {
        mIvLevels = (ImageView) findViewById(R.id.levels);
    }

    private void initDrawables() {
        mDrLevels[0] = R.drawable.level_0_on;
        mDrLevels[1] = R.drawable.level_1_on;
        mDrLevels[2] = R.drawable.level_2_on;
        mDrLevels[3] = R.drawable.level_3_on;
        mDrLevels[4] = R.drawable.level_4_on;
        mDrLevels[5] = R.drawable.level_5_on;
        mDrLevels[6] = R.drawable.level_6_on;

        mDrLevelsAnimOff[0] = R.drawable.animated_0_to_off;
        mDrLevelsAnimOff[1] = R.drawable.animated_1_to_off;
        mDrLevelsAnimOff[2] = R.drawable.animated_2_to_off;
        mDrLevelsAnimOff[3] = R.drawable.animated_3_to_off;
        mDrLevelsAnimOff[4] = R.drawable.animated_4_to_off;
        mDrLevelsAnimOff[5] = R.drawable.animated_5_to_off;
        mDrLevelsAnimOff[6] = R.drawable.animated_6_to_off;

        mDrLevelsAnimOn[0] = R.drawable.animated_0_to_on;
        mDrLevelsAnimOn[1] = R.drawable.animated_1_to_on;
        mDrLevelsAnimOn[2] = R.drawable.animated_2_to_on;
        mDrLevelsAnimOn[3] = R.drawable.animated_3_to_on;
        mDrLevelsAnimOn[4] = R.drawable.animated_4_to_on;
        mDrLevelsAnimOn[5] = R.drawable.animated_5_to_on;
        mDrLevelsAnimOn[6] = R.drawable.animated_6_to_on;
    }

    /**
     * ChangeSize of target view
     */
    private void changeSize(float targetSize, float parentSize, View targetView) {
        ViewGroup.LayoutParams params = targetView.getLayoutParams();

        if (targetSize != 0.0f) {
            params.width = (int) targetSize;
            params.height = (int) targetSize;
        } else {
            if (parentSize != 0.0f) {
                params.width = (int) parentSize;
                params.height = (int) parentSize;
            }
        }
        targetView.setLayoutParams(params);
    }


    /**
     * The core method of animation
     *
     * @param target which image view to anim
     * @param animTo anim to which vector
     */
    private void updateImageView(ImageView target, int animTo) {
        Drawable drawable = mContext.getDrawable(animTo);
        if (drawable == null) {
            Log.e(mContext.getPackageCodePath(), "ResId is wrong .");
            return;
        }

        target.setImageDrawable(drawable);


        if (drawable instanceof AnimatedVectorDrawable) {
            final AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            animatedVectorDrawable.start();
        }
    }

}
