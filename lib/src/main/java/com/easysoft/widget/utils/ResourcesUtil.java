package com.easysoft.widget.utils;

/**
 * Created by lindanghong on 2018/5/18.
 */


import android.content.Context;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {
    public ResourcesUtil() {
    }

    public static float getResourcesFloat(Context context, int id) {
        return Float.parseFloat(context.getResources().getString(id));
    }

    public static String getResourcesString(Context context, int id) {
        return context.getResources().getString(id);
    }

    public static int getResourcesColor(Context context, int id) {
        return context.getResources().getColor(id);
    }

    public static float getResourcesDimen(Context context, int id) {
        return context.getResources().getDimension(id);
    }

    public static Drawable getResourcesDrawable(Context context, int id) {
        return context.getResources().getDrawable(id);
    }
}
