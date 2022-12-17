import React, { useEffect, useState } from "react";
import api from "../../services/api";
import {Button, List, ListItem, ListItemButton } from "@mui/material";
import { Box } from "@mui/system";
import { Link, useNavigate } from "react-router-dom";


export default function Recepti(){
    const [recepti, setRecepti] = useState([]);
    useEffect(() => {
        api.get("/recept/vsi").then((result) => {
            setRecepti(result.data);
            console.log(result.data);
        })
    },[]);

    return(
        <>
        <h1>RECEPTI</h1>
        <Box sx={{width:'80%', maxwidth:360, bgcolor:'background.paper',margin:"auto"}}>
            <nav aria-label="main mailbox folders">
                <List>
        {
            recepti.map((recept) => (
                <ListItem key={recept.idRecept} sx={{border:"1px solid gray"}}>
                    <ListItemButton to={"/enRecept/"+recept.idRecept}>
                        <p>{recept.ime} <br></br>- {recept.opis}</p>
                    </ListItemButton>
                </ListItem>
                        
            ))
        }
                </List>
            </nav>
        </Box>
        
        </>
        

    );
}