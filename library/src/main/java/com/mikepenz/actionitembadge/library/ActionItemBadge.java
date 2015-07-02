package com.mikepenz.actionitembadge.library;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.actionitembadge.library.utils.BadgeDrawableBuilder;
import com.mikepenz.actionitembadge.library.utils.BadgeStyle;
import com.mikepenz.actionitembadge.library.utils.UIUtil;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

/**
 * Created by mikepenz on 23.07.14.
 */
public class ActionItemBadge {
    public enum BadgeStyles {
        GREY(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#e0e0e0"), Color.parseColor("#c7c7c7"), Color.BLACK)),
        DARK_GREY(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#606060"), Color.parseColor("#3e3e3e"), Color.WHITE)),
        RED(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#FF4444"), Color.parseColor("#CC0000"), Color.WHITE)),
        BLUE(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#33B5E5"), Color.parseColor("#0099CC"), Color.WHITE)),
        GREEN(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#99CC00"), Color.parseColor("#669900"), Color.WHITE)),
        PURPLE(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#AA66CC"), Color.parseColor("#9933CC"), Color.WHITE)),
        YELLOW(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_badge, Color.parseColor("#FFBB33"), Color.parseColor("#FF8800"), Color.WHITE)),
        GREY_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#e0e0e0"), Color.parseColor("#c7c7c7"), Color.BLACK)),
        DARK_GREY_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#606060"), Color.parseColor("#3e3e3e"), Color.WHITE)),
        RED_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#FF4444"), Color.parseColor("#CC0000"), Color.WHITE)),
        BLUE_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#33B5E5"), Color.parseColor("#0099CC"), Color.WHITE)),
        GREEN_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#99CC00"), Color.parseColor("#669900"), Color.WHITE)),
        PURPLE_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#AA66CC"), Color.parseColor("#9933CC"), Color.WHITE)),
        YELLOW_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_badge_large, Color.parseColor("#FFBB33"), Color.parseColor("#FF8800"), Color.WHITE)),;

        private BadgeStyle style;

        BadgeStyles(BadgeStyle style) {
            this.style = style;
        }

        public BadgeStyle getStyle() {
            return style;
        }
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), BadgeStyles.DARK_GREY.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyles style, int badgeCount) {
        update(act, menu, icon, style.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyle style, int badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, int badgeCount) {
        update(act, menu, icon, iconColor, BadgeStyles.DARK_GREY.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, BadgeStyles style, int badgeCount) {
        update(act, menu, icon, iconColor, style.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, BadgeStyle style, int badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(iconColor).actionBar(), style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeStyles style, int badgeCount) {
        update(act, menu, icon, style.getStyle(), badgeCount);
    }

    /**
     * update the given menu item with icon and badgeCount and style
     *
     * @param act
     * @param menu
     * @param icon
     * @param style
     * @param badgeCount
     */
    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeStyle style, int badgeCount) {
        if (menu != null) {
            menu.setActionView(style.getLayout());
            FrameLayout badge = (FrameLayout) menu.getActionView();

            if (style.getStyle() == BadgeStyle.Style.DEFAULT) {
                ImageView imageView = (ImageView) badge.findViewById(R.id.menu_badge_icon);
                if (icon != null) {
                    UIUtil.setBackground(imageView, icon);
                }
            }

            //get the badgeView. We don't need to check which one we get as a button extends a TextView ;)
            TextView badgeView = (TextView) badge.findViewById(R.id.menu_badge);
            if (badgeCount == Integer.MIN_VALUE) {
                badgeView.setVisibility(View.GONE);
            } else {
                badgeView.setVisibility(View.VISIBLE);
                badgeView.setText(String.valueOf(badgeCount));
                UIUtil.setBackground(badgeView, new BadgeDrawableBuilder().color(style.getColor()).colorPressed(style.getColorPressed()).build(act));
                badgeView.setTextColor(style.getTextColor());
            }

            badge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    act.onOptionsItemSelected(menu);
                }
            });

            menu.setVisible(true);
        }
    }


    public static void update(final MenuItem menu, int badgeCount) {
        update(menu, null, badgeCount);
    }

    /**
     * update the given menu item with icon and badgeCount
     *
     * @param menu
     * @param icon
     * @param badgeCount
     */
    public static void update(final MenuItem menu, Drawable icon, int badgeCount) {
        if (menu != null) {
            FrameLayout badge = (FrameLayout) menu.getActionView();
            // i know this is not nice but the best solution to allow doing an update without a style
            ImageView imageView = (ImageView) badge.findViewById(R.id.menu_badge_icon);
            if (imageView != null) {
                if (icon != null) {
                    UIUtil.setBackground(imageView, icon);
                }

                TextView textView = (TextView) badge.findViewById(R.id.menu_badge);
                if (badgeCount < 0) {
                    textView.setVisibility(View.GONE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(String.valueOf(badgeCount));
                }
            } else {
                Button button = (Button) badge.findViewById(R.id.menu_badge);
                button.setText(String.valueOf(badgeCount));
            }
        }
    }


    /**
     * hide the given menu item
     *
     * @param menu
     */
    public static void hide(MenuItem menu) {
        menu.setVisible(false);
    }
}
