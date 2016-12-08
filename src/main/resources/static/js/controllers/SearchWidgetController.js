define(["dojo/_base/declare", "../models/SearchWidgetModel", "./RestController"], function (declare, SearchWidgetModel, RestController) {

    var processInputWordsUrl = SearchWidgetModel.getProcessInputWordsUrl();

    var SearchWidgetController = declare([], {
            saveUserInput : function(data){
                RestController.saveObject(processInputWordsUrl, data)
            }
        }
    );
    return new SearchWidgetController()
});