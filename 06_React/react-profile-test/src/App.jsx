import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import styled from 'styled-components'
import ProfileCard from './components/ProfileCard'

const profileCard = [{
  member_id: 1,
  member_name: "홍길동",
  age: 19,
  isOnline: true,
},{
  member_id: 2,
  member_name: "김길동",
  age: 21,
  isOnline: true,
},{
  member_id: 3,
  member_name: "홍길삼",
  age: 25,
  isOnline: false,
}]

function App() {

  return (
    <>
  <Table>
    <thead>
      <tr>
        <th>이름</th>
        <th>나이</th>
        <th>온라인 여부</th>
      </tr>
    </thead>
    <tbody>
      {profileCard.map(m => <ProfileCard key={m.member_id} members={m}/>)}
    </tbody>
  </Table>
    </>
  )
}

export default App
