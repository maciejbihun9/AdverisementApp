define(["dojo/_base/declare"], function(declare){

    var saveUserUrl = 'user/saveUser';

    //Simple model definition
    var RegisterWidgetModel = declare([],{
            getSaveUserUrl : function(){
                return saveUserUrl;
            }
        }
    );
    return new RegisterWidgetModel();
});