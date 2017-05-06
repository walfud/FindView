package com.walfud.dustofappearance;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by walfud on 2017/3/17.
 */

public class DustOfAppearance {

    public static void inject(Activity activity) {
        inject(activity, activity.getWindow().getDecorView());
    }

    public static <T> void inject(T target, View source) {
        try {
            Class clazz = Class.forName(target.getClass().getCanonicalName() + "$$" + Constants.CLASS_NAME);
            Constructor constructor = clazz.getConstructor(Class.forName(target.getClass().getCanonicalName()));
            Object obj = constructor.newInstance(target);

            // Find View
            Method find = clazz.getMethod(Constants.METHOD_FIND_VIEW, View.class);
            find.invoke(obj, source);

            // Set OnClick Listener
            Method setOnClickListener = clazz.getMethod(Constants.METHOD_SET_ON_CLICK_LISTENER, View.class);
            setOnClickListener.invoke(obj, source);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
