import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { useNavigate } from 'react-router-dom';

export default function Navbar() {
  let navigate = useNavigate();

  function pojdiNaPrijavo(){
    navigate("/prijava");
  }
  function pojdiNaRecepte(){
    navigate("/recepti");
  }
  function pojdiNaRegistracijo(){
    navigate("/registracija");
  }
  function pojdiNaObjavljanje(){
    navigate("/dodaj");
  }
  function logout(){
    localStorage.clear();
    document.getElementById("prijava").style.display = "block";
    document.getElementById("registracija").style.display = "block";
    document.getElementById("logout").style.display = "none";
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Button onClick={pojdiNaRecepte} color="inherit" id="recepti">Recepti</Button>
          <Button onClick={pojdiNaObjavljanje} color="inherit" id="objavi">Objavi</Button>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            FIT&TASTY
          </Typography>
          <p id="uporabnik"></p>
          <Button onClick={pojdiNaPrijavo} color="inherit" id="prijava">Prijava</Button> 
          <Button onClick={pojdiNaRegistracijo} color="inherit" id="registracija">Registracija</Button>
          <Button onClick={logout} color="inherit" id="logout">LogOut</Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}