const get = require('./api/productServerProxy');


async function getAllProducts() {
  const productsArray = await get();
  return productsArray;
}

module.exports = getAllProducts;
