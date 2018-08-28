package com.sharesdk.application.main;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sharesdk.application.R;
import com.sharesdk.application.wechat.friends.WechatShare;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
 */
public class WechatActivity extends AppCompatActivity implements PlatformActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_webchat);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Toast.makeText(this, "分享成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Toast.makeText(this, "分享失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Toast.makeText(this, "分享取消！", Toast.LENGTH_SHORT).show();
    }

    public void shareWechatForImgClick(View view) {

        //###
        new WechatShare(this).shareImage("分享text","https://www.baidu.com/img/bd_logo1.png?where=super", WechatShare.WechatShareImageType.networkImg);
//        new WechatShare(this).shareImage("分享text",Environment.getExternalStorageDirectory() + "/123.png", WechatShare.WechatShareImageType.nativeImg);
        //###
    }

    public void shareWechatForTextClick(View view) {
        //分享文本到朋友圈（ok）
        new WechatShare(this).shareText("分享的文本123","分享的title");

        //分享给朋友（ok）
        //new WechatShare(this).shareText("分享文本123","分享title123");
    }


    public void shareWechatForWebPageClick(View view) {
        new WechatShare(this).shareWebpager("分享text","分享title","https://www.baidu.com/");
    }

    public void shareWechatForMusicClick(View view) {
        new WechatShare(this).shareMusic("text123","title123","https://www.baidu.com/img/bd_logo1.png?where=super","http://www.ytmp3.cn/down/51603.mp3", WechatShare.WechatShareImage.netWorkUrl);
    }

    public void shareWechatForVideoClick(View view) {
        new WechatShare(this).shareVideo("text123","title123","https://www.vmovier.com/54681?from=index_new_title",Environment.getExternalStorageDirectory()+"/123.png");
    }
}