define([ "dojo/dom",
        "dojo/dom-construct",
        "./views/AdvertisementDetailsPageView",
        "./views/SearchView",
        "./views/LoginView",
        "./views/MainPageLayoutView",
        "./router"],
    function(dom, domConstruct, AdvertisementDetailsPageView, SearchView, LoginView, MainPageLayoutView, router) {

        var mainLayout = new MainPageLayoutView({top : true, center : true});
        mainLayout.placeAt(document.body);

        var advertisementDetailsPageView = new AdvertisementDetailsPageView();
        var searchView = new SearchView();
        var loginView = new LoginView();

        router.setUpMainFrame(mainLayout);
        router.registerView("/searchView", searchView);
        router.registerView("/login", loginView);
        router.registerView("/adDetailsPageView", advertisementDetailsPageView);

        router.startup();
        mainLayout.startup();

        function createAndAppendDiv() {
            return domConstruct.create("div", null, "viewContainer");
        }
    });