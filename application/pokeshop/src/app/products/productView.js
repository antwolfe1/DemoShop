const getAllProducts = require('./productsLogic');
import { Box } from "@mui/material";
import Product from "./Product";


export async function getStaticProps() {
    const products = await getAllProducts();
    // console.log(products);

    return {props: {products} }
    // return products
}


// module.exports = getStaticProps;
