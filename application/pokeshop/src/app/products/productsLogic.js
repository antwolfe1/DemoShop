const productsService = require("./productsService");

function getProducts() {
  let productsArray = [];
  productsService().getProducts();
  return productsArray;
}

module.exports = getProducts;
