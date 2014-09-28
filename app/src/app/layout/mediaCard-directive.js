angular.module('thalia.layout.mediaCardDirective', []).

directive('thaliaMediaCard', function(){
// Runs during compile
return {
    scope: {
      'media': '=ngModel'
    },
    restrict: 'EA',
    templateUrl: 'layout/mediaCard-directive.tpl.html'
  };
});