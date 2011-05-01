package org.me.movemephone;

import android.content.res.AssetManager;
import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This plugin loads a file and puts the output in a string, which is returned.
 * @author Jolien Coenraets
 */
public class AssetsFolderPlugin extends Plugin {

    /**
     * Executes the method.
     * @param action the action, should be load
     * @param data the data, the first argument should be the filename
     * @param callbackId the callbackId
     * @return
     */
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId) {
        Log.d("AssetsFolderPlugin", "Plugin Called");
        if (action.equals("loadLine")) {
            Log.d("AssetsFolderPlugin", "Action loadLine started");
            try {
                return loadLine(data.getString(0));
            } catch (JSONException ex) {
                Log.e("AssetsFolderPlugin", "JSONException " + ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION, "Wrong data.");
            }
        } else if (action.equals("loadFile")) {
            Log.d("AssetsFolderPlugin", "Action loadFile started");
            try {
                return loadFile(data.getString(0));
            } catch (JSONException ex) {
                Log.e("AssetsFolderPlugin", "JSONException " + ex);
                return new PluginResult(PluginResult.Status.JSON_EXCEPTION, "Wrong data.");
            }
        }
        Log.e("AssetsFolderPlugin", "Invalid action: " + action);
        return new PluginResult(PluginResult.Status.INVALID_ACTION);
    }

    public PluginResult loadLine(String filename) {
        AssetManager assets = ctx.getAssets();
        try {
            InputStream input = assets.open(filename);
            BufferedReader stream = new BufferedReader(new InputStreamReader(input));
            String text = stream.readLine();
            return new PluginResult(PluginResult.Status.OK, text);
        } catch (IOException ex) {
            Log.e("AssetsFolderPlugin", "IOException " + ex);
            return new PluginResult(PluginResult.Status.IO_EXCEPTION, "File " + filename + " not found.");
        }
    }

    public PluginResult loadFile(String filename) {
        AssetManager assets = ctx.getAssets();
        try {
            InputStream input = assets.open(filename);
            BufferedReader stream = new BufferedReader(new InputStreamReader(input));
            String result = "";
            String line = stream.readLine();
            while(line != null){
                result += line;
                line = stream.readLine();
            }
            return new PluginResult(PluginResult.Status.OK, result);
        } catch (IOException ex) {
            Log.e("AssetsFolderPlugin", "IOException " + ex);
            return new PluginResult(PluginResult.Status.IO_EXCEPTION, "File " + filename + " not found.");
        }
    }
}
