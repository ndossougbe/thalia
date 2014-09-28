angular.module( 'thalia', [
  'templates-app',
  'templates-common',
  'thalia.filters',
  'thalia.layout',
  'ui.router',
  'thalia.home',
  'thalia.about'
])

.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
})

.run( function run () {
})

;

