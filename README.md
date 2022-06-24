# cordova-plugin-ck-trtc
插件名：腾讯TRTC Cordova插件
作者：ck
描述：集成腾讯TRTC SDK实现视频会议

使用:
1、安装插件，将插件保存到本机电脑某位置
cordova plugin add D:/development_tools/cordova-plugin-ck-trtc

2、打开"platform\android\app\src\AndroidManifest.xml",在<application></application>标签中申明插件用到的三个activity
        <activity android:name="org.apache.cordova.trtc.basic.TRTCBaseActivity" />
        <activity android:name="org.apache.cordova.trtc.videocall.VideoCallingActivity" android:theme="@style/Theme.AppCompat.NoActionBar"/>
 
 3、由于插件包位置并不是在包内，插件中的R.java文件不会默认引入导致报错， 需要在 "TRTCBaseActivity.java"、"VideoCallingActivity.java"文件中手动修改引包的代码"import com.shanon.manage.lvchun.R;"其中"com.shanon.manage.lvchun"就是你所在项目的包名

4、若其它插件中添加有<uses-feature android:name="android.hardware.camera" />则将本插件xml中的注释，没有则放开注释

5、使用方法：
    TRTC.init({'USER_ID':'张三','ROOM_ID':'123456','USER_SIG':'123456','SDK_APP_ID':'123456'}, (res) => {
      console.info('成功', res);
      }, (err) => {
          console.info('失败', err);
    });
