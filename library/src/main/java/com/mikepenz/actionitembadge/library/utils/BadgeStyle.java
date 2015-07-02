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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(int colorPressed) {
        this.colorPressed = colorPressed;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
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
}
