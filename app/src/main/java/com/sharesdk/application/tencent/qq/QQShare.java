package com.sharesdk.application.tencent.qq;

import android.service.quicksettings.Tile;
import android.text.TextUtils;

import com.mob.MobSDK;
import com.sharesdk.application.utils.DemoUtils;

import java.io.File;
import java.io.FileNotFoundException;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by yjin on 2017/6/22.
 */

public class QQShare {
	private PlatformActionListener platformActionListener;

	public QQShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
		String[] pks = {"com.tencent.mobileqq","com.tencent.mobileqqi","com.tencent.qqlite","com.tencent.minihd.qq","com.tencent.tim"};
		DemoUtils.isValidClient(pks);
	}

	public void shareWebPager(String text,String title,String titleUrl){//qq
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setTitleUrl(titleUrl);
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public enum QqShareImageType{
		nativeImg,networkImg,arrayImg;
	}

	public void shareImage(String imagePath,QqShareImageType shareQQType) throws FileNotFoundException {//qq
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();

		if (shareQQType == QqShareImageType.nativeImg){
			if (new File(imagePath).exists()){
				shareParams.setImagePath(imagePath);
			}else{
				throw new FileNotFoundException("file not found!");
			}
		}
		else if(shareQQType == QqShareImageType.networkImg){
			shareParams.setImageUrl(imagePath);

		}else if (shareQQType == QqShareImageType.arrayImg){
			shareParams.setImageArray(randomPic());
		}
		platform.setPlatformActionListener(platformActionListener);
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.share(shareParams);
	}

	public String[] randomPic() {
		String urlSmall = "http://git.oschina.net/alexyu.yxj/MyTmpFiles/raw/master/kmk_pic_fld/small/";
		String[] pics = new String[]{
				"120.JPG",
				"127.JPG",
				"130.JPG",
				"18.JPG",
				"184.JPG",
				"22.JPG",
				"236.JPG",
				"237.JPG",
				"254.JPG",
				"255.JPG",
				"263.JPG",
				"265.JPG",
				"273.JPG",
				"37.JPG",
				"39.JPG",
				"IMG_2219.JPG",
				"IMG_2270.JPG",
				"IMG_2271.JPG",
				"IMG_2275.JPG",
				"107.JPG"
		};
		int index = 0;
		return new String[]{
				urlSmall + pics[index],
				urlSmall + pics[index + 1],
				urlSmall + pics[index + 2],
				urlSmall + pics[index + 3],
		};
	}

	public void shareMusic(String text,String title,String tilteUrl,String imagePath,boolean isNativeImage,String musicUrl){//qq
		Platform platform = ShareSDK.getPlatform(QQ.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);

		shareParams.setTitle(title);
		shareParams.setTitleUrl(tilteUrl);

		if (isNativeImage){
			shareParams.setImagePath(imagePath);
		}
		shareParams.setImageUrl(imagePath);
		shareParams.setMusicUrl(musicUrl);

		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}
}
