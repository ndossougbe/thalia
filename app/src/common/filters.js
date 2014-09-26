angular.module( 'thalia.filters', [])

.filter('lf2br', function  () {
  return function (input) {
    return (input && angular.isFunction(input.replace)) ? input.replace(/(?:\r\n|\r|\n|\\n|\\r|\\r\\n)/g, '<br />') : input;
  };
})

.filter('trustAsHtml', function ($sce) {
  return function (input) {
    return input ? $sce.trustAsHtml(input) : {};
  };
})

;
