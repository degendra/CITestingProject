package np.pro.degendra.citestingproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by bajra on 6/29/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private static final String TAG = MainActivity.class.getName();
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(
            MainActivity.class);

    @Test
    public void test_EmptyFirstName() throws InterruptedException {
        onView(withId(R.id.firstName)).perform(typeText(""));
        onView(withId(R.id.lastName)).perform(typeText("Sivakoti"));
        onView(withId(R.id.save)).perform(click());
        onView(withId(R.id.firstNameWrapper));

        onView(withText(R.string.error_first_name_empty)).check(matches(isDisplayed()));

        Thread.sleep(5000);
    }

    @Test
    public void test_EmptyLastName() throws InterruptedException {
        onView(withId(R.id.firstName)).perform(typeText("Degendra"));
        onView(withId(R.id.save)).perform(click());

        onView(withText(R.string.error_last_name_empty)).check(matches(isDisplayed()));

        Thread.sleep(5000);
    }

    @Test
    public void test_MainActivity() throws InterruptedException {
        onView(withId(R.id.firstName)).perform(typeText("Degendra"));
        onView(withId(R.id.lastName)).perform(typeText("Sivakoti"));
        onView(withId(R.id.save)).perform(click());

        Thread.sleep(5000);
    }


}