package com.aroem.autotest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/*
 * Created by zhanghongyu on 2017/2/23.
 *  http://v.youku.com/v_show/id_XNTM5NzgwNTQ4.htmlscr
 */

public class FirstUiautomatorTest extends UiAutomatorTestCase {
  public void testDemo() throws UiObjectNotFoundException {

    UiDevice.getInstance(getInstrumentation());
    //19-27 行 其实就是用这个框架提供的功能来直接启动你的app.
    //这里其实主要就是要找到你的app那个textview 然后点击他 具体api自己去慢慢看吧
    getUiDevice().pressHome();
    UiScrollable appView = new UiScrollable(new UiSelector().scrollable(true));

    Context context = InstrumentationRegistry.getContext();
    Intent launchIntent = new Intent();
    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //启动应用
    launchIntent.setComponent(
        new ComponentName("com.aroem.autotest", "com.aroem.autotest.MainActivity"));
    context.startActivity(launchIntent);

    //UiObject myApp =
    //    appView.getChildByText(new UiSelector().className("android.widget.TextView"), "AutoTest");
    //myApp.click();
    //要等到新的窗口出来才继续往下走
    //myApp.clickAndWaitForNewWindow();
    UiObject a = new UiObject(new UiSelector().resourceId("com.aroem.autotest:id/a"));
    UiObject b = new UiObject(new UiSelector().resourceId("com.aroem.autotest:id/b"));
    UiObject add =
        new UiObject(new UiSelector().resourceId("com.aroem.autotest:id/add"));
    UiObject result =
        new UiObject(new UiSelector().resourceId("com.aroem.autotest:id/result"));

    a.setText("12");
    b.setText("21");
    add.click();
    assertEquals(33, Integer.parseInt(result.getText().toString()));
  }
}
