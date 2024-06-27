import { Box } from "@mui/material";

export default function Product({ product }) {
  return (
    <Box
      className="product"
      sx={{ p: 5, border: "3px solid black", padding: "50px" }}
      width={"auto"}
      alignItems={"center"}

    >
      <text data-testid-="product-name" className="product-name">{product.name}</text>
    </Box>
  );
}
