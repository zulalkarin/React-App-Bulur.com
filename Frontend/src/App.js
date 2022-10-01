//import React, { Component } from 'React';
//import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Routes, Route} from "react-router-dom";
import Navbar from './Components/Navbar/Navbar';
//import Home from './Components/Home/Home';
//import User from './Components/User/User';
import Home from './Components/Home/Home';
import { AddCompany } from './Components/AddCompany/AddCompany';
import Login from './Components/Login/Login';
import CompanyPage from './Components/Company/CompanyPage';
//import Home from './Components/Home/Home';
//react router nedir??: https://netbilio.com/react-router-6-nedir-nasil-kullanilir/#:~:text=in%C5%9Fa%20edece%C4%9Fimizi%20g%C3%B6rece%C4%9Fiz.-,React%20Router%20Dom,sayfalar%C4%B1%20aras%C4%B1nda%20gezinmek%20olduk%C3%A7a%20kolayla%C5%9F%C4%B1yor.
//react router sayfa yenilenmeden diğer bir sayfaya geçebilmemiz için geliştirilmiş olan bir kütüphanedir

function App() {
  return (
    <div className='App'>
      <BrowserRouter>
        <Navbar></Navbar> 
        <Routes>
          <Route exact path='/' element={<Home />}></Route>
          <Route exact path='/login' element={<Login />}></Route>
          <Route exact path='/addCompany' element={<AddCompany />}></Route>
          <Route exact path='/companies/:id' element={<CompanyPage />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

