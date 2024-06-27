const getAllProducts = require('./productsLogic');


async function getProducts(){
    let productsArray = await getAllProducts();
    return productsArray;
}

module.exports = getProducts;