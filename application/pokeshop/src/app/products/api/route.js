

async function get(request) {
  const res = await fetch(`http://localhost:8080/products`, {
    headers: {
      'Content-Type': 'application/json',
    },
  })
  const products = await res.json()
 
  return Response.json(products)
}


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