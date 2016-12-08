define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "dijit/registry",
    "dojo/on",
    "dojo/text!./templates/AdvertiserPageDetailsWidget.html",
    "../controllers/AdvertiserPageController",
    "../controllers/RestController",
    "dojo/dom",
    //in template
    "dijit/form/TextBox"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, registry, on, template, AdvertiserPageController, RestController, dom) {

    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,

        buildRendering : function(){
            this.inherited(arguments);
        },

        postCreate : function(){
            this._setupSubmitButtonClick();
        },

        _setupSubmitButtonClick : function () {
            var self = this;
            on(this.submitButton, "click", function () {
                AdvertiserPageController.saveAdvertiserPage(
                    {
                        pageUrl : self._getUserInput("pageUrlInput"),
                        budget : self._getUserInput("budgetInput"),
                        category : self._getUserInput("categoryInput"),
                        adWebSiteUrl : self._getUserInput("adUrlInput"),
                        priceForService : self._getUserInput("priceForOneClick")
                    })
            });
        },

        _getUserInput : function (inputId) {
            return dom.byId(inputId).value;
        }

    });

});
