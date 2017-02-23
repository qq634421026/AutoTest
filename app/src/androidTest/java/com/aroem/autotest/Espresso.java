package com.aroem.autotest;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/*
 * Created by zhanghongyu on 2017/2/23.
 *
click():
返回一个点击action,Espresso利用这个方法执行一次点击操作,就和我们自己手动点击按钮一样,只不过Espresso把点击这个操作自动化了,下面的方法都是一样的道理,就不再赘述了.
clearText():
返回一个清除指定view中的文本action,在测试EditText时用的比较多
swipeLeft():
返回一个从右往左滑动的action,这个在测试ViewPager时特别有用
swipeRight():
返回一个从左往右滑动的action,这个在测试ViewPager时特别有用
swipeDown():
返回一个从上往下滑动的action
swipeUp():
返回一个从下往上滑动的action
closeSoftKeyboard():
返回一个关闭输入键盘的action
pressBack():
返回一个点击手机上返回键的action
doubleClick():
返回一个双击action
longClick():
返回一个长按action
scrollTo():
返回一个移动action
replaceText():
返回一个替换文本action
openLinkWithText():
返回一个打开指定链接action


    //根据id找到ViewPager页面,并判断是否可见
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.viewPager), isDisplayed()));
        // 向左滑动viewpager页面,下面3句也可以写成一句话,Espresso会从左到右依次执行
        // appCompatViewPager.perform(swipeLeft(),swipeLeft(),swipeLeft());
        appCompatViewPager.perform(swipeLeft());
        appCompatViewPager.perform(swipeLeft());
        appCompatViewPager.perform(swipeLeft());
        //根据文本找到"开始体验"按钮,并判断是否可见
        ViewInteraction appCompatButton = onView(
                allOf(withText("开始体验"), isDisplayed()));
        //执行按钮的点击操作
        appCompatButton.perform(click());
        //根据控件的id和该控件的父布局id找到控件,并判断是否可见
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.appointmentCallCar), withParent(withId(R.id.callCarLayout)), isDisplayed()));
        //执行该控件的点击操作
        appCompatImageView.perform(click());
        //根据id找到控件,并判断是否可见
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.phoneNumber), isDisplayed()));
        //执行替换文本操作,说白了就是输入文本,输入完毕之后关闭输入法键盘
        appCompatEditText.perform(replaceText("18894001263"), closeSoftKeyboard());
        //根据id和显示的文本内容找到控件,并判断是否可见
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.getPassword), withText("获取验证码"), isDisplayed()));
        //执行该控件的点击操作
        appCompatButton2.perform(click());
        //根据id找到控件,并判断是否可见
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password), isDisplayed()));
        //执行替换文本操作,说白了就是输入文本,输入完毕之后关闭输入法键盘
        appCompatEditText2.perform(replaceText("2454"), closeSoftKeyboard());
        //根据id和显示的文本内容找到控件,并判断是否可见
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.login), withText("登录"), isDisplayed()));
        //执行该控件的点击操作
        appCompatButton3.perform(click());
 */
@RunWith(AndroidJUnit4.class) @LargeTest public class Espresso {

  @Rule public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

  @Test public void open() {
    //onView(withId(R.id.a)).check(matches(withText("Hello, World!")));
    ViewInteraction appCompatEditText = onView(allOf(withId(R.id.a), isDisplayed()));
    //执行替换文本操作,说白了就是输入文本,输入完毕之后关闭输入法键盘
    appCompatEditText.perform(replaceText("12"), closeSoftKeyboard());

    ViewInteraction appCompatEditTextb = onView(allOf(withId(R.id.b), isDisplayed()));
    //执行替换文本操作,说白了就是输入文本,输入完毕之后关闭输入法键盘
    appCompatEditTextb.perform(replaceText("21"), closeSoftKeyboard());
    ViewInteraction appCompatButton2 = onView(allOf(withId(R.id.add), isDisplayed()));
    //执行该控件的点击操作
    appCompatButton2.perform(click());
    onView(withId(R.id.result)).check(matches(withText("33")));

  }
}
