package com.mikepenz.actionitembadge.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.aboutlibraries.ui.LibsFragment;
import com.mikepenz.actionitembadge.R;
import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class ToolbarActivity extends AppCompatActivity {

    private Drawer drawer;

    private ActionItemBadge.BadgeStyle style = ActionItemBadge.BadgeStyle.DARKGREY;
    private ActionItemBadge.BadgeStyle bigStyle = ActionItemBadge.BadgeStyle.DARKGREY_LARGE;
    private int badgeCount = 10;

    private static final int SAMPLE2_ID = 34536;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_main);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = new DrawerBuilder(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Activity").withIdentifier(1000).withCheckable(false),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Default (Dark Grey)").withIdentifier(1),
                        new PrimaryDrawerItem().withName("Grey").withIdentifier(2),
                        new PrimaryDrawerItem().withName("Red").withIdentifier(3),
                        new PrimaryDrawerItem().withName("Blue").withIdentifier(4),
                        new PrimaryDrawerItem().withName("Green").withIdentifier(5),
                        new PrimaryDrawerItem().withName("Purple").withIdentifier(6),
                        new PrimaryDrawerItem().withName("Yellow").withIdentifier(7),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("RESET COUNT").withIdentifier(10)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        if (iDrawerItem.getIdentifier() == 1000) {
                            Intent intent = new Intent(ToolbarActivity.this, MainActivity.class);
                            startActivity(intent);
                            return false;
                        } else if (iDrawerItem.getIdentifier() == 1) {
                            style = ActionItemBadge.BadgeStyle.DARKGREY;
                            bigStyle = ActionItemBadge.BadgeStyle.DARKGREY_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 2) {
                            style = ActionItemBadge.BadgeStyle.GREY;
                            bigStyle = ActionItemBadge.BadgeStyle.GREY_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 3) {
                            style = ActionItemBadge.BadgeStyle.RED;
                            bigStyle = ActionItemBadge.BadgeStyle.RED_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 4) {
                            style = ActionItemBadge.BadgeStyle.BLUE;
                            bigStyle = ActionItemBadge.BadgeStyle.BLUE_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 5) {
                            style = ActionItemBadge.BadgeStyle.GREEN;
                            bigStyle = ActionItemBadge.BadgeStyle.GREEN_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 6) {
                            style = ActionItemBadge.BadgeStyle.PURPLE;
                            bigStyle = ActionItemBadge.BadgeStyle.PURPLE_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 7) {
                            style = ActionItemBadge.BadgeStyle.YELLOW;
                            bigStyle = ActionItemBadge.BadgeStyle.YELLOW_LARGE;
                        } else if (iDrawerItem.getIdentifier() == 10) {
                            badgeCount = 10;
                        }

                        invalidateOptionsMenu();

                        return false;
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSelectedItem(2)
                .withSavedInstance(savedInstanceState)
                .build();

        //init and show about libraries :D
        LibsFragment fragment = new LibsBuilder().withFields(R.string.class.getFields()).withVersionShown(true).withLicenseShown(true).fragment();
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

        if (badgeCount > 0) {
            ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), FontAwesome.Icon.faw_android, style, badgeCount);
        } else {
            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
        }

        new ActionItemBadge.Add().act(this).menu(menu).title(R.string.sample_2).itemDetails(0, SAMPLE2_ID, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).build(bigStyle, 1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.item_samplebadge) {
            Toast.makeText(this, R.string.sample_3, Toast.LENGTH_SHORT).show();
            badgeCount--;
            invalidateOptionsMenu();
            return true;
        } else if (id == SAMPLE2_ID) {
            Toast.makeText(this, R.string.sample_4, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
