define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "dijit/registry",
    "dojo/on",
    "dojo/text!./templates/SearchWidget.html",
    "../controllers/SearchWidgetController",
    "dojo/dom",
    //in template
    "dijit/form/TextBox"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, registry, on, template, SearchWidgetController, dom) {

    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template,

        buildRendering : function(){
            this.inherited(arguments);
        },

        postCreate : function(){
            this._setupSearchButtonOnClick();
        },

        _setupSearchButtonOnClick : function () {
            var self = this;
            on(this.searchButton, "click", function () {
                //SearchWidgetController.saveUserInput({userInputValue : self._getUserInput()});
                SearchWidgetController.saveUserInput({userInputValue : self._getUserInput()});
            });
        },

        _getUserInput : function () {
            return dom.byId("userInputValue").value;
        }
        
    });

});
