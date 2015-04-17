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
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.analytics.social.UMPlatformData.UMedia;

public class UmengAnalyticsPlugin extends CordovaPlugin {
	private static Context mContext;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		mContext = this.cordova.getActivity();
	}

	@Override
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		if (action.equals("init")) {
			init();
		}
		if (action.equals("setDebugMode")) {
			boolean mode = data.getBoolean(0);
			setDebugMode(mode);
		}
		if (action.equals("onResume")) {
			onResume();
		}
		if (action.equals("onPause")) {
			onPause();
		}
		if (action.equals("KillProcess")) {
			killProcess();
		}
		callbackContext.success();
		return true;
	}

	void init() {
		MobclickAgent.openActivityDurationTrack(false);
		MobclickAgent.setAutoLocation(true);
		MobclickAgent.updateOnlineConfig(mContext);
	}

	void setDebugMode(boolean mode) {
		MobclickAgent.setDebugMode(mode);
	}

	void onResume() {
		super.onResume();
		MobclickAgent.onResume(mContext);
	}

	void onPause() {
		super.onPause();
		MobclickAgent.onPause(mContext);
	}

	void killProcess(){
    	MobclickAgent.onKillProcess(mContext);
    }
}