package me.bzcoder.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        // As early as possible, it is recommended to initialize in the Application
    }
}

