package com.tehmou.rxbookapp.activities;

import com.tehmou.rxbookapp.R;
import com.tehmou.rxbookapp.activities.MainActivity;
import com.tehmou.rxbookapp.activities.utils.SystemAnimations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
/**
 * Created by Pawel Polanski on 4/27/15.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void setUp() {
        SystemAnimations.disableAll(InstrumentationRegistry.getContext());
    }

    @Test
    public void testInitialActivityState() {
        onView(withText(R.string.repository_fragment_intro)).check(matches(isDisplayed()));
        onView(withId(R.id.widget_avatar_image_view)).check(matches(isDisplayed()));
        onView(withText(R.string.repository_fragment_change)).check(matches(isDisplayed()));
    }

    @Test
    public void testPressingChangeButtonLaunchesRepositoriesActivity() {
        onView(withText(R.string.repository_fragment_change)).perform(click());
        onView(withId(R.id.repositories_view)).check(matches(isDisplayed()));
    }

    @AfterClass
    public static void tearDown() {
        SystemAnimations.enableAll(InstrumentationRegistry.getContext());
    }

}
