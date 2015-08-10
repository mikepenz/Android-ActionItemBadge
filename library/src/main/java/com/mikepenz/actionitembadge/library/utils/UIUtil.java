package com.mikepenz.actionitembadge.library.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

/**
 * Created by mikepenz on 02.07.15.
 */
public class UIUtil {

    /**
     * helper method to set the background depending on the android version
     *
     * @param v
     * @param d
     */
    @SuppressLint("NewApi")
    public static void setBackground(View v, Drawable d) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackgroundDrawable(d);
        } else {
            v.setBackground(d);
        }
    }


    /**
     * helper method to get the drawable by its resource. specific to the correct android version
     *
     * @param c
     * @param drawableRes
     * @return
     */
    public static Drawable getCompatDrawable(Context c, int drawableRes) {
        Drawable d = null;
        try {
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                d = c.getResources().getDrawable(drawableRes);
            } else {
                d = c.getResources().getDrawable(drawableRes, c.getTheme());
            }
        } catch (Exception ex) {
        }
        return d;
    }


    public static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
