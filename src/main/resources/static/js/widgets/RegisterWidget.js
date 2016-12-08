define([
    "dojo/_base/declare",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetBase",
    "dijit/registry",
    "dojo/on",
    "dijit/_WidgetsInTemplateMixin",
    "../controllers/RegisterWidgetController",
    "dojo/text!./templates/RegisterWidget.html",

    //in template
    "dijit/form/TextBox"

], function (declare, _TemplatedMixin, _WidgetBase, registry, on,  _WidgetsInTemplateMixin, RegisterWidgetController, template) {

    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,

        buildRendering : function () {
            this.inherited(arguments);
            this._setupOnClick();
        },

        _setupOnClick : function(){
            var self = this;
            on(this.registerButton, "click", function () {
                RegisterWidgetController.registerUser(self._getUserLogin(), self._getUserPassword());
            });
        },

        _getUserLogin : function () {
            return registry.byId("username").get("value");
        },

        _getUserPassword : function () {
            return registry.byId("password").get("value");
        }

    });
});
