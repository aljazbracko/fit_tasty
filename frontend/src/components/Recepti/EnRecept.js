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

    return (
        <>
        <h1>EN RECEPT</h1>
        <p>ID:{recept.idRecept}</p>
        
        </>
        
        
    );
}