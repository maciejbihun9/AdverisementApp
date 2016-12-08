define([
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/_base/declare",
    "dojo/text!./templates/SearchWidget.html"
], function(_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, declare, template) {

    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
        templateString: template
    });

});
