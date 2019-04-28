package com.myobservatory.myobservatory;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class MyObsevatoryTest {
    private UiDevice mUIDevice = null;
    private Context mContext = null;
    //定义要打开的app package
    String APP = "hko.MyObservatory_v1_0";

    @Before
    public void setUp() throws RemoteException {
        //获得device对象
        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mContext = InstrumentationRegistry.getContext();
        //唤醒屏幕
        if (!mUIDevice.isScreenOn()) {
            mUIDevice.wakeUp();
        }
        //按home键
        mUIDevice.pressHome();
    }

    @Test
    public void testForObservatory() throws Exception {
        //引入日志
        Logger.addLogAdapter(new AndroidLogAdapter());

        //启动app
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);
        mContext.startActivity(myIntent);
        mUIDevice.waitForWindowUpdate(APP, 5 * 2000);

        try {
            //定位navigation button
            UiObject navigation = mUIDevice.findObject(new UiSelector().className("android.widget.ImageButton"));
            //点击按键
            navigation.click();

            //暂停2s
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //定位HK 9-Day Forecast组件
            UiScrollable localList = new UiScrollable(new UiSelector().className("android.widget.ListView"));
            UiObject hk9 = localList.getChildByText(new UiSelector().className("android.widget.TextView"), "HK 9-Day Forecast", true);
            hk9.click();
            Logger.i("点击HK 9-Day Forecast成功！");

            //分别定位9天的日期
            UiScrollable functionItems = null;
            functionItems = new UiScrollable(new UiSelector().className("android.widget.ListView"));

            //点击第1个LinearLayout上的日期
            String fc1 = convert2MonDay(1);
            Logger.i("fc1=" + fc1);
            UiObject foreCast1 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc1, true);
            foreCast1.click();
            Logger.i("点击" + fc1 + "成功！");

            //点击第2个LinearLayout上的日期
            String fc2 = convert2MonDay(2);
            UiObject foreCast2 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc2, true);
            foreCast2.click();
            Logger.i("点击" + fc2 + "成功！");

            //点击第3个LinearLayout上的日期
            String fc3 = convert2MonDay(3);
            UiObject foreCast3 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc3, true);
            foreCast3.click();
            Logger.i("点击 " + fc3 + " 成功！");

            //点击第4个LinearLayout上的日期
            String fc4 = convert2MonDay(4);
            UiObject foreCast4 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc4, true);
            foreCast4.click();
            Logger.i("点击" + fc4 + "成功！");

            //点击第5个LinearLayout上的日期
            String fc5 = convert2MonDay(5);
            UiObject foreCast5 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc5, true);
            foreCast5.click();
            Logger.i("点击" + fc5 + "成功！");

            //点击第6个LinearLayout上的日期
            String fc6 = convert2MonDay(6);
            UiObject foreCast6 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc6, true);
            foreCast6.click();
            Logger.i("点击" + fc6 + "成功！");

            //点击第7个LinearLayout上的日期
            String fc7 = convert2MonDay(7);
            UiObject foreCast7 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc7, true);
            foreCast7.click();
            Logger.i("点击" + fc7 + "成功！");

            //点击第8个LinearLayout上的日期
            String fc8 = convert2MonDay(8);
            UiObject foreCast8 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc8, true);
            foreCast8.click();

            //点击第9个LinearLayout上的日期
            String fc9 = convert2MonDay(9);
            UiObject foreCast9 = functionItems.getChildByText(new UiSelector().className("android.widget.TextView"), fc9, true);
            foreCast9.click();
            Logger.i("点击" + foreCast9 + "成功！");

        } catch (Exception e) {
            Logger.i("系统定位失败！");
            e.printStackTrace();
        }

    }

    //根据输入的偏移天数，计算日月格式的日期
    public static String convert2MonDay(int i) {

        String outMonDay = "";
        int month = 0;
        int day = 0;
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        switch (i) {
            case 0:
                month = now.get(Calendar.MONTH) + 1;
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 1:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 1);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 2:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 2);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 3:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 3);
                day = now.get(Calendar.DAY_OF_MONTH);
            case 4:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 4);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 5:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 5);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 6:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 6);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 7:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 7);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;
            case 8:
                month = now.get(Calendar.MONTH) + 1;
                now.add(Calendar.DAY_OF_MONTH, 8);
                day = now.get(Calendar.DAY_OF_MONTH);
                break;

        }
        Logger.i("month:" + month);
        Logger.i("day:" + day);
        outMonDay = day + " " + convert2Month(month);
        return outMonDay;
    }

    //转换成对应的月形式
    public static String convert2Month(int inMon) {
        String outMon = "";
        switch (inMon) {
            case 1:
                outMon = "Jan";
                break;
            case 2:
                outMon = "Feb";
                break;
            case 3:
                outMon = "Mar";
                break;
            case 4:
                outMon = "Apr";
                break;
            case 5:
                outMon = "May";
                break;
            case 6:
                outMon = "Jun";
                break;
            case 7:
                outMon = "Jul";
                break;
            case 8:
                outMon = "Aug";
                break;
            case 9:
                outMon = "Sep";
                break;
            case 10:
                outMon = "Oct";
                break;
            case 11:
                outMon = "Nov";
                break;
            case 12:
                outMon = "Dec";
                break;

        }
        return outMon;
    }
}