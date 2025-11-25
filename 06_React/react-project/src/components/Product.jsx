import React from 'react'

const product = {
    product_id:1,
    product_name: "삼성 갤럭시 S25",
    price: 100000,
    color: "블랙"
}

const Td = styled.td`
    padding: 12px;
    border: 1px solid #afafaf;
`

const Product = (props) => {
    
    const product = props.product;
  return (
    <tr>
        <Td>{product.product_name}</Td>
        <Td>{product.price}</Td>
        <Td>{product.color}</Td>
    </tr>
  )
}

export default Product