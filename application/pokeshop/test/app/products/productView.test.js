const getProducts = require('../../../src/app/products/productView');


test('getProducts returns non-empty array of objects', async () => {
    let actualProducts = await getProducts();
    expect(actualProducts.length).toBeGreaterThan(0);
    expect(actualProducts[0].name).toBe('bulbasaur')
})

test('getProducts returns "bulbasaur" as first entry', async () => {
    let actualProducts = await getProducts();
    expect(actualProducts[0].name).toBe('bulbasaur')
})