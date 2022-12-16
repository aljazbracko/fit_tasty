import React from "react";
import { Route, Routes } from "react-router-dom";
import EnRecept from "../Recepti/EnRecept";
import PageNotFound from "../PageNotFound/PageNotFound";
import Prijava from "../Prijava/Prijava";
import Recepti from "../Recepti/Recepti";
import Objavi from "../Recepti/Objavi";
import Registracija from "../Registracija/Registracija";


export default function Routing() {
    return (
        <Routes>
            <Route path="/" element={<p>Domača stran</p>} />
            <Route path="/recepti" element = {<Recepti/>} />
            <Route path="/enRecept/:id" element = {<EnRecept/>} />
            <Route path="/dodaj" element = {<Objavi/>} />
            <Route path="/prijava" element = {<Prijava/>} />
            <Route path="/registracija" element = {<Registracija/>} />
            <Route path="*" element={<PageNotFound/>} />
        </Routes>

    );
}