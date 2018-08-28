
---------------------------------------------------------------------------
1.登陆的集成方式与分享方式可以是一致的，即：gradle方式
2.plat.SSOSetting(false)  仅有“登陆授权”在java代码中才能使用 ，不能用于分享
  shareByAppClient true 仅有在分享的时候使用且定义在app-build.gradle中

3.可以实现第三方授权登陆并获取到用户信息，以及对授权的信息缓存起来[Mob对用户信息没有做缓存处理]
  -之后得到相关的userid | openid 做注册用户（与服务端交互）

4.自定义授权界面：http://bbs.mob.com/forum.php?mod=viewthread&tid=278&page=1&extra=#pid870
5.powered by ShareSDK怎么去掉？：http://bbs.mob.com/thread-114-1-1.html
---------------------------------------------------------------------------


08-28 11:47:41.500 4959-5322/login.share3 I/System.out: 用户信息：is_yellow_vip： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: msg：
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: vip： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: nickname： 你在哪儿
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: figureurl_qq_1： http://thirdqq.qlogo.cn/qqapp/1107202638/017CCB35793433586D17A435895BDCD2/40
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: constellation：
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: city： 长春
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: figureurl_1： http://qzapp.qlogo.cn/qzapp/1107202638/017CCB35793433586D17A435895BDCD2/50
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: gender： 男
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: province： 吉林
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: is_yellow_year_vip： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: year： 1991
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: yellow_vip_level： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: figureurl： http://qzapp.qlogo.cn/qzapp/1107202638/017CCB35793433586D17A435895BDCD2/30
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: figureurl_2： http://qzapp.qlogo.cn/qzapp/1107202638/017CCB35793433586D17A435895BDCD2/100
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: is_lost： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: figureurl_qq_2： http://thirdqq.qlogo.cn/qqapp/1107202638/017CCB35793433586D17A435895BDCD2/100
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: level： 0
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: ret： 0

08-28 11:47:41.500 4959-5322/login.share3 I/System.out: 平台信息：token=ADB1A0D6A5E49870DC2F2F79B4885435
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: userGender=m
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: userIcon=http://thirdqq.qlogo.cn/qqapp/1107202638/017CCB35793433586D17A435895BDCD2/100
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: userId=017CCB35793433586D17A435895BDCD2
08-28 11:47:41.500 4959-5322/login.share3 I/System.out: userName=你在哪儿
