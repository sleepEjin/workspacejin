import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Hello from './components/Hello'
import Head from './components/Head'

function App() {

  return (
    <>
    {/* <Hello />  */}
    {/* <Head type="h2" /> */}
    <Head>
      <h3>무엇을 도와드릴까요?</h3>
    </Head>
    </>
  )
}

export default App
