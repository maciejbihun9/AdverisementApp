define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "dojo/text!./templates/AdvertisementDetailsPageView.html",
    "../widgets/AdvertiserPageDetailsWidget",
    //in template
    "dijit/layout/LayoutContainer",
    "dijit/layout/ContentPane",
    "dijit/form/Button"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, template, AdvertiserPageDetailsWidget) {
    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,
        advertiserPageDetailsWidget : null,
        buildRendering : function(){
            this.inherited(arguments);
            this._setupAdPageDetailsWidget();
        },

        _setupAdPageDetailsWidget : function(){
            var advertiserPageDetailsWidget = new AdvertiserPageDetailsWidget();
            advertiserPageDetailsWidget.placeAt(this.pageDetailsViewCenter);
        }



    });
});
