const getAllProducts = require("../../../src/app/products/productsLogic");

describe("Products Logic", () => {
  test("getProducts returns non-empty array of objects", async () => {
    let actualProducts = await getAllProducts();
    expect(actualProducts.length).toBeGreaterThan(0);
  });

  test('getProducts returns "bulbasaur" as first entry', async () => {
    let actualProducts = await getAllProducts();
    expect(actualProducts[0].name).toBe("bulbasaur");
  });
});
