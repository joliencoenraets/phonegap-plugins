package org.me.movemephone;

import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import org.json.JSONArray;

/**
 * This plugin is able to reach the MainActivity and its methods and variables.
 * @author Jolien Coenraets
 */
public class MainActivityPlugin extends Plugin {

    /**
     * Executes the method.
     * @param action the action, should be load
     * @param data the data, the first argument should be the filename
     * @param callbackId the callbackId
     * @return
     */
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId) {
        Log.i("MainActivityPlugin", "Plugin Called");
        MainActivity activity = ((MainActivity) ctx);

        if (action.equals("trackingStarted")) {
            Log.d("MainActivityPlugin", "trackingStarted action started");
            activity.setTracking(true);
            return new PluginResult(PluginResult.Status.OK);
        } else if (action.equals("trackingStopped")) {
            Log.d("MainActivityPlugin", "trackingStopped action started");
            activity.setTracking(false);
            return new PluginResult(PluginResult.Status.OK);
        } else if (action.equals("zoomOut")) {
            Log.d("MainActivityPlugin", "zoomOut action started");
            activity.zoomOut();
            return new PluginResult(PluginResult.Status.OK);
        }
        Log.e("MainActivityPlugin", "Invalid action: " + action);
        return new PluginResult(PluginResult.Status.INVALID_ACTION);
    }
}
