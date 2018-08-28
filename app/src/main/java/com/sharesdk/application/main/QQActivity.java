package com.sharesdk.application.main;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sharesdk.application.R;
import com.sharesdk.application.tencent.qq.QQShare;

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
public class QQActivity extends AppCompatActivity implements PlatformActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shareClick(View view) {
        showShare();
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
//        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.app_name));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }


    private void shareQQ(){
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Toast.makeText(this, "success!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Toast.makeText(this, "cancel!", Toast.LENGTH_SHORT).show();
    }

    public void shareQQForImageClick(View view) {

        try {
            new QQShare(this).shareImage("https://www.baidu.com/img/bd_logo1.png?where=super", QQShare.QqShareImageType.networkImg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void shareQQForWebPageClick(View view) {
        new QQShare(this).shareWebPager("分享的内容121","标题123232","https://www.baidu.com/");
    }

    public void shareQQForMusicClick(View view) {
        //注意：musicUrl 这个参数不好使！！！！
        new QQShare(this).shareMusic("text123","title123","http://www.ytmp3.cn/down/51603.mp3",Environment.getExternalStorageDirectory()+"/123.png",false, "http://www.ytmp3.cn/down/51603.mp3");
    }
}
