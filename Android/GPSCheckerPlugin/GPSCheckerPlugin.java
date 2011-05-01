
package org.me.movemephone;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import org.json.JSONArray;

/**
 * Plugin to check the status of the GPS.
 * @author Jolien Coenraets
 */
public class GPSCheckerPlugin extends Plugin{

    /**
     * Checks the status of the GPS. Is it off or is it on?
     * @param action the action, should be "check"
     * @param data arguments (none, can be empty)
     * @param callbackId 
     * @return
     */
    @Override
    public PluginResult execute(String action, JSONArray data, String callbackId) {
        final LocationManager manager = (LocationManager) ctx.getSystemService( Context.LOCATION_SERVICE );
        Log.d("GPSCheckerPlugin", "Plugin Called");
        if(action.equals("check")){
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Log.d("GPSCheckerPlugin", "GPS is off");
                return new PluginResult(PluginResult.Status.ERROR);
            }else{
                Log.d("GPSCheckerPlugin", "GPS is on");
                return new PluginResult(PluginResult.Status.OK);
            }
        }else{
            Log.d("GPSCheckerPlugin", "Invalid action: "+action);
            return new PluginResult(PluginResult.Status.INVALID_ACTION);
        }
    }

}
