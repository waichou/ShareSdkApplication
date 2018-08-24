package com.sharesdk.application;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sharesdk.application.sina.WeiboShare;
import com.sharesdk.application.wechat.friends.WechatShare;

import java.io.FileNotFoundException;
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

/**
 * Mob官网之hareSDK Maven集成文档
 * 链接地址：http://wiki.mob.com/sdk-share-android-3-0-0/
 *
 * Mob控制台-创建应用：
 * 链接地址：http://dashboard.mob.com/#!/dashboard
 *
 * 开发资料Download：
 * 链接地址：http://www.mob.com/download
 *
 * 各个平台相关配置参数
 * http://wiki.mob.com/%E4%B8%8D%E5%90%8C%E5%B9%B3%E5%8F%B0%E5%88%86%E4%BA%AB%E5%86%85%E5%AE%B9%E7%9A%84%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E/
 *
 * 官方Demo:
 * https://github.com/MobClub/ShareSDK-for-Android
 *
 * 关于新浪分享有个问题：
 * 1.如果启用SSO方式授权
 * 2.授权如果能再次提供切换账号的能力
 */
public class SinaActivity extends AppCompatActivity implements PlatformActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_sina);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }


    public void shareSinaForImgClick(View view) {
        try {
            new WeiboShare(this).shareImage("text123",Environment.getExternalStorageDirectory()+"/123.png",null,0,0, WeiboShare.WeiboShareImageType.nativeImg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void shareSinaForTextClick(View view) {
        new WeiboShare(this).shareText("text123 helle zw");
    }

    public void shareSinaForVideoClick(View view) {
//        new WeiboShare(this).shareVideo("text123","https://www.vmovier.com/54681?from=index_new_title",true);
        new WeiboShare(this).shareVideo("text123",Environment.getExternalStorageDirectory()+"/123.mp4",true);
    }
}