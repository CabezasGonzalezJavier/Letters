package com.thedeveloperworldisyours.letters;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by javierg on 23/05/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void checkText() {
        onView(withId(R.id.main_activity_edit_text)).perform(typeText("Engine"));
        onView(withId(R.id.main_activity_button)).perform(click());

        onView(withId(R.id.main_activity_first_text)).check(matches(withText("E")));
        onView(withId(R.id.main_activity_second_text)).check(matches(withText("n")));
        onView(withId(R.id.main_activity_third_text)).check(matches(withText("g")));

        onView(withId(R.id.main_activity_fourth_text)).check(matches(withText("i")));
        onView(withId(R.id.main_activity_fifth_text)).check(matches(withText("n")));
        onView(withId(R.id.main_activity_sixth_text)).check(matches(withText("e")));

        onView(withId(R.id.main_activity_main_text)).check(matches(withText("______")));
    }
}
