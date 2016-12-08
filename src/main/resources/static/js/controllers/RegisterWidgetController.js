define(["dojo/_base/declare", "../models/RegisterWidgetModel", "dojo/request"],
    function (declare, RegisterWidgetModel, request) {

    var saveUserUrl = RegisterWidgetModel.getSaveUserUrl();

    var RegisterWidgetController = declare([], {
            registerUser: function (username, password) {
                request.post(saveUserUrl, {

                    //DO NOT SEND VAR OBJETS VIA JSON.STRINGIFY.
                    data: JSON.stringify({username : username, password : password}),
                    handleAs: "json",
                    headers: {
                        "Content-Type": "application/json;charset=utf-8",
                        "Accept": "application/json"
                    }
                }).then(function(text){
                    alert("Could not saved user credentials : "+text);
                });
            }
        }
    );
    return new RegisterWidgetController()
});