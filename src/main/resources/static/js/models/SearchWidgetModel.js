define(["dojo/_base/declare"], function(declare){

    var processUserInputWordsUrl = 'user/processUserInput';

    //Simple model definition
    var SearchWidgetModel = declare([],{

            getProcessInputWordsUrl : function () {
                return processUserInputWordsUrl;
            }

        }
    );
    return new SearchWidgetModel();

});