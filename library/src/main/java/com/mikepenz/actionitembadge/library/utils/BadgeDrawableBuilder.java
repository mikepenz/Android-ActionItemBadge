package com.mikepenz.actionitembadge.library.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.StateSet;

import com.mikepenz.actionitembadge.library.R;

/**
 * Created by mikepenz on 02.07.15.
 */
public class BadgeDrawableBuilder {
    private int mColor = 0;
    private int mColorPressed = 0;
    private int mCorners = -1;
    private int mStroke = -1;
    private int mStrokeColor = 0;

    public BadgeDrawableBuilder() {
    }

    public BadgeDrawableBuilder color(@ColorInt int color) {
        this.mColor = color;
        return this;
    }

    public BadgeDrawableBuilder colorPressed(@ColorInt int colorPressed) {
        this.mColorPressed = colorPressed;
        return this;
    }

    public BadgeDrawableBuilder corners(int corners) {
        this.mCorners = corners;
        return this;
    }

    public BadgeDrawableBuilder stroke(int stroke) {
        this.mStroke = stroke;
        return this;
    }

    public BadgeDrawableBuilder strokeColor(@ColorInt int strokeColor) {
        this.mStrokeColor = strokeColor;
        return this;
    }

    public StateListDrawable build(Context ctx) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        GradientDrawable normal = (GradientDrawable) ContextCompat.getDrawable(ctx, R.drawable.action_item_badge);
        GradientDrawable selected = (GradientDrawable) normal.getConstantState().newDrawable().mutate();

        normal.setColor(mColor);
        selected.setColor(mColorPressed);

        if (mStroke > -1) {
            normal.setStroke(mStroke, mStrokeColor);
            selected.setStroke(mStroke, mStrokeColor);
        }

        if (mCorners > -1) {
            normal.setCornerRadius(mCorners);
            selected.setCornerRadius(mCorners);
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, selected);
        stateListDrawable.addState(StateSet.WILD_CARD, normal);

        return stateListDrawable;
    }
}
