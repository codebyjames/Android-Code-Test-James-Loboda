package com.loboda.james.androidcodetestjamesloboda.animation;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by James on 2/2/2017.
 *
 * Animate any view with a file from anim directory
 * or use the methods provided.
 */

public class AnimationObject {


    public AnimationObject(){}

    /**
     * Grow in size
     *
     * @param view
     * @param duration
     */
    public static void grow(View view, int duration) {
        final ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);

        growAnim.setDuration(duration);
        view.startAnimation(growAnim);
    }

    /**
     * Grow in size: custom scale
     * @param view
     * @param duration
     * @param scale
     */
    public static void grow(View view, int duration, float scale) {
        final ScaleAnimation growAnim = new ScaleAnimation(scale, scale, scale, scale,
                Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);

        growAnim.setDuration(duration);
        view.startAnimation(growAnim);
    }

    /**
     * Shrink in size
     *
     * @param view
     * @param duration
     */
    public static void shrink(View view, int duration) {
        final ScaleAnimation shrinkAnim = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);

        shrinkAnim.setDuration(duration);
        view.startAnimation(shrinkAnim);
    }

    /**
     * Stop current animation
     * @param view
     */
    public static void stopAnimation(View view){

        view.clearAnimation();

    }

}
