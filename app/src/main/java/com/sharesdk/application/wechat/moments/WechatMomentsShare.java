package com.sharesdk.application.wechat.moments;

import android.graphics.Bitmap;

import com.mob.MobSDK;
import com.sharesdk.application.utils.DemoUtils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by yjin on 2017/6/22.
 */

public class WechatMomentsShare {
	private PlatformActionListener platformActionListener;

	public WechatMomentsShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
		DemoUtils.isValidClient("com.tencent.mm");
	}

	public void shareText(String text,String title){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setShareType(Platform.SHARE_TEXT);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public enum WechatMomentsShareImageType{
		nativeImg,networkImg,arrayImg,imageData;
	}

	public void shareImage(String text,Object imageObj,WechatMomentsShareImageType type){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		if (type == WechatMomentsShareImageType.nativeImg){
			shareParams.setImagePath((String)imageObj);
		}else if (type == WechatMomentsShareImageType.networkImg){
			shareParams.setImageUrl((String)imageObj);
		}else if (type == WechatMomentsShareImageType.arrayImg){
			String[] arrImage = (String[]) imageObj;
			shareParams.setImageArray(arrImage);
		}else if (type == WechatMomentsShareImageType.imageData){//待续
			int resImgId = (int) imageObj;
			Bitmap bitmap = null;
			shareParams.setImageData(bitmap);

		}
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public enum WechatMomentsShareImage{
		nativeImg,netWorkUrl;
	}

	public void shareMusic(String text,String title,String imagePath,String musicUrl,WechatMomentsShareImage type){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);

		if (type == WechatMomentsShareImage.nativeImg){
			shareParams.setImagePath(imagePath);
		}
		shareParams.setImageUrl(imagePath);

		shareParams.setUrl(musicUrl);
//		shareParams.setMusicUrl(musicUrl);//不好使，打开页面之后提示找不到

		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareVideo(String text ,String title,String videoUrl,String imagePath){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setUrl(videoUrl);
		shareParams.setImagePath(imagePath);
		shareParams.setShareType(Platform.SHARE_VIDEO);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareWebpager(String text,String title,String url){
		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();

//		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());

		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setUrl(url);
//		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}
//
//	public void shareText(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
//		shareParams.setShareType(Platform.SHARE_TEXT);
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}
//
//	public void shareImage(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
//		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
//		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
//		shareParams.setShareType(Platform.SHARE_IMAGE);
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}
//
//	public void shareMusic(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
//		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
//		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
//		shareParams.setMusicUrl(ResourcesManager.getInstace(MobSDK.getContext()).getMusicUrl());
//		shareParams.setShareType(Platform.SHARE_MUSIC);
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}
//
//	public void shareVideo(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
//		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
//		shareParams.setShareType(Platform.SHARE_VIDEO);
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}
//
//	public void shareWebpager(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
//		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
//		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
//		shareParams.setShareType(Platform.SHARE_WEBPAGE);
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}
}
