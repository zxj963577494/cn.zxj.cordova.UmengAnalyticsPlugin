package cn.zxj.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ionicframework.fang323888.R;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;

public class UmengAnalyticsPlugin extends CordovaPlugin {
	private Context mContext;
	@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    	super.initialize(cordova, webView);
    	mContext = this;
   }

    @Override
	public boolean execute(String action, JSONArray data,CallbackContext callbackContext) throws JSONException {
	Activity activity = this.cordova.getActivity();
        if (action.equals("init")){
           init();
    	}
		if(action.equals("onResume")){
           onResume();
        }
        if(action.equals("onPause")){
           onPause();
        }
	    callbackContext.success();
        return true;
	}

	void init() {
		AnalyticsConfig.setAppkey("552dbe4afd98c5b99700130e");
        AnalyticsConfig.setChannel("fangshijie");
        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setAutoLocation(true);
        MobclickAgent.setSessionContinueMillis(1000);
	}

	void onResume() {
		super.onResume();
		MobclickAgent.onResume(mContext);
	}

	void onPause() {
		super.onPause();
		MobclickAgent.onPause(mContext);
	}
}