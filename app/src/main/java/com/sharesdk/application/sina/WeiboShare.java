package com.sharesdk.application.sina;

import com.mob.MobSDK;
import com.sharesdk.application.tencent.qq.QQShare;
import com.sharesdk.application.utils.DemoUtils;

import java.io.File;
import java.io.FileNotFoundException;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;

/**
 * Created by yjin on 2017/6/22.
 */

public class WeiboShare {
	private PlatformActionListener platformActionListener;

	public WeiboShare(PlatformActionListener mListener) {
		this.platformActionListener = mListener;
	}

	public void shareText(String text) {
		Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
		Platform.ShareParams shareParams = new Platform.ShareParams();
		shareParams.setText(text);
		if (!DemoUtils.isValidClientSina("com.sina.weibo")) {
			shareParams.setUrl("http://www.mob.com");
		}
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}


	public enum WeiboShareImageType{
		nativeImg,networkImg,arrayImg,imageData;
	}

	public void shareImage(String text,String imagePath,String[] imagePaths,float latitude,float longitude,WeiboShareImageType type) throws FileNotFoundException {
		Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);

		if (type == WeiboShareImageType.nativeImg){
			if (new File(imagePath).exists()){
				shareParams.setImagePath(imagePath);
			}else{
				throw new FileNotFoundException("file not found!");
			}
		}
		else if(type == WeiboShareImageType.networkImg){
			shareParams.setImageUrl(imagePath);

		}else if (type == WeiboShareImageType.arrayImg){
			shareParams.setImageArray(imagePaths);
		}

		if(!DemoUtils.isValidClientSina("com.sina.weibo")){
			shareParams.setUrl("http://www.mob.com");
		}
		shareParams.setShareType(Platform.SHARE_IMAGE);
		shareParams.setLongitude(longitude);
		shareParams.setLatitude(latitude);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareVideo(String text,String imagePath,boolean isNativePath){
		Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();

		if (isNativePath){
			shareParams.setFilePath(imagePath);
		}
		shareParams.setImageUrl(imagePath);
		shareParams.setText(text);

		shareParams.setShareType(Platform.SHARE_VIDEO);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

}
