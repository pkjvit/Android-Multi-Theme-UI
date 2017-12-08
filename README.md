# UI-MultiTheme
Android multiple theme implementation with day night mode.

![Custom Date Picker](https://github.com/pkjvit/UI-MultiTheme/blob/master/gif_multi_theme_240x480.gif)


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
