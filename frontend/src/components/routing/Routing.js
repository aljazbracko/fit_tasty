import React from "react";
import { Route, Routes } from "react-router-dom";
import PageNotFound from "../PageNotFound/PageNotFound";


export default function Routing() {
    return (
        <Routes>
            <Route path="/" element={<p>Domača stran</p>} />
            <Route path="*" element={<PageNotFound/>} />
        </Routes>

    );
}