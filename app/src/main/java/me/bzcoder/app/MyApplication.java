package me.bzcoder.app;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import me.bzcoder.util.SharePreferencesUtils;

public class MyApplication extends Application {
    private static Context mContext;
    private static final String CITY_SERVICE_CITY_KEY = "CITY_SERVICE_CITY";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        ARouter.init(this);
    }

    /**
     * 选择城市SharePreferencesUtils
     *
     * @param city
     */
    public static void setCityServiceCity(String city) {
        SharePreferencesUtils.setString(mContext, CITY_SERVICE_CITY_KEY, city);
    }


    public static String getCityServiceCity() {
        return SharePreferencesUtils.getString(mContext, CITY_SERVICE_CITY_KEY, "HangZhou");
    }

}

