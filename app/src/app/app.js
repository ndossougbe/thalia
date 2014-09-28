angular.module( 'thalia', [
  'templates-app',
  'templates-common',
  'thalia.filters',
  'thalia.layout',
  'thalia.videos',
  'thalia.music',
  'ui.router'
])

.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/videos' );
})

.run( function run () {
})

;

