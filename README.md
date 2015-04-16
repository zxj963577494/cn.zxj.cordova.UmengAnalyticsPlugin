简介
===================================
    本插件使用友盟统计，简单实现了友盟统计的基本功能，如启动次数等，暂不包含页面统计等。
    本插件目前应该只支持Android，IOS系统匹配尚未完成（因为暂时用不到，大家可以对照友盟文档试一下）。

使用说明
===================================
### 1.切换目录
运行命令行，切换到你想保存的插件的目录，在这里将插件保存至使用D:\plugins目录下
```
    cd D:\plugins
```
### 2.下载插件
```
    git clone https://github.com/zxj963577494/cn.zxj.cordova.UmengAnalyticsPlugin.git
```
### 3.配置AppKey和Channel
打开插件目录下的plugin.xml文件
```
    <meta-data android:name="UMENG_CHANNEL" android:value="YOUR_CHANNEL"/>
    <meta-data android:name="UMENG_APPKEY" android:value="YOUR_APP_KEY"/>
```
    YOUR_CHANNEL：填写渠道名称，如360、wodajia、QQ等，可以自定义渠道，在统计后台可以看到渠道信息
    YOUR_APP_KEY：填写从友盟获取的APPKey

### 4.安装插件
使用命令行，切换至ionic所在目录，安装插件
```
ionic plugin add D:\plugins\cn.zxj.cordova.UmengAnalyticsPlugin
```

### 5.配置代码
在app.js文件中添加插件所需的代码
```
    .run(['$ionicPlatform', function ($ionicPlatform) {
            $ionicPlatform.ready(function () {
                if (window.cordova && window.cordova.plugins.Keyboard) {
                    cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
                }
                if (window.StatusBar) {
                    // org.apache.cordova.statusbar required
                    StatusBar.styleDefault();
                }

                //初始化友盟统计配置
                window.plugins.umengAnalyticsPlugin.init();
    			//调试模式
                window.plugins.umengAnalyticsPlugin.setDebugMode(true);

    			//必需
                document.addEventListener("pause", onPause, false);
    			//必需
                document.addEventListener("resume", onResume, false);
            });

    		//必需
            function onPause() {
                window.plugins.umengAnalyticsPlugin.onPause();
            }

    		//必需
            function onResume() {
                window.plugins.umengAnalyticsPlugin.onResume();
            }
        }])
```
### 参考资料
[友盟开发文档](http://dev.umeng.com/)
