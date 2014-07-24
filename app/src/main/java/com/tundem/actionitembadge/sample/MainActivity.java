package com.tundem.actionitembadge.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.joanzapata.android.iconify.Iconify;
import com.tundem.actionitembadge.R;
import com.tundem.actionitembadge.library.ActionItemBadge;


public class MainActivity extends Activity {
    private int badgeCount = 10;

    private static final int SAMPLE2_ID = 34535;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        if (badgeCount > 0) {
            ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), Iconify.IconValue.fa_android, ActionItemBadge.BadgeStyle.DARKGREY, badgeCount);
        } else {
            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
        }

        new ActionItemBadge.Add().act(this).menu(menu).title(R.string.sample_2).itemDetails(0, SAMPLE2_ID, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).build(ActionItemBadge.BadgeStyle.BLUE_LARGE, 1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_opensource) {
            /*
            Intent i = new Intent(getApplicationContext(), LibsActivity.class);
            i.putExtra(Libs.BUNDLE_FIELDS, Libs.toStringArray(R.string.class.getFields()));
            i.putExtra(Libs.BUNDLE_LIBS, new String[]{"AndroidIconify"});
            i.putExtra(Libs.BUNDLE_VERSION, true);
            i.putExtra(Libs.BUNDLE_LICENSE, true);

            i.putExtra(Libs.BUNDLE_TITLE, getString(R.string.action_opensource));

            startActivity(i);
            */
            return true;
        } else if (id == R.id.item_samplebadge) {
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
