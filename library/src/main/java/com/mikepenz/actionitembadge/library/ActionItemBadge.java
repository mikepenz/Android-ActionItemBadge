package com.mikepenz.actionitembadge.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

/**
 * Created by mikepenz on 23.07.14.
 */
public class ActionItemBadge {
    public enum BadgeStyle {
        GREY(Style.DEFAULT, R.drawable.menu_grey_badge, R.layout.menu_badge),
        DARKGREY(Style.DEFAULT, R.drawable.menu_darkgrey_badge, R.layout.menu_badge),
        RED(Style.DEFAULT, R.drawable.menu_red_badge, R.layout.menu_badge),
        BLUE(Style.DEFAULT, R.drawable.menu_blue_badge, R.layout.menu_badge),
        GREEN(Style.DEFAULT, R.drawable.menu_green_badge, R.layout.menu_badge),
        PURPLE(Style.DEFAULT, R.drawable.menu_purple_badge, R.layout.menu_badge),
        YELLOW(Style.DEFAULT, R.drawable.menu_yellow_badge, R.layout.menu_badge),
        GREY_LARGE(Style.LARGE, R.drawable.menu_grey_badge_large, R.layout.menu_badge_large),
        DARKGREY_LARGE(Style.LARGE, R.drawable.menu_darkgrey_badge_large, R.layout.menu_badge_large),
        RED_LARGE(Style.LARGE, R.drawable.menu_red_badge_large, R.layout.menu_badge_large),
        BLUE_LARGE(Style.LARGE, R.drawable.menu_blue_badge_large, R.layout.menu_badge_large),
        GREEN_LARGE(Style.LARGE, R.drawable.menu_green_badge_large, R.layout.menu_badge_large),
        PURPLE_LARGE(Style.LARGE, R.drawable.menu_purple_badge_large, R.layout.menu_badge_large),
        YELLOW_LARGE(Style.LARGE, R.drawable.menu_yellow_badge_large, R.layout.menu_badge_large);

        private Style style;
        private int drawable;
        private int layout;

        private BadgeStyle(Style style, int drawable, int layout) {
            this.style = style;
            this.drawable = drawable;
            this.layout = layout;
        }

        public Style getStyle() {
            return style;
        }

        public int getDrawable() {
            return drawable;
        }

        public int getLayout() {
            return layout;
        }


        public enum Style {
            DEFAULT(1),
            LARGE(2);

            private int style;

            private Style(int style) {
                this.style = style;
            }

            public int getStyle() {
                return style;
            }
        }
    }

    public static class Add {
        public Add() {

        }

        public Add(Activity activity, Menu menu, String title) {
            this.activity = activity;
            this.menu = menu;
            this.title = title;
        }

        private Activity activity;

        public Add act(Activity activity) {
            this.activity = activity;
            return this;
        }

        private Menu menu;

        public Add menu(Menu menu) {
            this.menu = menu;
            return this;
        }

        private String title;

        public Add title(String title) {
            this.title = title;
            return this;
        }

        public Add title(int resId) {
            if (activity == null) {
                throw new RuntimeException("Activity not set");
            }

            this.title = activity.getString(resId);
            return this;
        }

        private Integer groupId;
        private Integer itemId;
        private Integer order;

        public Add itemDetails(int groupId, int itemId, int order) {
            this.groupId = groupId;
            this.itemId = itemId;
            this.order = order;
            return this;
        }

        private Integer showAsAction;

        public Add showAsAction(int showAsAction) {
            this.showAsAction = showAsAction;
            return this;
        }

        public Menu build(int badgeCount) {
            return build((Drawable) null, BadgeStyle.GREY_LARGE, badgeCount);
        }

        public Menu build(BadgeStyle style, int badgeCount) {
            return build((Drawable) null, style, badgeCount);
        }

        public Menu build(IIcon icon, int badgeCount) {
            return build(new IconicsDrawable(activity, icon).colorRes(R.color.actionbar_text).actionBarSize(), BadgeStyle.GREY, badgeCount);
        }

        public Menu build(Drawable icon, int badgeCount) {
            return build(icon, BadgeStyle.GREY, badgeCount);
        }

        public Menu build(IIcon icon, BadgeStyle style, int badgeCount) {
            return build(new IconicsDrawable(activity, icon).colorRes(R.color.actionbar_text).actionBarSize(), style, badgeCount);
        }

        public Menu build(Drawable icon, BadgeStyle style, int badgeCount) {
            MenuItem item;
            if (groupId != null && itemId != null && order != null) {
                item = menu.add(groupId, itemId, order, title);
            } else {
                item = menu.add(title);
            }

            if (showAsAction != null) {
                item.setShowAsAction(showAsAction);
            }

            item.setActionView(style.getLayout());
            update(activity, item, icon, style, badgeCount);
            return menu;
        }
    }

    public static void update(final Activity act, final MenuItem menu, int badgeCount) {
        update(act, menu, (Drawable) null, BadgeStyle.GREY_LARGE, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, BadgeStyle style, int badgeCount) {
        if (style.getStyle() != BadgeStyle.Style.LARGE) {
            throw new RuntimeException("You are not allowed to call update without an icon on a Badge with default style");
        }
        update(act, menu, (Drawable) null, style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, int badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).colorRes(R.color.actionbar_text).actionBarSize(), BadgeStyle.GREY, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, Drawable icon, int badgeCount) {
        update(act, menu, icon, BadgeStyle.GREY, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, IIcon icon, BadgeStyle style, int badgeCount) {
        update(act, menu, new IconicsDrawable(act, icon).colorRes(R.color.actionbar_text).actionBarSize(), style, badgeCount);
    }

    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeStyle style, int badgeCount) {
        View badge = menu.getActionView();

        if (style.getStyle() == BadgeStyle.Style.DEFAULT) {
            ImageView imageView = (ImageView) badge.findViewById(R.id.menu_badge_icon);
            ActionItemBadge.setBackground(imageView, icon);

            TextView textView = (TextView) badge.findViewById(R.id.menu_badge_text);
            if (badgeCount < 0) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
                textView.setText(String.valueOf(badgeCount));
                textView.setBackgroundResource(style.getDrawable());
            }
        } else {
            Button button = (Button) badge.findViewById(R.id.menu_badge_button);
            button.setBackgroundResource(style.getDrawable());
            button.setText(String.valueOf(badgeCount));
        }

        badge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.onOptionsItemSelected(menu);
            }
        });

        menu.setVisible(true);
    }

    public static void hide(MenuItem menu) {
        menu.setVisible(false);
    }

    @SuppressLint("NewApi")
    private static void setBackground(View v, Drawable d) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackgroundDrawable(d);
        } else {
            v.setBackground(d);
        }
    }
}
