import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";

export default function Registracija(){
    const [uporabniskoIme,setUporabniskoIme] = useState("");
    const [geslo,setGeslo] = useState("");

    function registriraj(){
        api.post("/uporabnik/dodaj", {
            uporabniskoIme: uporabniskoIme,
            geslo:geslo
        }).then((result)=> {
                if(result.data === ""){
                    alert("Uporabnik z takšnim uporabniškim imenom že obstaja!");
                }else{
                    alert("Uspešna registracija : "+result.data.uporabniskoIme);
                }

            }
        
        )
    }

    return(
        <>
            <h1>REGISTRACIJA</h1>
            <TextField value={uporabniskoIme} onChange={(event) => setUporabniskoIme(event.target.value)} label="uporabniskoIme"/> <br/><br/>
            <TextField value={geslo} onChange={(event) => setGeslo(event.target.value)} label="geslo"/> <br/>
            <Button onClick={registriraj}>Registriraj</Button>
        </>
    )

}