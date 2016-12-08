define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "../widgets/RegisterWidget",
    "dojo/_base/declare",
    "dojo/text!./templates/LoginView.html",
    //in template
    "dijit/form/TextBox",
    "dijit/layout/LayoutContainer",
    "dijit/layout/ContentPane"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, RegisterWidget, declare, template) {
    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,
        buildRendering : function () {
            this.inherited(arguments);
            this._initalizeLoginWidget();
        },

        _initalizeLoginWidget : function () {
            var registrationWidget = new RegisterWidget();
            registrationWidget.placeAt(this.registerWidget);
        }
    });
});
