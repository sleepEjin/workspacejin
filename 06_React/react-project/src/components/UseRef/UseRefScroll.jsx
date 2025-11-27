import React from 'react'
import styled from 'styled-components'

const Nav = styled.nav`
    position:fixed;
    top: 0;
    background: #fff;
    width: 100%;
    z-index: 10;
    `

const Navul = styled.ul`
    display:flex;
    gap:12px;
    list-style: none;
    padding: 12px;
    cursor: pointer;
`


const UseRefScroll = () => {
  return (
   <>
    <Nav>
        <Navul>
            <li>메인페이지</li>
            <li>회사소개</li>
            <li></li>
        </Navul>
    </Nav>
   </>
  )
}

export default UseRefScroll