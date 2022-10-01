import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import "./AddCompany.css";
import { useState } from 'react';
import axios from 'axios';
import { Form } from 'semantic-ui-react';
//import { useNavigate } from 'react-router-dom';



export const AddCompany = () => {

   // let navigate = useNavigate(); 
   
    const [company, setCompany] = useState({
        title: "",   
        categoryId: null,
        ilId: null,
        ilceId: null,
        mahalleId: null,  
 
    });

    const { title, categoryId, ilId, ilceId, mahalleId } = company;

    const onInputChange = (e) => {
        setCompany({ ...company, [e.target.name]: e.target.value });
    };

    const onSubmit = async () => {
        console.log(title)
        //saveCompany();
        ///e.preventDefault();
        await axios.post("http://localhost:8080/companies", company);
        //navigate("/");
        //onSubmit={(e) => onSubmit(e)}

    }

   /* const saveCompany= () =>{
        fetch("/companies", {
            method:"POST",
            headers:{"Content-Type": "application/json"},
            body:JSON.stringify({
                title:title,
                categoryId: categoryId,
                ilId: ilId,
                ilceId:ilceId,
                mahalleId: mahalleId,
            }),
        })
        .then((res) => res.json())
        .catch((error) =>console.log("Error"))

    }*/
    
    /*const onSubmit = () => {
        console.log(title)
        fetch("/companies", {
            method:"POST",
            headers:{"Content-Type": "application/json"},
            body:JSON.stringify({
                id:10,
                title:title,
                categoryId: categoryId,
                ilId: ilId,
                ilçeId:ilçeId,
                mahalleId: mahalleId,
            }),
        })
        .then((res) => res.json())
        .catch((error) =>console.log("Error"))

    }*/
   

    return (
        <div id='AddCompanyContainer' >
            <div id='açıklama'>
                <h2>Firmanızı Ekleyin</h2>
                <p>Lütfen yanda yer alan tüm alanları doldurunuz.</p>
                <p>Bulur.com firmanızın ve/veya hizmetlerinizin, bulunduğunuz bölgenin her noktasından ulaşılabilir olmasını sağlayan bir platformdur..</p>
                <br></br>
                <p >iletişim: 0(555) 555 55 55</p>
            </div>
            <div id='py-4'>
                <Form >
                <Box
                    component="form"
                    sx={{
                        '& .MuiTextField-root': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <div>
                        <TextField
                            required
                            label="İsim Soyisim"
                        
                        /><br></br>
                        <TextField
                            required
                            type={"email"}
                            label="e-mail"

                        /><br></br>
                        <TextField
                            required
                            id="outlined-required"
                            type={"tel"}
                            label="Telefon numarası"

                        /><br></br>
                        <TextField
                            required
                            type={"text"}
                            label="Firma adı"
                            name='title'
                            value={title}
                            onChange={(e) => onInputChange(e)}
                        /><br></br>
                        <TextField
                            required
                            type={"text"}
                            label="Sektör"
                            name='categoryId'
                            value={categoryId}
                            onChange={(e) => onInputChange(e)}
                        /><br></br>
                        <TextField
                            type={"text"}
                            label="İl"
                            name='ilId'
                            value={ilId}
                            onChange={(e) => onInputChange(e)}
                        /><br></br>
                        <TextField
                            type={"text"}
                            label="İlçe"
                            name='ilceId'
                            value={ilceId}
                            onChange={(e) => onInputChange(e)}
                        /><br></br>
                        <TextField
                            type={"text"}
                            label="Mahalle"
                            name='mahalleId'
                            value={mahalleId}
                            onChange={(e) => onInputChange(e)}
                        /><br></br>
                        <br></br>
                        <Button onClick={onSubmit}  type='submit' variant="contained" id='button1' >Kaydet</Button>
                        <br></br>

                    </div>

                </Box>
                </Form>

            </div>
        </div>
    )
}

