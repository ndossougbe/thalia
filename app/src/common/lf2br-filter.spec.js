describe('lf2br filter', function() {
  describe( 'apply filter', function() {
    var $filter;

    beforeEach( module( 'thalia' ) );

    beforeEach(function () {
      inject(function (_$filter_) {
        $filter = _$filter_;
      });
    });

    it('should replace cr, lf and crlf', function () {
    // Arrange.
    var string = 'hello \n world \r ! \r\n', result;

    // Act.
    result = $filter('lf2br')(string);

    // Assert.
    expect(result).toEqual('hello <br /> world <br /> ! <br />');
  });
  });
});