package org.apache.cordova.trtc;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.trtc.debug.Constant;
import org.apache.cordova.trtc.videocall.VideoCallingActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

/**
 * 视频会议插件
 */
public class TRTC extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            String paramStr = args.getString(0);
            JSONObject jsonObj = new JSONObject(paramStr);
            Intent intent=new Intent();
            intent.setClass(this.cordova.getActivity(), VideoCallingActivity.class);
            intent.putExtra(Constant.ROOM_ID, jsonObj.getString("ROOM_ID"));
            intent.putExtra(Constant.USER_ID, jsonObj.getString("USER_ID"));
            intent.putExtra(Constant.USER_SIG, jsonObj.getString("USER_SIG"));
            intent.putExtra(Constant.SDK_APP_ID, jsonObj.getString("SDK_APP_ID"));
            this.cordova.startActivityForResult(this, intent, 0);
            callbackContext.success("成功");
            return true;
        }
        callbackContext.error("失败");
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    }

}
