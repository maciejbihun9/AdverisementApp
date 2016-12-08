define(["dojo/_base/declare", "../models/BannerWidgetModel", "./RestController"], function (declare, BannerWidgetModel, RestController) {

    var saveUserClickUrl = BannerWidgetModel.getSaveUserClickUrl();

    var BannerWidgetController = declare([], {
            saveUserClick : function(data){
                RestController.saveObject(saveUserClickUrl, data)
            }
        }
    );
    return new BannerWidgetController()
});