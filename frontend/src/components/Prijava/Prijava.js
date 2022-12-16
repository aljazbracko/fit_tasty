import { TextField, Button } from '@mui/material';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../../services/api';

export default function Prijava(){
    const [uporabniskoIme, setUporabniskoIme] = useState("");
    const [geslo, setGeslo] = useState("");
    
    let navigate = useNavigate();

    function prijaviUporabnika(){
        api.post("/uporabnik/prijava", {
            uporabniskoIme : uporabniskoIme,
            geslo : geslo
        }).then((result) => {

                if(result.data === ""){
                    alert("Nepravilni podatki!")
                }else{
                    console.log(result.data);
                    document.getElementById("prijava").style.display = "none";
                    document.getElementById("registracija").style.display = "none";
                    document.getElementById("logout").style.display="block";
                    localStorage.setItem('idUporabnika',result.data.idUporabnik);
                    navigate("/recepti");
                }
            }
            
            
        );  
    }


    return(
        <>
            <h1>PRIJAVA</h1>
            <TextField value={uporabniskoIme} onChange={(event) => setUporabniskoIme(event.target.value)} label="uporabniskoIme"/> <br/><br/>
            <TextField value={geslo} onChange={(event) => setGeslo(event.target.value)} label="geslo"/> <br/>
            <Button onClick={prijaviUporabnika}>Prijavi</Button>

        </>
    );
}