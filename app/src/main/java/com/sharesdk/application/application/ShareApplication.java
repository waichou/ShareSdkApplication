package com.sharesdk.application.application;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by zhouwei on 2018/8/23.
 */

public class ShareApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
    }
}
