import React from "react";
import { Route, Routes } from "react-router-dom";
import EnRecept from "../EnRecept/EnRecept";
import PageNotFound from "../PageNotFound/PageNotFound";
import Recepti from "../Recepti/Recepti";


export default function Routing() {
    return (
        <Routes>
            <Route path="/" element={<p>Domača stran</p>} />
            <Route path="/recepti" element = {<Recepti/>} />
            <Route path="/enRecept/:id" element = {<EnRecept/>} />
            <Route path="*" element={<PageNotFound/>} />
        </Routes>

    );
}