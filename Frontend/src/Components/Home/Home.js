import React, { useState, useEffect } from "react";
import "./Home.scss";
import CompanyList from "../Company/CompanyList";
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import { Form } from "semantic-ui-react";
import { Box } from "@mui/material";
import Button from '@mui/material/Button';


function Home() {

    const [categoryId, setCategoryId] = useState(null)
    const [ilId, setIlId] = useState(null);
    const [ilceId, setIlceId] = useState(null);


    const SaveSearch = () => {
        console.log("saveSearch");
        console.log({ categoryId }, { ilId }, { ilceId });

    }
    const handleSubmit = () => {
        console.log("submit");
        SaveSearch();
       // setCategoryId(100);
        //setIlId(100);
       // setIlceId(100);
    }

    const [categoryList, setCategoryList] = useState([]);
    const [ilList, setilList] = useState([]);
    const [ilceList, setilceList] = useState([]);
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [companyList, setCompanyList] = useState([]);


    useEffect(() => {
        if(categoryId !=null && ilId!=null && ilceId!=null){
            fetch("/companies?categoryId=" + categoryId + "&ilId=" + ilId + "&ilceId=" + ilceId)
            .then(res => res.json())
            .then(
                (result) => {

                    setCompanyList(result);

                },

            )

        }
        else if(categoryId != null){
            fetch("/companies?categoryId=" + categoryId)
            .then(res => res.json())
            .then(
                (result) => {

                    setCompanyList(result);

                },

            )

        }
        else if(categoryId != null && ilId !=null){
            fetch("/companies?categoryId=" + categoryId + "&ilId=" + ilId)
            .then(res => res.json())
            .then(
                (result) => {

                    setCompanyList(result);

                },

            ) 
        }
        else{
            fetch("/companies")
            .then(res => res.json())
            .then(
                (result) => {

                    setCompanyList(result);

                },

            )
        }
        
    }, [categoryId, ilId, ilceId])


    useEffect(() => {
        fetch("/categories")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setCategoryList(result);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])

    useEffect(() => {
        fetch("/iller")
            .then(res => res.json())
            .then(
                (result) => {
                    setilList(result);
                },
            )
    }, [])

    useEffect(() => {
        fetch("/ilceler?ilId=" + ilId)
            .then(res => res.json())
            .then(
                (result) => {
                    setilceList(result);
                },
            )
    }, [ilId])





    if (error) {
        return <div> Error !!! </div>;
    } else if (!isLoaded) {
        return <div> Loading... </div>;
    }
    else {


        return (
            <>
                <div className="searching">

                    <Form>
                        <h1 >Aradığın Firmayı Bul!</h1>
                        <Box sx={{ '& .MuiTextField-root': { m: 1 }, display: "inline-flex", marginBottom: 3, marginTop: 3 }}>
                            <Autocomplete
                                value={categoryId}
                                onChange={(event, newValue) => {
                                    setCategoryId(newValue.id);
                                }}
                                options={categoryList}
                                getOptionLabel={(option) => option.title}
                                isOptionEqualToValue={(option, value) => option.id === value.id}

                                sx={{ width: 300, margin: 3 }}
                                renderInput={(params) => <TextField  {...params} label="Kategori" name="categoryId"
                                />}


                            />

                            <Autocomplete
                                value={ilId}
                                onChange={(event, newValue) => {
                                    setIlId(newValue.id);
                                }}
                                options={ilList}
                                getOptionLabel={(option) => option.name}
                                sx={{ width: 300, margin: 3 }}
                                renderInput={(params) => <TextField {...params} label="il" name="ilId" />}

                            />

                            <Autocomplete
                                value={ilceId}
                                onChange={(event, newValue) => {
                                    setIlceId(newValue.id);
                                }}
                                options={ilceList}
                                getOptionLabel={(option) => option.name}
                                sx={{ width: 300, margin: 3 }}
                                renderInput={(params) => <TextField {...params} label="ilce" name="ilceId" />}
                            />

                        </Box>
                        <br></br>
                        <Button onClick={handleSubmit} sx={{ width: 100 }} type='submit' variant="contained" id='button1' >Ara</Button>

                    </Form>
                </div>


                <div className="container">
                    {companyList.map(company =>
                    (
                        <CompanyList id={company.id} title={company.title} info={company.info}
                            phoneNumber={company.phoneNumber} adress={company.adress} ilName={company.ilName}
                            ilceName={company.ilceName} mahalleName={company.mahalleName} categoryName={company.categoryName}
                        ></CompanyList>

                    )
                    )}

                </div>
            </>


        );

    }




}


export default Home;