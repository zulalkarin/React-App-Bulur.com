
import React from "react";
import {Link} from "react-router-dom";
import "./Navbar.css";

 const linkStyle = {
  margin: "1rem",
  textDecoration: "none",
  fontSize: 22,
  fontFamily: "Georgia",
  color: 'aliceblue',
  fontWeight: 500,
};


function Navbar() {
    return(
      
       <>
           <nav>
           <object data="logo.svg" width="70" height="70"> </object>    
           <div >
              <ul id="navbar">
                    <Link to="/" style={linkStyle} >Anasayfa</Link>
                    <Link to="/login" style={linkStyle} >Giriş</Link>  
                    <Link to="/addCompany" style={linkStyle} >Firma Ekle</Link>
              </ul>
            </div> 
           </nav>    
        </>
    )
    
}

export default Navbar;
