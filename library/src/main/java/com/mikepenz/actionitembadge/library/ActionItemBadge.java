package com.mikepenz.actionitembadge.library;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        GREY(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#e0e0e0"), Color.parseColor("#c7c7c7"), Color.BLACK)),
        DARK_GREY(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#606060"), Color.parseColor("#3e3e3e"), Color.WHITE)),
        RED(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#FF4444"), Color.parseColor("#CC0000"), Color.WHITE)),
        BLUE(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#33B5E5"), Color.parseColor("#0099CC"), Color.WHITE)),
        GREEN(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#99CC00"), Color.parseColor("#669900"), Color.WHITE)),
        PURPLE(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#AA66CC"), Color.parseColor("#9933CC"), Color.WHITE)),
        YELLOW(new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#FFBB33"), Color.parseColor("#FF8800"), Color.WHITE)),
        GREY_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#e0e0e0"), Color.parseColor("#c7c7c7"), Color.BLACK)),
        DARK_GREY_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#606060"), Color.parseColor("#3e3e3e"), Color.WHITE)),
        RED_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#FF4444"), Color.parseColor("#CC0000"), Color.WHITE)),
        BLUE_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#33B5E5"), Color.parseColor("#0099CC"), Color.WHITE)),
        GREEN_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#99CC00"), Color.parseColor("#669900"), Color.WHITE)),
        PURPLE_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#AA66CC"), Color.parseColor("#9933CC"), Color.WHITE)),
        YELLOW_LARGE(new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#FFBB33"), Color.parseColor("#FF8800"), Color.WHITE)),;

        private BadgeStyle style;

        BadgeStyles(BadgeStyle style) {
            this.style = style;
        }

        public BadgeStyle getStyle() {
            return style;
        }
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int badgeCount) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), BadgeStyles.DARK_GREY.getStyle(), null);
        } else {
            update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), BadgeStyles.DARK_GREY.getStyle(), String.valueOf(badgeCount));
        }
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, String badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), BadgeStyles.DARK_GREY.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyles style, int badgeCount) {
        update(act, menu, icon, style.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyle style, int badgeCount) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), style, null);
        } else {
            update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), style, String.valueOf(badgeCount));
        }
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyle style, String badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(Color.WHITE).actionBar(), style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, int badgeCount) {
        update(act, menu, icon, iconColor, BadgeStyles.DARK_GREY.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, BadgeStyles style, int badgeCount) {
        update(act, menu, icon, iconColor, style.getStyle(), badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, BadgeStyle style, int badgeCount) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(act, menu, new IconicsDrawable(act, icon).color(iconColor).actionBar(), style, null);
        } else {
            update(act, menu, new IconicsDrawable(act, icon).color(iconColor).actionBar(), style, String.valueOf(badgeCount));
        }
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int iconColor, BadgeStyle style, String badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).color(iconColor).actionBar(), style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeStyles style, int badgeCount) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(act, menu, icon, style.getStyle(), null);
        } else {
            update(act, menu, icon, style.getStyle(), String.valueOf(badgeCount));
        }
    }

    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeStyles style, String badgeCount) {
        update(act, menu, icon, style.getStyle(), badgeCount);
    }


    public static void update(final MenuItem menu, int badgeCount) {
        update(menu, null, badgeCount);
    }

    public static void update(final MenuItem menu, String badgeCount) {
        update(menu, null, badgeCount);
    }

    public static void update(final MenuItem menu, Drawable icon, int badgeCount) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(null, menu, icon, (BadgeStyle) null, null);
        } else {
            update(null, menu, icon, (BadgeStyle) null, String.valueOf(badgeCount));
        }
    }

    public static void update(final MenuItem menu, Drawable icon, String badgeCount) {
        update(null, menu, icon, (BadgeStyle) null, badgeCount);

    }

    public static void update(final Activity activity, final MenuItem menu, Drawable icon, BadgeStyle style, int badgeCount) {
        update (activity, menu, icon, style, badgeCount, null);
    }

    public static void update(final Activity activity, final MenuItem menu, Drawable icon, BadgeStyle style, int badgeCount, ActionItemBadgeListener listener) {
        if (badgeCount == Integer.MIN_VALUE) {
            update(activity, menu, icon, style, null, listener);
        } else {
            update(activity, menu, icon, style, String.valueOf(badgeCount), listener);
        }
    }

    /**
     * update the given menu item with icon, badgeCount and style
     *
     * @param activity   use to bind onOptionsItemSelected
     * @param menu
     * @param icon
     * @param style
     * @param badgeCount
     */
    public static void update(final Activity activity, final MenuItem menu, Drawable icon, BadgeStyle style, String badgeCount) {
        update(activity, menu, icon, style, badgeCount, null);
    }

    /**
     * update the given menu item with icon, badgeCount and style
     *
     * @param activity   use to bind onOptionsItemSelected / and to display the toast
     * @param menu
     * @param icon
     * @param style
     * @param badgeCount
     * @param listener
     */
    public static void update(final Activity activity, final MenuItem menu, Drawable icon, BadgeStyle style, String badgeCount, final ActionItemBadgeListener listener) {
        if (menu == null) return;

        FrameLayout badge;
        TextView badgeView;
        ImageView imageView;

        if (style == null) {
            badge = (FrameLayout) menu.getActionView();
        } else {
            badge = (FrameLayout) menu.setActionView(style.getLayout()).getActionView();
        }

        badgeView = (TextView) badge.findViewById(R.id.menu_badge);
        imageView = (ImageView) badge.findViewById(R.id.menu_badge_icon);

        //Display icon in ImageView
        if (imageView != null && icon != null) {
            imageView.setImageDrawable(icon);
        }

        //Bind onOptionsItemSelected to the activity
        if (activity != null) {
            badge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean consumed = false;
                    if (listener != null) {
                        consumed = listener.onOptionsItemSelected(menu);
                    }
                    if (!consumed) {
                        activity.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, menu);
                    }
                }
            });

            badge.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Display display = activity.getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int width = size.x;
                    Toast toast = Toast.makeText(activity, menu.getTitle(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, width / 5, UIUtil.convertDpToPx(activity, 48)); //your width and height
                    toast.show();
                    return true;
                }
            });
        }

        //Apply style if it's set
        if (style != null) {
            UIUtil.setBackground(badgeView, new BadgeDrawableBuilder().corners(style.getCorner()).color(style.getColor()).colorPressed(style.getColorPressed()).strokeColor(style.getStrokeColor()).stroke(style.getStroke()).build(activity));
            badgeView.setTextColor(style.getTextColor());
        }

        //Manage min value
        if (badgeCount == null) {
            badgeView.setVisibility(View.GONE);
        } else {
            badgeView.setVisibility(View.VISIBLE);
            badgeView.setText(badgeCount);
        }

        menu.setVisible(true);
    }


    /**
     * hide the given menu item
     *
     * @param menu
     */
    public static void hide(MenuItem menu) {
        menu.setVisible(false);
    }


    public interface ActionItemBadgeListener {
        boolean onOptionsItemSelected(MenuItem menu);
    }
}
