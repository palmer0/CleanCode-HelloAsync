package es.ulpgc.eite.cleancode.helloworld;


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
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PortraitActivityInstrumentedTests {

    @Rule
    public ActivityTestRule<HelloActivity> mActivityTestRule =
            new ActivityTestRule<>(HelloActivity.class);

    @Test
    public void helloActivityPortraitTest() {

        ViewInteraction helloMessage1 = onView(
                allOf(withId(R.id.helloMessage)));
        helloMessage1.check(matches(withText("")));

        ViewInteraction sayHelloButton1 = onView(allOf(
                withId(R.id.sayHelloButton),
                withText("Say Hello"), isDisplayed())
        );
        sayHelloButton1.perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage2 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Hello World!"), isDisplayed())
        );
        helloMessage2.check(matches(withText("Hello World!")));

        ViewInteraction goByeButton1 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton1.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage1 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Hello World!"), isDisplayed())
        );
        byeMessage1.check(matches(withText("Hello World!")));

        ViewInteraction sayByeButton1 = onView(allOf(
                withId(R.id.sayByeButton),
                withText("Say Bye"), isDisplayed())
        );
        sayByeButton1.perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage2 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Bye World!"), isDisplayed())
        );
        byeMessage2.check(matches(withText("Bye World!")));

        pressBack();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage3 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Hello World!"), isDisplayed())
        );
        helloMessage3.check(matches(withText("Hello World!")));

        ViewInteraction goByeButton2 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton2.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage3 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Hello World!"), isDisplayed())
        );
        byeMessage3.check(matches(withText("Hello World!")));

        ViewInteraction sayByeButton2 = onView(allOf(
                withId(R.id.sayByeButton), withText("Say Bye"), isDisplayed())
        );
        sayByeButton2.perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage4 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Bye World!"), isDisplayed())
        );
        byeMessage4.check(matches(withText("Bye World!")));

        ViewInteraction goHelloButton1 = onView(allOf(
                withId(R.id.goHelloButton),
                withText("Go Hello"), isDisplayed())
        );
        goHelloButton1.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage4 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Bye World!"), isDisplayed())
        );
        helloMessage4.check(matches(withText("Bye World!")));

        ViewInteraction goByeButton3 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton3.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage5 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Bye World!"), isDisplayed())
        );
        byeMessage5.check(matches(withText("Bye World!")));

        pressBack();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage5 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Bye World!"), isDisplayed())
        );
        helloMessage5.check(matches(withText("Bye World!")));

        ViewInteraction sayHelloButton2 = onView(allOf(
                withId(R.id.sayHelloButton),
                withText("Say Hello"), isDisplayed())
        );
        sayHelloButton2.perform(click());




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        ViewInteraction goByeButton4 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton4.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage6 = onView(allOf(withId(R.id.byeMessage)));
        byeMessage6.check(matches(withText("")));

        pressBack();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage6 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Hello World!"), isDisplayed())
        );
        helloMessage6.check(matches(withText("Hello World!")));

        ViewInteraction sayHelloButton3 = onView(allOf(
                withId(R.id.sayHelloButton),
                withText("Say Hello"), isDisplayed())
        );
        sayHelloButton3.perform(click());



        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */



        ViewInteraction goByeButton5 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton5.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage7 = onView(allOf(withId(R.id.byeMessage)));
        byeMessage7.check(matches(withText("")));

        ViewInteraction goHelloButton2 = onView(allOf(
                withId(R.id.goHelloButton),
                withText("Go Hello"), isDisplayed())
        );
        goHelloButton2.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage7=onView(allOf(withId(R.id.helloMessage)));
        helloMessage7.check(matches(withText("")));

        ViewInteraction sayHelloButton4 = onView(allOf(
                withId(R.id.sayHelloButton),
                withText("Say Hello"), isDisplayed())
        );
        sayHelloButton4.perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage8 = onView(allOf(
                withId(R.id.helloMessage),
                withText("Hello World!"), isDisplayed())
        );
        helloMessage8.check(matches(withText("Hello World!")));

        ViewInteraction goByeButton6 = onView(allOf(
                withId(R.id.goByeButton), withText("Go Bye"), isDisplayed())
        );
        goByeButton6.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction byeMessage8 = onView(allOf(
                withId(R.id.byeMessage),
                withText("Hello World!"), isDisplayed())
        );
        byeMessage8.check(matches(withText("Hello World!")));

        ViewInteraction sayByeButton3 = onView(allOf(
                withId(R.id.sayByeButton), withText("Say Bye"), isDisplayed())
        );
        sayByeButton3.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction goHelloButton3 = onView(allOf(
                withId(R.id.goHelloButton),
                withText("Go Hello"), isDisplayed())
        );
        goHelloButton3.perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction helloMessage9=onView(allOf(withId(R.id.helloMessage)));
        helloMessage9.check(matches(withText("")));
    }

}
