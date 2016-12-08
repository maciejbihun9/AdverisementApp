define(["dojo/_base/declare", "../models/AdvertiserPageModel", "./RestController"], function (declare, AdvertiserPageModel, RestController) {

    var savePageUrl = AdvertiserPageModel.getSaveAdvertiserPageUrl();

    var AdvertiserPageController = declare([], {
            saveAdvertiserPage : function(data){
                RestController.saveObject(savePageUrl, data);
            }
        }
    );
    return new AdvertiserPageController()
});