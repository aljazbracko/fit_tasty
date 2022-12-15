import logo from './logo.svg';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import Routing from './components/routing/Routing';
import Navbar from './components/Navbar/Navbar';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar/>
        <Routing/>
      </BrowserRouter>
    </div>
  );
}

export default App;
