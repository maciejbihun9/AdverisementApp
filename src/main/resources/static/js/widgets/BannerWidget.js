define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "../controllers/BannerWidgetController",
    "dojo/on",
    "dojo/text!./templates/BannerWidget.html"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, BannerWidgetController, on, template) {
    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,
        bannerWidth : "70%",
        bannerHeight : "70%",
        photoUrl: "photoUrl",
        pageId : "pageId",

        buildRendering : function(){
            this.inherited(arguments);
            this._setupClickListeners();
        },

        _setupClickListeners : function(){
            var self = this;
            on(this.adImg, "click", function(){
                BannerWidgetController.saveUserClick(self.pageId);
                console.log("clicking works!!!");
            });
        }
    });
});
