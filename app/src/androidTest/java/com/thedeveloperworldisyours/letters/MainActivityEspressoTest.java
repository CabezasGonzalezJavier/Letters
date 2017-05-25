package com.thedeveloperworldisyours.letters;

import android.os.SystemClock;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.thedeveloperworldisyours.letters.main.MainActivity;

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
        onView(withId(R.id.main_fragment_edit_text)).perform(typeText("Engine"));
        onView(withId(R.id.main_fragment_button)).perform(click());

        onView(withId(R.id.main_fragment_first_text)).check(matches(withText("E")));
        onView(withId(R.id.main_fragment_second_text)).check(matches(withText("n")));
        onView(withId(R.id.main_fragment_third_text)).check(matches(withText("g")));

        onView(withId(R.id.main_fragment_fourth_text)).check(matches(withText("i")));
        onView(withId(R.id.main_fragment_fifth_text)).check(matches(withText("n")));
        onView(withId(R.id.main_fragment_sixth_text)).check(matches(withText("e")));

        onView(withId(R.id.main_fragment_main_text)).check(matches(withText("______")));
    }

    @Test
    public void checkFromServer() {
        onView(withId(R.id.main_fragment_server_button)).perform(click());
        onView(withId(R.id.main_fragment_first_text)).check(matches(withText("0")));
        onView(withId(R.id.main_fragment_second_text)).check(matches(withText("1")));
        onView(withId(R.id.main_fragment_third_text)).check(matches(withText("2")));

        onView(withId(R.id.main_fragment_fourth_text)).check(matches(withText("3")));
        onView(withId(R.id.main_fragment_fifth_text)).check(matches(withText("4")));
        onView(withId(R.id.main_fragment_sixth_text)).check(matches(withText("ú")));

        onView(withId(R.id.main_fragment_main_text)).check(matches(withText("______")));
    }
}
