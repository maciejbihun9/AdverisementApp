define([
        "dojo/dom",
        "dojo/_base/declare",
        "../widgets/SearchWidget",
        "../views/SearchView",
        "dijit/_WidgetBase",
        "dijit/_TemplatedMixin"
    ], function(Dom, Declare, SearchWidget, SearchView, _WidgetBase, _TemplatedMixin){

        var searchViewDomId = Dom.byId("main_layout");

        var searchWidget = new SearchWidget();

        var searchView = new SearchView({"searchWidget" : searchWidget});

        var SearchViewController = Declare([_WidgetBase, _TemplatedMixin], {
            buildRendering : function(){
                searchView.placeAt(searchViewDomId);
            },
            displayTopAd : function(newAd){
                searchView.displayTopAd(newAd);
            }
        });
        return new SearchViewController();
    });
