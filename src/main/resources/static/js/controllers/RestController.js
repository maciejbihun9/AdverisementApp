define(["dojo/_base/declare", "dojo/request"],
    function (declare, request) {

        var RestController = declare([], {
            //data should be valid json object
                saveObject: function (endpoint, data) {
                    request.post(endpoint, {

                        //DO NOT SEND VAR OBJETS VIA JSON.STRINGIFY.
                        data: JSON.stringify(data),
                        handleAs: "json",
                        headers: {
                            "Content-Type": "application/json;charset=utf-8",
                            "Accept": "application/json"
                        }
                    }).then(function(text){
                        alert("Could not save data " + text);
                    });
                }
            }
        );
        return new RestController()
    });