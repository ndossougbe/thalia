/**
 * thalia.layout Module
 *
 * Description
 */
angular.module('thalia.layout', [])

.controller( 'AppCtrl', function AppCtrl ( $scope, $location ) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | thalia' ;
    }
  });

  // Used across many templates. putting the values in an object keeps track the references.
  $scope.display = {
    sidebar: true,
    advancedSearch: false
  };
})

;