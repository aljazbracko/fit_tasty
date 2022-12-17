import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../../services/api";

export default function EnRecept(){
    let parametri = useParams();

    const [recept, setRecept] = useState({});

    useEffect(() => {
        api.get("/recept/"+parametri.id).then((result) => {
            setRecept(result.data);
            console.log(result.data);
            document.getElementById("prijava").style.display = "none";
            document.getElementById("registracija").style.display = "none";
        })
    },[]);
    
    if(recept.komentarji){
        var ul = recept.komentarji.map((komentar) => (
            <ul  key={komentar.idKomentar} style={{border: "1px solid black"}}>
                <li>
                    {komentar.casObjave}
                </li>
                <li>
                    {komentar.besedilo}
                </li>
                
            </ul>
        ))
    }
    
    return (
        <>
        <div style={{ width:"50%", margin:"auto"}}>
            <div style={{border: "1px solid black"}}>
                <h1>ID:{recept.idRecept}- {recept.ime}</h1>
                <p >Čas kuhanja: {recept.casKuhanja}sekund</p>
                <p>Za: {recept.steviloOseb} oseb</p>
                <p>Kalorije: {recept.steviloKalorij} kcal</p>
                <h3>OPIS:</h3>
                <p>{recept.opis}</p>
            </div>
            <h2>Komentarji:</h2>
            <div>
                
                {
                    ul
                }
                
            </div>
            
        </div>
        
        
        </>
        
        
    );
}