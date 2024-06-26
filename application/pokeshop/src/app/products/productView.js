const productsLogic = require('./productsLogic');


function getProducts(){
    let productsArray = [];
    productsLogic().getProducts();
    return productsArray;
}

module.exports = getProducts;