package cn.zxj.cordova;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.AnalyticsConfig
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;

public class UmengAnalyticsPlugin extends CordovaPlugin {
    private static Context mContext;

	@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    	super.initialize(cordova, webView);
mContext=this.cordova.getActivity();
    }

    @Override
	public boolean execute(String action, JSONArray data,CallbackContext callbackContext) throws 
JSONException {
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
        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setAutoLocation(true);
        MobclickAgent.setSessionContinueMillis(1000);
	}

	void onResume() {
		MobclickAgent.onResume(mContext);
	}

	void onPause() {
		MobclickAgent.onPause(mContext);
	}
}