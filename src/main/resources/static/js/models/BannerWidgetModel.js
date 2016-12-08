define(["dojo/_base/declare"], function(declare){

    var saveUserClickUrl = 'ads/storeAdClick';

    //Simple model definition
    var BannerWidgetModel = declare([],{
            getSaveUserClickUrl : function(){
                return saveUserClickUrl;
            }
        }
    );
    return new BannerWidgetModel();
});