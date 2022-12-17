import { Button, TextField } from '@mui/material';
import React, { useState } from 'react';
import api from '../../services/api';

export default function Objavi(){
    const [ime,setIme] = useState("");
    const [opis,setOpis] = useState("");
    const [casKuhanja,setCasKuhanja] = useState(0);
    const [steviloKalorij,setSteviloKalorij] = useState(0);
    const [steviloOseb,setSteviloOseb] = useState(0);

    


    function dodajRecept(){
        let id = localStorage.getItem("idUporabnika");
        console.log(id);
        api.post("/uporabnik/dodajRecept/"+id , {
            ime : ime,
            opis : opis,
            casKuhanja : casKuhanja,
            steviloKalorij : steviloKalorij,
            steviloOseb: steviloOseb
        }).then((result) => alert("Uspešno dodan recept")
        );
    }

    return(
        <>
            <h1>OBJAVI RECEPT</h1>
            <TextField value={ime} onChange={(event) => setIme(event.target.value)} label="ime"/> <br/><br/> 
            <label for="opis">Opis</label> <br/>
            <textarea value={opis} onChange={(event) => setOpis(event.target.value)} label="opis" rows={5} cols={30} id="opis"/>
             <br/><br/>
            <TextField value={casKuhanja} onChange={(event) => setCasKuhanja(event.target.value)} label="casKuhanja" /> <br/><br/>
            <TextField value={steviloKalorij} onChange={(event) => setSteviloKalorij(event.target.value)} label="steviloKalorij"/> <br/><br/>
            <TextField value={steviloOseb} onChange={(event) => setSteviloOseb(event.target.value)} label="steviloOseb"/> <br/>
            <Button onClick={dodajRecept}>Objavi</Button>
        
        </>
    )

}