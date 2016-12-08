define([
    "dojo/dom",
    "dojo/_base/declare",
    "../views/AdvertisementDetailsPageView",
    "../widgets/AdvertiserPageDetailsWidget"
], function(Dom, Declare, AdvertisementDetailsPageView, AdvertiserPageDetailsWidget){

    var searchViewDomId = Dom.byId("add_page_layout");

    var advertiserPageDetailsWidget = new AdvertiserPageDetailsWidget();

    var adDetailsPageView = new AdvertisementDetailsPageView({"advertiserPageDetailsWidget" : advertiserPageDetailsWidget});

    var AddPageViewPresenter = Declare([], {

        initalizeAddPageView : function () {
            adDetailsPageView.placeAt(searchViewDomId);
        }

    });
    return new AddPageViewPresenter();
});
