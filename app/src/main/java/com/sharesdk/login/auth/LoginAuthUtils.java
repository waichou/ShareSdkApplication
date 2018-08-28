package com.sharesdk.login.auth;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by zhouwei on 2018/8/28.
 */

public class LoginAuthUtils{

    private PlatformActionListener platformActionListener;
    public LoginAuthUtils(PlatformActionListener platformActionListener){
        this.platformActionListener = platformActionListener;
    }

    public void loginAuth(String platformName,String account,boolean isGetUserInfo){
        Platform plat = ShareSDK.getPlatform(platformName);
        //客户端可用
        if (plat.isClientValid()) {
            plat.SSOSetting(false);//客户端可用情况下，采用SSO方式授权
        }
        //如果授权过，则移除相关缓存的信息
        if (plat.isAuthValid()) {
            plat.removeAccount(true);//切换用户时执行清除，即不保留上次登陆的信息
        }
        //
        plat.setPlatformActionListener(platformActionListener);

        if (isGetUserInfo){
            if (account == null || "".equals(account.trim()))
                plat.showUser(null);
            else
                plat.showUser(account);
        }else{
            plat.authorize();
        }
    }

}
