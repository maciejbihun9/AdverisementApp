define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "dojo/text!./templates/SearchView.html",
    "../widgets/SearchWidget",
    "../widgets/BannerWidget",

    //in template
    "dijit/layout/LayoutContainer",
    "dijit/layout/ContentPane",
    "dijit/form/Button"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, template, SearchWidget, BannerWidget) {
    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,
        searchViewTop: "searchViewTop",
        buildRendering : function () {
            this.inherited(arguments);
            this._setupSearchWidget();
            this._setupLeftSideAds();
            this._setupRightSideAds();
            this._setupBottomAds();
        },

        _setupLeftSideAds : function(){
            var left1Banner = new BannerWidget();
            left1Banner.placeAt(this.left1Banner);
            var left2Banner = new BannerWidget();
            left2Banner.placeAt(this.left2Banner);
            var left3Banner = new BannerWidget();
            left3Banner.placeAt(this.left3Banner);
        },

        _setupRightSideAds : function(){
            var left4Banner = new BannerWidget();
            left4Banner.placeAt(this.left4Banner);
            var left5Banner = new BannerWidget();
            left5Banner.placeAt(this.left5Banner);
            var left6Banner = new BannerWidget();
            left6Banner.placeAt(this.left6Banner);
        },

        _setupBottomAds : function(){
            var bottomBanner = new BannerWidget({bannerWidth: "100%", bannerHeight : "100%"});
            bottomBanner.placeAt(this.bottomBanner);
        },

        _setupSearchWidget : function(){
            var searchWidget = new SearchWidget();
            searchWidget.placeAt(this.searchBarContainer);
        },

        displayTopAd : function(newAd){
            newAd.placeAt(this.searchViewTop);
        }
    });
});
