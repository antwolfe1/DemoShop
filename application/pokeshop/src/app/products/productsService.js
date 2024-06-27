const get = require('./api/productServerProxy');

function getProducts() {
    let productsArray = get();
    console.log(productsArray);
    return productsArray;
  }
  
  module.exports = getProducts;