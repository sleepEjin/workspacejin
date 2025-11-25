import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import JavaScript from './components/JavaScript'
import './App.css'
import Style from './components/Style'
import Product from './components/Product'
import styled from 'styled-components'

const products = [{
  product_id: 1,
  product_name: "삼성 갤럭시 s25 울트라",
  price: 1000000,
  color: "블랙"
},{
  product_id: 2,
  product_name: "삼성 갤럭시 s25 울트라",
  price: 1100000,
  color: "화이트"
},{
  product_id: 3,
  product_name: "아이폰",
  price: 1000000,
  color: "블랙"
}]

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;

`

const Th = styled.th`
  background: #8a8a8a;
  color: white;
  padding: 12px;
  border:1px solid #afafaf;
`

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <JavaScript /> */}
      {/* <Style /> */}
    <Table>
      <thead>
      <tr>
        <th>제품명</th>
        <th>가격</th>
        <th>색상</th>
  </tr>
  </thead>
  <tbody>
    {products.map(p => <Product product={p.product_id}/>)}
    <Product />
  </tbody>
    </Table>
    </>
  )
}

export default App
