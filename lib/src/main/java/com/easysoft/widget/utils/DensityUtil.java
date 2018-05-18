package com.easysoft.widget.utils;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;

public class DensityUtil {
    public DensityUtil() {
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static float getdensity(Context context) {
        float scale = context.getResources().getDisplayMetrics().density;
        return scale;
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5F);
    }

    public static int getWindowWidth(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }

    public static int getWindowHeight(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }

    public static int dip2pxIntNonCompat(Context context, float dpValue) {
        try {
            Field field = DisplayMetrics.class.getField("noncompatDensity");
            float scale = field.getFloat(context.getResources().getDisplayMetrics());
            return (int)((double)(dpValue * scale) + 0.5D);
        } catch (Exception var4) {
            var4.printStackTrace();
            return -1;
        }
    }

    public static int getNonCompatDensityDpi(Context context) {
        try {
            Field field = DisplayMetrics.class.getField("noncompatDensityDpi");
            return field.getInt(context.getResources().getDisplayMetrics());
        } catch (Exception var2) {
            var2.printStackTrace();
            return -1;
        }
    }

    public static int dip2pxInt(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static boolean isPad(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService("window");
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        double x = Math.pow((double)((float)dm.widthPixels / dm.xdpi), 2.0D);
        double y = Math.pow((double)((float)dm.heightPixels / dm.ydpi), 2.0D);
        double screenInches = Math.sqrt(x + y);
        return screenInches >= 6.0D;
    }
}
