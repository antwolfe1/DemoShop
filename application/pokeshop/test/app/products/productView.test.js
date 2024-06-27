const getProducts = require("../../../src/app/products/productsLogic");
import Product from "@/app/products/Product";


describe("Products View", () => {
  test("Product Rendering", async () => {
    let actualProducts = await getProducts();
    expect(actualProducts.length).toBeGreaterThan(0);
  });

  test("Product Rendering", async () => {
    render(<Product />);
    const text = "bulbasaur"
    expect(this.props.first).toBe(text);
  });

 
})
