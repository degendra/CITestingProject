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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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
    public void test_MainActivity() throws InterruptedException {
        onView(withId(R.id.editText)).perform(typeText("Degendra"));
        onView(withId(R.id.button)).perform(click());

        Thread.sleep(5000);
    }


}