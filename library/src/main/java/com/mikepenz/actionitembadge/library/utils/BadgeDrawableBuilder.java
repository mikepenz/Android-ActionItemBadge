package com.mikepenz.actionitembadge.library.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;

import com.mikepenz.actionitembadge.library.R;

/**
 * Created by mikepenz on 02.07.15.
 */
public class BadgeDrawableBuilder {
    private int mColor = 0;
    private int mColorPressed = 0;
    private int mCorners = -1;
    private int mPadding = -1;

    public BadgeDrawableBuilder() {
    }

    public BadgeDrawableBuilder color(int color) {
        this.mColor = color;
        return this;
    }

    public BadgeDrawableBuilder colorPressed(int colorPressed) {
        this.mColorPressed = colorPressed;
        return this;
    }

    public BadgeDrawableBuilder corners(int corners) {
        this.mCorners = corners;
        return this;
    }

    public BadgeDrawableBuilder padding(int padding) {
        this.mPadding = padding;
        return this;
    }

    public StateListDrawable build(Context ctx) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        GradientDrawable normal = (GradientDrawable) UIUtil.getCompatDrawable(ctx, R.drawable.badge);
        GradientDrawable selected = (GradientDrawable) normal.getConstantState().newDrawable().mutate();

        normal.setColor(mColor);
        selected.setColor(mColorPressed);

        if (mCorners > -1) {
            normal.setCornerRadius(mCorners);
            selected.setCornerRadius(mCorners);
        }

        if (mPadding > -1) {
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, selected);
        stateListDrawable.addState(StateSet.WILD_CARD, normal);

        return stateListDrawable;
    }
}
