const route = require('./api/route');

function getProducts() {
    let productsArray = [];
    route().get();
    return productsArray;
  }
  
  module.exports = getProducts;