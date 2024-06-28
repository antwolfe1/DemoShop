import { Box } from "@mui/material";

export default function Product({ product }) {
  return (
    <Box
      className="product"
      sx={{ p: "20px", border: "2px solid black" }}
      marginBottom={5}
      width={"200px"}
      height={"200px"}
      alignItems={"center"}
      textAlign={"center"}
      flexWrap={"wrap"}
    

    >
      <text data-testid-="product-name" className="product-name">{product.name}</text>
      {"\n"}
      {/* <a data-testid="product-image" className="product-image">{product.url}</a> */}
    </Box>
  );
}
