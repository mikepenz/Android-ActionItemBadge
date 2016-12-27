package com.mikepenz.actionitembadge.library;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.actionitembadge.library.utils.BadgeStyle;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

public class ActionItemBadgeAdder {
    public ActionItemBadgeAdder() {

    }

    public ActionItemBadgeAdder(Activity activity, Menu menu, String title) {
        this.activity = activity;
        this.menu = menu;
        this.title = title;
    }

    private Activity activity;

    public ActionItemBadgeAdder act(Activity activity) {
        this.activity = activity;
        return this;
    }

    private Menu menu;

    public ActionItemBadgeAdder menu(Menu menu) {
        this.menu = menu;
        return this;
    }

    private String title;

    public ActionItemBadgeAdder title(String title) {
        this.title = title;
        return this;
    }

    public ActionItemBadgeAdder title(int resId) {
        if (activity == null) {
            throw new RuntimeException("Activity not set");
        }

        this.title = activity.getString(resId);
        return this;
    }

    private Integer groupId;
    private Integer itemId;
    private Integer order;

    public ActionItemBadgeAdder itemDetails(int groupId, int itemId, int order) {
        this.groupId = groupId;
        this.itemId = itemId;
        this.order = order;
        return this;
    }

    private Integer showAsAction;

    public ActionItemBadgeAdder showAsAction(int showAsAction) {
        this.showAsAction = showAsAction;
        return this;
    }

    public MenuItem add(int badgeCount) {
        return add(ActionItemBadge.BadgeStyles.GREY_LARGE, badgeCount);
    }

    public MenuItem add(ActionItemBadge.BadgeStyles style, int badgeCount) {
        return add(style.getStyle(), badgeCount);
    }

    public MenuItem add(BadgeStyle style, int badgeCount) {
        return add((Drawable) null, style, badgeCount, null);
    }

    public MenuItem add(IIcon icon, int badgeCount) {
        return add(icon, Color.WHITE, badgeCount);
    }

    public MenuItem add(IIcon icon, int iconColor, int badgeCount) {
        return add(new IconicsDrawable(activity, icon).color(iconColor).actionBar(), ActionItemBadge.BadgeStyles.GREY, badgeCount);
    }

    public MenuItem add(Drawable icon, int badgeCount) {
        return add(icon, ActionItemBadge.BadgeStyles.GREY, badgeCount);
    }

    public MenuItem add(IIcon icon, ActionItemBadge.BadgeStyles style, int badgeCount) {
        return add(icon, style.getStyle(), badgeCount);
    }

    public MenuItem add(IIcon icon, BadgeStyle style, int badgeCount) {
        return add(icon, Color.WHITE, style, badgeCount);
    }

    public MenuItem add(IIcon icon, int iconColor, BadgeStyle style, int badgeCount) {
        return add(new IconicsDrawable(activity, icon).color(iconColor).actionBar(), style, badgeCount, null);
    }

    public MenuItem add(Drawable icon, ActionItemBadge.BadgeStyles style, int badgeCount) {
        return add(icon, style.getStyle(), badgeCount, null);
    }

    public MenuItem add(Drawable icon, BadgeStyle style, int badgeCount, ActionItemBadge.ActionItemBadgeListener listener) {
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
        ActionItemBadge.update(activity, item, icon, style, badgeCount, listener);
        return item;
    }
}