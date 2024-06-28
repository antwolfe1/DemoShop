import { Box } from "@mui/material";
import Product from "./Product";
import { getStaticProps } from "./productView";

export default async function Products() {
  const { products } = (await getStaticProps()).props;
  // console.log(products);

  return (
    <main>
      <header className="products-page">Products</header>
      <Box
        display={"flex"}
        flex={1}
        flexWrap={"wrap"}
        justifyContent={"space-around"}
        marginTop={8}
        bgcolor="aliceblue"
      >
        {products.map((product) => (
          <Product key={product.name} product={product} />
        ))}
      </Box>
    </main>
  );
}
