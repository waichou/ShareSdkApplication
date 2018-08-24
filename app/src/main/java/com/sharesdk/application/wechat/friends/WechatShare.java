package com.sharesdk.application.wechat.friends;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mob.MobSDK;
import com.sharesdk.application.utils.DemoUtils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * Created by yjin on 2017/6/22.
 */

public class WechatShare {

	private PlatformActionListener platformActionListener;

	public WechatShare(PlatformActionListener mListener){
		this.platformActionListener = mListener;
		DemoUtils.isValidClient("com.tencent.mm");
	}

	public void shareText(String text,String title){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setShareType(Platform.SHARE_TEXT);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public enum WechatShareImageType{
		nativeImg,networkImg,arrayImg,imageData;
	}

	public void shareImage(String text,Object imageObj,WechatShare.WechatShareImageType type){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		if (type == WechatShare.WechatShareImageType.nativeImg){
			shareParams.setImagePath((String)imageObj);
		}else if (type == WechatShare.WechatShareImageType.networkImg){
			shareParams.setImageUrl((String)imageObj);
		}else if (type == WechatShare.WechatShareImageType.arrayImg){
			String[] arrImage = (String[]) imageObj;
			shareParams.setImageArray(arrImage);
		}else if (type == WechatShare.WechatShareImageType.imageData){//待续
			int resImgId = (int) imageObj;
			Bitmap bitmap = null;
			shareParams.setImageData(bitmap);

		}
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public enum WechatShareImage{
		nativeImg,netWorkUrl;
	}

	public void shareMusic(String text,String title,String imagePath,String musicUrl,WechatShare.WechatShareImage type){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(text);
		shareParams.setTitle(title);

		if (type == WechatShare.WechatShareImage.nativeImg){
			shareParams.setImagePath(imagePath);
		}
		shareParams.setImageUrl(imagePath);

		shareParams.setUrl(musicUrl);
//		shareParams.setMusicUrl(musicUrl);

		shareParams.setShareType(Platform.SHARE_MUSIC);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareVideo(String text ,String title,String videoUrl,String imagePath){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
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
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
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
     //------------------------------------------------
	public enum WechatShareFile{
		nativeFile,resNativeFile;
	 }

	public void shareFile(Context context,String text, String title, Object imageObj, WechatShareFile type){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setFilePath(ResourcesManager.getInstace(MobSDK.getContext()).getFilePath());
		shareParams.setText(text);
		shareParams.setTitle(title);
		shareParams.setShareType(Platform.SHARE_FILE);
		if (type == WechatShareFile.nativeFile){
			shareParams.setImagePath((String) imageObj);
		}else{
			int resImgId = (int) imageObj;
			Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),resImgId);
			shareParams.setImageData(bitmap);
		}
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareEmoji(Context context,int resImgId){
		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();

		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),resImgId);
		shareParams.setImageData(bitmap);
		shareParams.setImageData(bitmap);

		shareParams.setShareType(Platform.SHARE_EMOJI);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

//	public void shareMiniProgram(String text,String title,String url,){
//		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setText(ResourcesManager.getInstace(MobSDK.getContext()).getText());
//		shareParams.setTitle(ResourcesManager.getInstace(MobSDK.getContext()).getTitle());
//		shareParams.setUrl(ResourcesManager.getInstace(MobSDK.getContext()).getUrl());
//		shareParams.setImagePath(ResourcesManager.getInstace(MobSDK.getContext()).getImagePath());
//		shareParams.setImageData(ResourcesManager.getInstace(MobSDK.getContext()).getImageBmp());
//		shareParams.setImageUrl(ResourcesManager.getInstace(MobSDK.getContext()).getImageUrl());
//		shareParams.setShareType(Platform.SHARE_WXMINIPROGRAM);
//		platform.setPlatformActionListener(platformActionListener);
//		platform.share(shareParams);
//	}

}
