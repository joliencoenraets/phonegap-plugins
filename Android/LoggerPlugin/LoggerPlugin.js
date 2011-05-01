/**
 * Creates the LoggerPlugin plugin.
 * @constructor
 */
var LoggerPlugin = function(){

};

/**
 * Logs an error message.
 * @param {string} tag The tag of the message
 * @param {string} message The message to log
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
LoggerPlugin.prototype.logError = function(tag, message, succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "LoggerPlugin", "error", [tag,message]);
};

/**
 * Logs an info message.
 * @param {string} tag The tag of the message
 * @param {string} message The message to log
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
LoggerPlugin.prototype.logInfo = function(tag, message,succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "LoggerPlugin", "info", [tag,message]);
};

/**
 * Logs a warning message.
 * @param {string} tag The tag of the message
 * @param {string} message The message to log
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
LoggerPlugin.prototype.logWarning = function(tag, message,succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "LoggerPlugin", "warning", [tag,message]);
};

/**
 * Logs a verbose message.
 * @param {string} tag The tag of the message
 * @param {string} message The message to log
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
LoggerPlugin.prototype.logVerbose = function(tag, message,succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "LoggerPlugin", "verbose", [tag,message]);
};

/**
 * Logs a debug message.
 * @param {string} tag The tag of the message
 * @param {string} message The message to log
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
LoggerPlugin.prototype.logDebug = function(tag, message,succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "LoggerPlugin", "debug", [tag,message]);
};

/**
 * Registers the plugin to the phonegap framework.
 */
PhoneGap.addConstructor(function(){
    //register the javascript class
    PhoneGap.addPlugin("logger", new LoggerPlugin());

    //register the java class
    PluginManager.addService("LoggerPlugin","org.me.movemephone.LoggerPlugin");
});



