import { Box } from "@mui/material";

export default function Product() {
  return (
    <Box
      className="product"
      display="flex"
      sx={{ p: 5, border: "3px solid black" }}
      maxWidth={200}
      alignItems={"center"}
    >
      <text className="product-name">A Product</text>
    </Box>
  );
}
