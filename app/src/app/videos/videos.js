angular.module( 'thalia.videos', [
  'ui.router',
  'thalia.resources'
])

/**
 * Each section or module of the site can also have its own routes. AngularJS
 * will handle ensuring they are all available at run-time, but splitting it
 * this way makes each module more "self-contained".
 */
.config(function config( $stateProvider ) {
  $stateProvider.state( 'videos', {
    url: '/videos',
    views: {
      "main": {
        controller: 'VideosCtrl',
        templateUrl: 'videos/videos.tpl.html'
      }
    },
    data:{ pageTitle: 'Videos' }
  });
})

/**
 * And of course we define a controller for our route.
 */
.controller( 'VideosCtrl', function VideosController( $scope, Media ) {
  $scope.dataset = Media.query();
})

;

