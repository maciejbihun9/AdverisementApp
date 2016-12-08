define(["dojo/_base/declare"], function(declare){

    var advertiserPageUrl = 'ads/storePage';

    //Simple model definition
    var AdvertiserPageModel = declare([],{
            getSaveAdvertiserPageUrl : function(){
                return advertiserPageUrl;
            }
        }
    );
    return new AdvertiserPageModel();
});