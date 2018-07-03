<img src="https://github.com/pkjvit/Android-Multi-Theme-UI/blob/master/ScreenShots/flex.jpg">

# Android-Multi-Theme-UI
This example cover Android multi theme UI implementation with day night mode.

![Custom Date Picker](https://github.com/pkjvit/UI-MultiTheme/blob/master/gif_multi_theme_240x480.gif)

## Screen Shots

<div>
<img src="https://github.com/pkjvit/Android-Multi-Theme-UI/blob/master/ScreenShots/multi_theme_01.png" width="200">
<img width="20">
<img src="https://github.com/pkjvit/Android-Multi-Theme-UI/blob/master/ScreenShots/multi_theme_02.png" width="200">
<img width="20">
<img src="https://github.com/pkjvit/Android-Multi-Theme-UI/blob/master/ScreenShots/multi_theme_03.png" width="200">
</div>


## Day Night Mode
Appcompat has come with a new theme family **Theme.AppCompat.DayNight**.

It has four modes :
- **MODE_NIGHT_NO** : the day (light) theme.
- **MODE_NIGHT_YES** : the night (dark) theme.
- **MODE_NIGHT_AUTO** : day/night mode change according to time.
- **MODE_NIGHT_FOLLOW_SYSTEM (default)**. this mode uses system night modes settings to determine if it is night or not.

#### Easy to use
1. Your theme must uses **Theme.AppCompat.DayNight**
```
<style name="AppTheme" parent="Theme.AppCompat.DayNight.DarkActionBar">
    <!-- Customize your theme here. -->
    <item name="colorPrimary">@color/primaryColorAmber</item>
    <item name="colorPrimaryDark">@color/primaryDarkColorAmber</item>
    <item name="colorAccent">@color/secondaryColorAmber</item>
</style>
```
2. Your activity must extends **AppCompatActivity** to change day/night mode at runtime.
```
getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
```

## Multi Theme
It's very easy to change theme at runtime in android.

1. First you need to create some well defined themes in xml-styles.
```
<!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.DayNight.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/primaryColorAmber</item>
        <item name="colorPrimaryDark">@color/primaryDarkColorAmber</item>
        <item name="colorAccent">@color/secondaryColorAmber</item>
    </style>

    <style name="AppTheme.NoActionBar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
    </style>

    <style name="AppTheme.RED" parent="AppTheme.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/primaryColorRed</item>
        <item name="colorPrimaryDark">@color/primaryDarkColorRed</item>
        <item name="colorAccent">@color/secondaryColorRed</item>
    </style>

    <style name="AppTheme.PINK" parent="AppTheme.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/primaryColorPink</item>
        <item name="colorPrimaryDark">@color/primaryDarkColorPink</item>
        <item name="colorAccent">@color/secondaryColorPink</item>
    </style>
```
    
2. To change theme at runtime use following code in your base activity **onCreate()** method and just before **setContentView()**.
    
```
// To change theme just put your theme id.
int theme = getThemeFromPreferences(); // R.style.AppTheme_RED
setTheme(theme);
```
  
3. To change theme of your setting/preference activity (from where you are changing theme) you need to recreate that activity by calling following method of that activity.
```
//store your theme id in preference
saveThemeInPreferences(R.style.AppTheme_RED);
//recreate this activity to see changes
SettingActivity.this.recreate();
```





## Licence
    Copyright 2018 Pankaj Jangid

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
