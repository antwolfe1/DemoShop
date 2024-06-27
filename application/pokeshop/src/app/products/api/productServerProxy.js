async function get() {
  try {
      const products = fetch(`http://localhost:8080/products`); //promise
      return (await products).json();
      // return { props: { products } };
      
  } catch (error) {
    console.log(error);
  }


};


// async function post() {
//   const res = await fetch(`http://localhost:8080/products`);
//   console.log(res);
//   const products = await res.json();

//   // return Response.json(products)
//   return { props: { products } };
// }


// export async function GET(request) {
//     const { searchParams } = new URL(request.url)
//     const id = searchParams.get('id')
//     const res = await fetch(`https://data.mongodb-api.com/product/${id}`, {
//       headers: {
//         'Content-Type': 'application/json',
//       },
//     })
//     const product = await res.json()

//     return Response.json({ product })
//   }
 
module.exports = get;

