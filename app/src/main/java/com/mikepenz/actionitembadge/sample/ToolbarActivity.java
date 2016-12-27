package com.mikepenz.actionitembadge.sample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.aboutlibraries.ui.LibsSupportFragment;
import com.mikepenz.actionitembadge.R;
import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.actionitembadge.library.ActionItemBadgeAdder;
import com.mikepenz.actionitembadge.library.utils.BadgeStyle;
import com.mikepenz.actionitembadge.library.utils.NumberUtils;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class ToolbarActivity extends AppCompatActivity {

    private static final int SAMPLE2_ID = 34536;
    private Drawer drawer;
    private BadgeStyle style = ActionItemBadge.BadgeStyles.DARK_GREY.getStyle();
    private BadgeStyle bigStyle = ActionItemBadge.BadgeStyles.DARK_GREY_LARGE.getStyle();
    private int badgeCount = 10;
    private int badgeDrawableCount = 100000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_main);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = new DrawerBuilder(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Activity").withIdentifier(1000).withSelectable(false),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Default (Dark Grey)").withIdentifier(1),
                        new PrimaryDrawerItem().withName("Grey").withIdentifier(2),
                        new PrimaryDrawerItem().withName("Red").withIdentifier(3),
                        new PrimaryDrawerItem().withName("Blue").withIdentifier(4),
                        new PrimaryDrawerItem().withName("Green").withIdentifier(5),
                        new PrimaryDrawerItem().withName("Purple").withIdentifier(6),
                        new PrimaryDrawerItem().withName("Yellow").withIdentifier(7),
                        new PrimaryDrawerItem().withName("Custom").withIdentifier(8),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("SWITCH").withIdentifier(9).withSelectable(false),
                        new PrimaryDrawerItem().withName("RESET COUNT").withIdentifier(10).withSelectable(false),
                        new PrimaryDrawerItem().withName("HIDE BADGE").withIdentifier(11).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                        if (iDrawerItem.getIdentifier() == 1000) {
                            Intent intent = new Intent(ToolbarActivity.this, MainActivity.class);
                            startActivity(intent);
                            return false;
                        } else if (iDrawerItem.getIdentifier() == 1) {
                            style = ActionItemBadge.BadgeStyles.DARK_GREY.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.DARK_GREY_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 2) {
                            style = ActionItemBadge.BadgeStyles.GREY.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.GREY_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 3) {
                            style = ActionItemBadge.BadgeStyles.RED.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.RED_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 4) {
                            style = ActionItemBadge.BadgeStyles.BLUE.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.BLUE_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 5) {
                            style = ActionItemBadge.BadgeStyles.GREEN.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.GREEN_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 6) {
                            style = ActionItemBadge.BadgeStyles.PURPLE.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.PURPLE_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 7) {
                            style = ActionItemBadge.BadgeStyles.YELLOW.getStyle();
                            bigStyle = ActionItemBadge.BadgeStyles.YELLOW_LARGE.getStyle();
                        } else if (iDrawerItem.getIdentifier() == 8) {
                            style = new BadgeStyle(BadgeStyle.Style.DEFAULT, R.layout.menu_action_item_badge, Color.parseColor("#FE0665"), Color.parseColor("#CC0548"), Color.parseColor("#EEEEEE"));
                            bigStyle = new BadgeStyle(BadgeStyle.Style.LARGE, R.layout.menu_action_item_badge_large, Color.parseColor("#FE0665"), Color.parseColor("#CC0548"), Color.parseColor("#EEEEEE"));
                        } else if (iDrawerItem.getIdentifier() == 9) {
                            BadgeStyle temp = style;
                            style = bigStyle;
                            bigStyle = temp;
                            Toast.makeText(ToolbarActivity.this, "No icon provided for the previous large style", Toast.LENGTH_LONG).show();
                        } else if (iDrawerItem.getIdentifier() == 10) {
                            badgeCount = 10;
                        } else if (iDrawerItem.getIdentifier() == 11) {
                            badgeCount = Integer.MIN_VALUE;
                        }

                        invalidateOptionsMenu();

                        return false;
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSelectedItem(3)
                .withSavedInstance(savedInstanceState)
                .build();

        //init and show about libraries :D
        LibsSupportFragment fragment = new LibsBuilder().withFields(R.string.class.getFields()).withVersionShown(true).withLicenseShown(true).supportFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (drawer != null) {
            outState = drawer.saveInstanceState(outState);
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        if (badgeCount == 0) {
            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
        } else {
            ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), FontAwesome.Icon.faw_android, style, badgeCount);
        }
        if (badgeDrawableCount == 0) {
            ActionItemBadge.hide(menu.findItem(R.id.item_sampleBadge_drawable));
        } else {
            ActionItemBadge.update(this, menu.findItem(R.id.item_sampleBadge_drawable), ContextCompat.getDrawable(this, R.drawable.ic_notification), style, NumberUtils.formatNumber(badgeDrawableCount));
        }

        new ActionItemBadgeAdder().act(this).menu(menu).title(R.string.sample_2).itemDetails(0, SAMPLE2_ID, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).add(bigStyle, 1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_samplebadge) {
            Toast.makeText(this, R.string.sample_3, Toast.LENGTH_SHORT).show();
            badgeCount--;
            ActionItemBadge.update(item, badgeCount);
        } else if (id == R.id.item_sampleBadge_drawable) {
            Toast.makeText(this, R.string.sample_3, Toast.LENGTH_SHORT).show();
            badgeDrawableCount = badgeDrawableCount - 1000;
            ActionItemBadge.update(item, NumberUtils.formatNumber(badgeDrawableCount));
            return true;
        } else if (id == SAMPLE2_ID) {
            Toast.makeText(this, R.string.sample_4, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
