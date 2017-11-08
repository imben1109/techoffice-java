var app = angular.module("app");

app.factory("gridService", function(){
	return {
		getDbClickRowTemplate: function(methodName){
		    return "<div ng-dblclick=\"grid.appScope."+methodName+"(row)\" ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>";
		}
	};
});
