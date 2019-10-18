# Android-ActionItemBadge [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.mikepenz/actionitembadge/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.mikepenz/actionitembadge) [![Android Arsenal](http://img.shields.io/badge/Android%20Arsenal-Android--ActionItemBadge-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/755)

[![Join the chat at https://gitter.im/mikepenz/Android-ActionItemBadge](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/mikepenz/Android-ActionItemBadge?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

ActionItemBadge is a library which offers a simple and easy to use method to add a badge to your action item!

## Screenshots
![Image](https://raw.githubusercontent.com/mikepenz/Android-ActionItemBadge/develop/DEV/screenshot/screenshot1_small.png)
![Image](https://raw.githubusercontent.com/mikepenz/Android-ActionItemBadge/develop/DEV/screenshot/screenshot2_small.png)

## Include in your project
### Using Maven
The ActionItemBadge Library is pushed to [Maven Central], so you just need to add the following dependency to your `build.gradle`.

```javascript
dependencies {
	implementation 'com.mikepenz:actionitembadge:4.0.0'

	//SUB-DEPENDENCIES
	//Android-Iconics - used to provide an easy API for icons 
	implementation 'com.mikepenz:iconics-core:{latestVersion}@aar'
}
```

### Additional dependency for the icon font
If you are going to use the icon font you will have to add additional dependency for the font. 
You can find all available addons here: https://github.com/mikepenz/Android-Iconics#2-choose-your-desired-fonts

## UPGRADE NOTES
#### < 4.0.0
- If you come from a version prior 4.0.0 you will have to upgrade to AndroidX and Iconics v4

#### < 3.0.0
- If you come from a version prior 3.0.0 you will have to rename some classes, and the default styles also found a new place. Just check out the updated sample app for all the changes.

## Usage
### menu.xml
Create your menu.xml as you would do normally and add the app:actionLayout param.
It is also a good idea to set showAsAction="always" (The badge can only be shown in the actionbar)
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/item_samplebadge"
        app:actionLayout="@layout/menu_action_item_badge"
        app:showAsAction="always"
        android:title="@string/sample_1"/>
</menu>
```
### Activity
Override the onCreateOptionsMenu method
```java
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

	    //you can add some logic (hide it if the count == 0)
        if (badgeCount > 0) {
            ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), FontAwesome.Icon.faw_android, ActionItemBadge.BadgeStyles.DARK_GREY, badgeCount);
        } else {
            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
        }

	    //If you want to add your ActionItem programmatically you can do this too. You do the following:
        new ActionItemBadgeAdder().act(this).menu(menu).title(R.string.sample_2).itemDetails(0, SAMPLE2_ID, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).add(bigStyle, 1);
        return super.onCreateOptionsMenu(menu);
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
            ActionItemBadge.update(item, badgeCount);
            return true;
        } else if (id == SAMPLE2_ID) {
            Toast.makeText(this, R.string.sample_4, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
```

# Dependencies
* Android-Iconics - https://github.com/mikepenz/Android-Iconics


# Developed By

* Mike Penz 
 * [mikepenz.com](http://mikepenz.com) - <mikepenz@gmail.com>
 * [paypal.me/mikepenz](http://paypal.me/mikepenz)

# License

    Copyright 2019 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
