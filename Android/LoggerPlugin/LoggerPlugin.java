package org.me.movemephone;

import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This plugin logs messages to the Android logger class.
 * @author Jolien Coenraets
 */
public class LoggerPlugin extends Plugin {

    /**
     * Executes the method.
     * @param action the action, should be load
     * @param data the data, the first argument should be the tag,
     * the second argument should be the message
     * @param callbackId the callbackId
     * @return
     */
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId) {
        Log.d("LoggerPlugin", "Plugin Called");
        if (action.equals("error")) {
            Log.d("LoggerPlugin", "Action error started");
            try {
                Log.e(data.getString(0), data.getString(1));
                return new PluginResult(PluginResult.Status.OK);
            } catch (JSONException ex) {
                Logger.getLogger(LoggerPlugin.class.getName()).log(Level.SEVERE, null, ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION,"Error while reading arguments");
            }
        }else if (action.equals("warning")) {
            Log.d("LoggerPlugin", "Action warning started");
            try {
                Log.w(data.getString(0), data.getString(1));
                return new PluginResult(PluginResult.Status.OK);
            } catch (JSONException ex) {
                Logger.getLogger(LoggerPlugin.class.getName()).log(Level.SEVERE, null, ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION,"Error while reading arguments");
            }
        }else if (action.equals("verbose")) {
            Log.d("LoggerPlugin", "Action verbose started");
            try {
                Log.v(data.getString(0), data.getString(1));
                return new PluginResult(PluginResult.Status.OK);
            } catch (JSONException ex) {
                Logger.getLogger(LoggerPlugin.class.getName()).log(Level.SEVERE, null, ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION,"Error while reading arguments");
            }
        }else if (action.equals("debug")) {
            Log.d("LoggerPlugin", "Action debug started");
            try {
                Log.d(data.getString(0), data.getString(1));
                return new PluginResult(PluginResult.Status.OK);
            } catch (JSONException ex) {
                Logger.getLogger(LoggerPlugin.class.getName()).log(Level.SEVERE, null, ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION,"Error while reading arguments");
            }
        }else if (action.equals("info")) {
            Log.d("LoggerPlugin", "Action info started");
            try {
                Log.i(data.getString(0), data.getString(1));
                return new PluginResult(PluginResult.Status.OK);
            } catch (JSONException ex) {
                Logger.getLogger(LoggerPlugin.class.getName()).log(Level.SEVERE, null, ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION,"Error while reading arguments");
            }
        }
        Log.e("LoggerPlugin", "Invalid action: " + action);
        return new PluginResult(PluginResult.Status.INVALID_ACTION);
    }
}
