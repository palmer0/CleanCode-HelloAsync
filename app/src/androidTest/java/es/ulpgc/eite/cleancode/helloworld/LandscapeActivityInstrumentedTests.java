package es.ulpgc.eite.cleancode.helloworld;


import android.content.pm.ActivityInfo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.helloworld.hello.HelloActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LandscapeActivityInstrumentedTests {

  @Rule
  public ActivityTestRule<HelloActivity> mActivityTestRule =
      new ActivityTestRule<>(HelloActivity.class);

  @Test
  public void helloActivityLandscapeTest() {
    ViewInteraction button10 = onView(allOf(
        withId(R.id.sayHelloButton), withText("Say Hello"), isDisplayed()));
    button10.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text10 = onView(allOf(
        withId(R.id.helloMessage), withText("Hello World!"), isDisplayed()));
    text10.check(matches(withText("Hello World!")));

    ViewInteraction button2 = onView(allOf(
        withId(R.id.goByeButton), withText("Go Bye"), isDisplayed()));
    button2.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text2 = onView(allOf(
        withId(R.id.byeMessage), withText("Hello World!"), isDisplayed()));
    text2.check(matches(withText("Hello World!")));

    ViewInteraction button3 = onView(allOf(
        withId(R.id.sayByeButton), withText("Say Bye"), isDisplayed()));
    button3.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text3 = onView(allOf(
        withId(R.id.byeMessage), withText("Bye World!"), isDisplayed()));
    text3.check(matches(withText("Bye World!")));

    ViewInteraction button4 = onView(allOf(
        withId(R.id.goHelloButton), withText("Go Hello"), isDisplayed()));
    button4.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text4 = onView(allOf(
        withId(R.id.helloMessage), withText("Bye World!"), isDisplayed()));
    text4.check(matches(withText("Bye World!")));

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text5 = onView(allOf(
        withId(R.id.helloMessage), withText("Bye World!"), isDisplayed()));
    text5.check(matches(withText("Bye World!")));

    ViewInteraction button5 = onView(allOf(
        withId(R.id.goByeButton), withText("Go Bye"), isDisplayed()));
    button5.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text6 = onView(allOf(
        withId(R.id.byeMessage), withText("Bye World!"), isDisplayed()));
    text6.check(matches(withText("Bye World!")));

    ViewInteraction button6 = onView(allOf(
        withId(R.id.sayByeButton), withText("Say Bye"), isDisplayed()));
    button6.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction button7 = onView(allOf(
        withId(R.id.goHelloButton), withText("Go Hello"), isDisplayed()));
    button7.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text1 = onView(allOf(withId(R.id.helloMessage)));
    text1.check(matches(withText("")));

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text12 = onView(allOf(withId(R.id.helloMessage)));
    text12.check(matches(withText("")));

    ViewInteraction button8 = onView(allOf(
        withId(R.id.sayHelloButton), withText("Say Hello"), isDisplayed()));
    button8.perform(click());

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction button9 = onView(allOf(
        withId(R.id.goByeButton), withText("Go Bye"), isDisplayed()));
    button9.perform(click());

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text13 = onView(allOf(withId(R.id.byeMessage)));
    text13.check(matches(withText("")));

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text14 = onView(allOf(withId(R.id.byeMessage)));
    text14.check(matches(withText("")));

    pressBack();

    // Added a sleep statement to match the app's execution delay.
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction text7 = onView(allOf(
        withId(R.id.helloMessage), withText("Hello World!"), isDisplayed()));
    text7.check(matches(withText("Hello World!")));
  }

}
