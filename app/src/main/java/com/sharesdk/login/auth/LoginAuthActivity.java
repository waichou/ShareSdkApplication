package com.sharesdk.login.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sharesdk.application.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * 1.登陆的集成方式与分享方式可以是一致的，即：gradle方式
 * 2.plat.SSOSetting(false)  仅有“登陆授权”在java代码中才能使用 ，不能用于分享
 *   shareByAppClient true 仅有在分享的时候使用
 *
 */
public class LoginAuthActivity extends AppCompatActivity implements PlatformActionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);

        //自动判断是否已经QQ授权,如果已经授权，则提示“可直接登陆”，反之，需要“手动授权”！

//        Platform plat = ShareSDK.getPlatform(SinaWeibo.NAME);
//        if (plat.isAuthValid()){
//            String userId = plat.getDb().getUserId();
//            if (userId != null && !"".equals(userId)) {
//                Toast.makeText(this,"login...main..." , Toast.LENGTH_SHORT).show();
//            }
//        }

    }

    public void loginQQAuthClick(View view) {
        new LoginAuthUtils(this).loginAuth(QQ.NAME,null,true);
    }

    public void loginSinaAuthClick(View view) {
        new LoginAuthUtils(this).loginAuth(SinaWeibo.NAME,null,true);
    }

    public void loginWechatAuthClick(View view) {
        new LoginAuthUtils(this).loginAuth(Wechat.NAME,null,true);
    }

    public void removeQQAuthClick(View view) {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        platform.removeAccount(true);

        Platform plat = ShareSDK.getPlatform(SinaWeibo.NAME);
        String userId = plat.getDb().getUserId();
        Toast.makeText(this, "userId=" + userId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
        //-------------------
        StringBuffer userInfoBuffer = new StringBuffer();
        //遍历Map
        Iterator ite = hashMap.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry entry = (Map.Entry)ite.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"： "+value);

            userInfoBuffer.append(key+"： "+value + "\n");
        }
        System.out.println(platform.getName() + "_用户信息：" + userInfoBuffer.toString());
        //-----------------------

        StringBuffer platFormInfoBuffer = new StringBuffer();
        //用户资源都保存到res
        //通过打印res数据看看有哪些数据是你想要的
        if (action == Platform.ACTION_USER_INFOR) {
            PlatformDb platDB = platform.getDb();//获取数平台数据DB
            //通过DB获取各种数据
            platFormInfoBuffer.append("token=" +platDB.getToken() + "\n");
            platFormInfoBuffer.append("userGender=" + platDB.getUserGender() + "\n");
            platFormInfoBuffer.append("userIcon=" + platDB.getUserIcon() + "\n");
            platFormInfoBuffer.append("userId=" + platDB.getUserId() + "\n");
            platFormInfoBuffer.append("userName=" +platDB.getUserName() + "\n");
        }

        System.out.println(platform.getName() + "_平台信息：" + platFormInfoBuffer.toString());
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        System.out.println("onError ---->  登录失败" + throwable.toString());
        System.out.println("onError ---->  登录失败" + throwable.getStackTrace().toString());
        System.out.println("onError ---->  登录失败" + throwable.getMessage());
    }

    @Override
    public void onCancel(Platform platform, int i) {
        System.out.println("onError ---->  登录取消");
    }

}
