const getProducts = require('../../../src/app/products/productView');


test('getProducts returns array of objects', () => {
    expectedArray = [];
    expect(getProducts().length).toBeGreaterThan(0);
})