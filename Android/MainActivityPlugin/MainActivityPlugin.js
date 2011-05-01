/**
 * Creates the MenuPlugin plugin.
 * @constructor
 */
var MainActivityPlugin = function(){

};

/**
 * Changes the button in the menu to "Start tracking".
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
MainActivityPlugin.prototype.trackingStarted = function(succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "MainActivityPlugin", "trackingStarted", [null]);
};

/**
 * Changes the button in the menu to "Stop tracking".
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
MainActivityPlugin.prototype.trackingStopped = function(succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "MainActivityPlugin", "trackingStopped", [null]);
};

/**
 * Zoom out.
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
MainActivityPlugin.prototype.zoomOut = function(succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "MainActivityPlugin", "zoomOut", [null]);
};

/**
 * Registers the plugin to the phonegap framework.
 */
PhoneGap.addConstructor(function(){
    //register the javascript class
    PhoneGap.addPlugin("mainactivity", new MainActivityPlugin());

    //register the java class
    PluginManager.addService("MainActivityPlugin","org.me.movemephone.MainActivityPlugin");
});



