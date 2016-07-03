package com.mikepenz.actionitembadge.library.utils;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;

/**
 * Created by mikepenz on 02.07.15.
 */
public class BadgeStyle {
    public enum Style {
        DEFAULT(1),
        LARGE(2);

        private int style;

        Style(int style) {
            this.style = style;
        }

        public int getStyle() {
            return style;
        }
    }

    private Style style;
    private int layout;
    private int color;
    private int colorPressed;
    private int textColor = Color.WHITE;
    private int corner = -1;
    private int stroke = -1;
    private int strokeColor = Color.RED;

    public Style getStyle() {
        return style;
    }

    public BadgeStyle setStyle(Style style) {
        this.style = style;
        return this;
    }

    @LayoutRes
    public int getLayout() {
        return layout;
    }

    public BadgeStyle setLayout(@LayoutRes int layout) {
        this.layout = layout;
        return this;
    }

    @ColorInt
    public int getColor() {
        return color;
    }

    public BadgeStyle setColor(@ColorInt int color) {
        this.color = color;
        return this;
    }

    @ColorInt
    public int getColorPressed() {
        return colorPressed;
    }

    public BadgeStyle setColorPressed(@ColorInt int colorPressed) {
        this.colorPressed = colorPressed;
        return this;
    }

    @ColorInt
    public int getTextColor() {
        return textColor;
    }

    public BadgeStyle setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getCorner() {
        return corner;
    }

    public BadgeStyle setCorner(int corner) {
        this.corner = corner;
        return this;
    }

    public int getStroke() {
        return stroke;
    }

    public BadgeStyle setStroke(int stroke) {
        this.stroke = stroke;
        return this;
    }

    @ColorInt
    public int getStrokeColor() {
        return strokeColor;
    }

    public BadgeStyle setStrokeColor(@ColorInt int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public BadgeStyle(Style style, @LayoutRes int layout, @ColorInt int color, @ColorInt int colorPressed) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
    }

    public BadgeStyle(Style style, @LayoutRes int layout, @ColorInt int color, @ColorInt int colorPressed, @ColorInt int textColor) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
        this.textColor = textColor;
    }

    public BadgeStyle(Style style, @LayoutRes int layout, @ColorInt int color, @ColorInt int colorPressed, @ColorInt int textColor, int corner) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
        this.textColor = textColor;
        this.corner = corner;
    }
}
