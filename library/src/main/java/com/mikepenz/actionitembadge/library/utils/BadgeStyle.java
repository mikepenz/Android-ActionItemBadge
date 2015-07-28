package com.mikepenz.actionitembadge.library.utils;

import android.graphics.Color;

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

    public Style getStyle() {
        return style;
    }

    public BadgeStyle setStyle(Style style) {
        this.style = style;
        return this;
    }

    public int getLayout() {
        return layout;
    }

    public BadgeStyle setLayout(int layout) {
        this.layout = layout;
        return this;
    }

    public int getColor() {
        return color;
    }

    public BadgeStyle setColor(int color) {
        this.color = color;
        return this;
    }

    public int getColorPressed() {
        return colorPressed;
    }

    public BadgeStyle setColorPressed(int colorPressed) {
        this.colorPressed = colorPressed;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public BadgeStyle setTextColor(int textColor) {
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

    public BadgeStyle(Style style, int layout, int color, int colorPressed) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
    }

    public BadgeStyle(Style style, int layout, int color, int colorPressed, int textColor) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
        this.textColor = textColor;
    }

    public BadgeStyle(Style style, int layout, int color, int colorPressed, int textColor, int corner) {
        this.style = style;
        this.layout = layout;
        this.color = color;
        this.colorPressed = colorPressed;
        this.textColor = textColor;
        this.corner = corner;
    }
}
