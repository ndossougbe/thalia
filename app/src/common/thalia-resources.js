angular.module( 'thalia.resources', [
  'ngResource'
])

.factory('Media', function Media ( $resource ) {
  var Resource = $resource('/api/media/:id', {id: '@id'});
  return Resource;
})

;
