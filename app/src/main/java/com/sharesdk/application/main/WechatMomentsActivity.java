package com.sharesdk.application.main;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sharesdk.application.R;
import com.sharesdk.application.tencent.qq.QQShare;
import com.sharesdk.application.wechat.friends.WechatShare;
import com.sharesdk.application.wechat.moments.WechatMomentsShare;

import java.io.FileNotFoundException;
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
 */
public class WechatMomentsActivity extends AppCompatActivity implements PlatformActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_webchat_moments);
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

    public void shareWechatMomentsForImgClick(View view) {
        //###
//        new WechatMomentsShare(this).shareImage("分享text","https://www.baidu.com/img/bd_logo1.png?where=super", WechatMomentsShare.WechatMomentsShareImageType.networkImg);
        new WechatMomentsShare(this).shareImage("分享text",Environment.getExternalStorageDirectory() + "/123.png", WechatMomentsShare.WechatMomentsShareImageType.nativeImg);
        //###
    }

    public void shareWechatMomentsForTextClick(View view) {
        //分享文本到朋友圈（ok）
        new WechatMomentsShare(this).shareText("分享的文本123","分享的title");
    }


    public void shareWechatMomentsForWebPageClick(View view) {
        new WechatMomentsShare(this).shareWebpager("分享text","分享title","https://www.baidu.com/");
    }

    public void shareWechatMomentsForMusicClick(View view) {
        new WechatMomentsShare(this).shareMusic("text123","title123","https://www.baidu.com/img/bd_logo1.png?where=super","http://www.ytmp3.cn/down/51603.mp3", WechatMomentsShare.WechatMomentsShareImage.netWorkUrl);
    }

    public void shareWechatMomentsForVideoClick(View view) {
        new WechatMomentsShare(this).shareVideo("text123","title123","https://www.vmovier.com/54681?from=index_new_title",Environment.getExternalStorageDirectory()+"/123.png");
    }
}