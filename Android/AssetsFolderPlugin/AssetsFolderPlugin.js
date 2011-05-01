/**
 * Creates the AssetsFolderPlugin plugin.
 * @constructor
 */
var AssetsFolderPlugin = function(){

};

/**
 * Loads a file in the assets folder.
 * @param {String} file the location of the file, relative to the assets folder
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
AssetsFolderPlugin.prototype.loadLine = function(file, succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "AssetsFolderPlugin", "loadLine", [file]);
};

/**
 * Loads a file in the assets folder.
 * @param {String} file the location of the file, relative to the assets folder
 * @param {function} succesCallback the callback function in case of success
 * @param {function} failureCallback the callback function in case of failure
 * @return phonegap executes the method and does the callback
 */
AssetsFolderPlugin.prototype.loadFile = function(file, succesCallback, failureCallback){
    return PhoneGap.exec(succesCallback, failureCallback, "AssetsFolderPlugin", "loadFile", [file]);
};

/**
 * Registers the plugin to the phonegap framework.
 */
PhoneGap.addConstructor(function(){

    //register the javascript class
    PhoneGap.addPlugin("assetsfolder", new AssetsFolderPlugin());

    //register the java class
    PluginManager.addService("AssetsFolderPlugin","org.me.movemephone.AssetsFolderPlugin");
});



