/**
 * Creates the GPSChecker plugin.
 * @constructor
 */
var GPSChecker = function(){

};

/**
 * Implements the check method. Calls the check function of the GPSCheckerPlugin
 * java method with the correct callback parameters.
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
GPSChecker.prototype.check = function(succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "GPSCheckerPlugin", "check", []);
};

/**
 * Registers the plugin to the phonegap framework.
 */
PhoneGap.addConstructor(function(){
    //register the javascript class
    PhoneGap.addPlugin("gpschecker", new GPSChecker());

    //register the java class
    PluginManager.addService("GPSCheckerPlugin","org.me.movemephone.GPSCheckerPlugin");
});



