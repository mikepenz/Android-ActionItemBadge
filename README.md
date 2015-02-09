#Android-ActionItemBadge [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.mikepenz.actionitembadge/library/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.mikepenz.actionitembadge/library) [![Android Arsenal](http://img.shields.io/badge/Android%20Arsenal-Android--ActionItemBadge-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/755)

ActionItemBadge is a library which offers a simple and easy to use method to add a badge to your action item!


##Screenshots
![Image](https://raw.githubusercontent.com/mikepenz/Android-ActionItemBadge/master/DEV/screenshot/screenshot1_small.png).
![Image](https://raw.githubusercontent.com/mikepenz/Android-ActionItemBadge/master/DEV/screenshot/screenshot2_small.png)

##Include in your project
###Using Maven
The AboutLibraries Library is pushed to [Maven Central], so you just need to add the following dependency to your `build.gradle`.

```javascript
dependencies {
	compile('com.mikepenz.actionitembadge:library:2.0.1@aar') {
	    transitive = true
	}
}
```

If you want to use this library with the old ActionBar. Do the following.
```javascript
dependencies {
	compile 'com.tundem.actionitembadge:library:1.2.0@aar'
}
```

You use ActionbarSherlock? No problem there's now a SNAPSHOT release for ActionbarSherlock. Just do the following:

Add the SNAPSHOT repo to your repositories:
```javascript
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' }
```

And the compile dependency
```javascript
dependencies {
	compile 'com.tundem.actionitembadge:library-abs:1.2.0@aar'
}
```

##Usage
###menu.xml
Create your menu.xml as you would do normally and add the app:actionLayout param.
It is also a good idea to set showAsAction="always" (The badge can only be shown in the actionbar)
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/item_samplebadge"
        app:actionLayout="@layout/menu_badge"
        app:showAsAction="always"
        android:title="@string/sample_1"/>
</menu>
```
###Activity
Override the onCreateOptionsMenu method
```java
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

	//you can add some logic (hide it if the count == 0)
        if (badgeCount > 0) {
            ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), FontAwesome.Icon.faw_android, ActionItemBadge.BadgeStyle.DARKGREY, badgeCount);
        } else {
            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
        }

	//If you want to add your ActionItem programmatically you can do this too. You do the following:
        new ActionItemBadge.Add().act(this).menu(menu).title(R.string.sample_2).itemDetails(0, SAMPLE2_ID, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).build(ActionItemBadge.BadgeStyle.BLUE_LARGE, 1);
        return true;
    }
```
If you want to update the item itself you can do the required stuff in the onOptionsItemSelected method and
call invalidateOptionsMenu() afterwards.
```java
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
```

#Dependencies
* Android-Iconics - https://github.com/mikepenz/Android-Iconics


#Developed By

* Mike Penz - http://mikepenz.com - <mike@lanora.io>


#License

    Copyright 2014 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
