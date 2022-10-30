import React from 'react'
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import Home from './components/Home'
import AddPost from "./components/AddContact";

import NavBar from './components/NavBar'

const App = () => {
  return (
    <div className="App">
    <ToastContainer />
            <NavBar/>
            <Route exact path="/" component={() => <Home />} />
            <Route exact path="/add" component={() => <AddPost />} />
    </div>
  )
}

export default App