package com.example.firestore;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Espresso_Test {

    @Rule
    public ActivityTestRule<Home> mActivityTestRule = new ActivityTestRule<>(Home.class);

    @Test
    public void espresso_Test() {
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.studentbutton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.textViewSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("devents@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("asdfghjkl"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.confrmeditTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("asdfghjkl"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.confrmeditTextPassword), withText("asdfghjkl"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.Full_Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Dream Events"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.Full_Name), withText("Dream Events"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.Studentdob),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("14 sep 1999"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.Studentdob), withText("14 sep 1999"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText8.perform(pressImeActionButton());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.Studentid),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("1456"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.Studentid), withText("1456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText10.perform(pressImeActionButton());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.Collegenamestudend),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("Cegep"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.Collegenamestudend), withText("Cegep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText12.perform(pressImeActionButton());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.coursestudend),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("Mad"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.coursestudend), withText("Mad"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText14.perform(pressImeActionButton());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.Groupstudent),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("307"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.Groupstudent), withText("307"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText16.perform(pressImeActionButton());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonSignup), withText("Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.buttonLogout),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                15),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editTextEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("devents@gmail.com"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("asdfghjkl"), closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editTextPassword), withText("asdfghjkl"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText19.perform(pressImeActionButton());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.buttonSignin), withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.Notifications), withText("Notifications"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton4.perform(click());

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.Club), withText("Club"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction cardView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerview_in_student),
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0)),
                        1),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.Join_me_button), withText("JOIN"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatButton6.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.join_club), withText("My Clubs"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton7.perform(click());

        DataInteraction cardView2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listview_u_joinclub),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        cardView2.perform(click());

        DataInteraction cardView3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_of_studentjoinevent),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        cardView3.perform(click());

        DataInteraction cardView4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_of_studentjoinevent),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        cardView4.perform(click());

        DataInteraction cardView5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.list_of_studentjoinevent),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        cardView5.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.feedbackbutton),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                17),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.feedbackname),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(replaceText("Dream Events"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.feedbackdec),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText21.perform(replaceText("very useful app"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.submitfeedback), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        pressBack();

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.Messagesstudent),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                16),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton9.perform(scrollTo(), click());

        DataInteraction appCompatTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                2)))
                .atPosition(0);
        appCompatTextView.perform(click());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.msg_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText22.perform(replaceText("Hello "), closeSoftKeyboard());

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.btn_send),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        pressBack();

        ViewInteraction appCompatImageView6 = onView(
                allOf(withId(R.id.buttonLogout),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                15),
                        isDisplayed()));
        appCompatImageView6.perform(click());

        pressBack();

        ViewInteraction appCompatImageView7 = onView(
                allOf(withId(R.id.faculitybutton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageView7.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.aboutuss), withText("About Us"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        pressBack();

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.textViewSignUpt), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.teacherTextEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText23.perform(replaceText("event@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.teacherTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText24.perform(replaceText("asdfghjkl"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.teacherconfirmpassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText25.perform(replaceText("asdfghjkl"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.teacherFull_Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText26.perform(replaceText("Events"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.teacherid),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText27.perform(replaceText("4567"), closeSoftKeyboard());

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.teacherdob),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText28.perform(replaceText("15 dec 2000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.teacherdob), withText("15 dec 2000"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText29.perform(pressImeActionButton());

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.teacherCollegename),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText30.perform(replaceText("Cegep"), closeSoftKeyboard());

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.teacherCollegename), withText("Cegep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText31.perform(pressImeActionButton());

        ViewInteraction appCompatEditText32 = onView(
                allOf(withId(R.id.teacherdepartment),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText32.perform(replaceText("It"), closeSoftKeyboard());

        ViewInteraction appCompatEditText33 = onView(
                allOf(withId(R.id.teacherdepartment), withText("It"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText33.perform(pressImeActionButton());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.teacherSignup), withText("Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.teacherNotifications), withText("Notifications"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton12.perform(click());

        pressBack();

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.teacherClub), withText("Club"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.floatingActionButtonteacherclub),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText34 = onView(
                allOf(withId(R.id.club_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                1)));
        appCompatEditText34.perform(scrollTo(), replaceText("Design"), closeSoftKeyboard());

        ViewInteraction appCompatEditText35 = onView(
                allOf(withId(R.id.club_Description),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                2)));
        appCompatEditText35.perform(scrollTo(), replaceText("Learn Design"), closeSoftKeyboard());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.createclub_button), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatButton14.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.teacherClub), withText("Club"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton15.perform(click());

        DataInteraction cardView6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.createidlist),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                2)))
                .atPosition(0);
        cardView6.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.floatingActionButton_teacher_Event),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText36 = onView(
                allOf(withId(R.id.event___name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                1)));
        appCompatEditText36.perform(scrollTo(), replaceText("App Design"), closeSoftKeyboard());

        ViewInteraction appCompatEditText37 = onView(
                allOf(withId(R.id.EVENT_date),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                2)));
        appCompatEditText37.perform(scrollTo(), replaceText("17 nov 2019"), closeSoftKeyboard());

        ViewInteraction appCompatEditText38 = onView(
                allOf(withId(R.id.event_Description),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText38.perform(scrollTo(), replaceText("Learn App Design "), closeSoftKeyboard());

        ViewInteraction appCompatEditText39 = onView(
                allOf(withId(R.id.event_Description), withText("Learn App Design "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText39.perform(scrollTo(), click());

        ViewInteraction appCompatEditText40 = onView(
                allOf(withId(R.id.event_Description), withText("Learn App Design "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText40.perform(scrollTo(), click());

        ViewInteraction appCompatEditText41 = onView(
                allOf(withId(R.id.event_Description), withText("Learn App Design "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText41.perform(scrollTo(), click());

        ViewInteraction appCompatEditText42 = onView(
                allOf(withId(R.id.event_Description), withText("Learn App Design "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText42.perform(scrollTo(), click());

        ViewInteraction appCompatEditText43 = onView(
                allOf(withId(R.id.event_Description), withText("Learn App Design "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView2),
                                        0),
                                3)));
        appCompatEditText43.perform(scrollTo(), click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.floatingActionButton_teacher_Event),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        pressBack();

        pressBack();

        pressBack();

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.teacherMessages), withText("Messages"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton16.perform(click());

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton17.perform(scrollTo(), click());

        DataInteraction appCompatTextView3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                2)))
                .atPosition(0);
        appCompatTextView3.perform(click());

        ViewInteraction appCompatEditText44 = onView(
                allOf(withId(R.id.msg_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText44.perform(replaceText("how are you?"), closeSoftKeyboard());

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.btn_send),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        pressBack();

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.buttonfeedback),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                14),
                        isDisplayed()));
        appCompatImageView9.perform(click());

        pressBack();

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.buttonLogoutt),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                13),
                        isDisplayed()));
        appCompatImageView10.perform(click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
