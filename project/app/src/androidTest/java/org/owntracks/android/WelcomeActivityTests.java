package org.owntracks.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.owntracks.android.ui.welcome.WelcomeActivity;

import androidx.preference.PreferenceManager;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;

@LargeTest
public class WelcomeActivityTests {
    Intent intent;

    @Rule
    public ActivityTestRule<WelcomeActivity> activityTestRule = new ActivityTestRule<>(WelcomeActivity.class, true, false);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Before
    /*
    Clear sharedPreferences to give a clean slate
     */
    public void setUp() {

        Context targetContext = getInstrumentation().getTargetContext();
        SharedPreferences.Editor preferencesEditor = PreferenceManager.getDefaultSharedPreferences(targetContext).edit();
        preferencesEditor.clear().commit();
        activityTestRule.launchActivity(intent);
    }

    @Test
    public void WelcomeScreenLoadsAndResponds() {
        assertEquals(0,Build.VERSION.SDK);
        if (Build.VERSION.SDK_INT > 0) {
            onView(withId(R.id.btn_next)).perform(click());
        }
//        onView(withId(R.id.done)).perform(click());
    }
}