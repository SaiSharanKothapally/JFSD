import logo from './logo.svg';
import './App.css';
import Navbar from './Components/Navbar';
import Home from './Components/home';
import About from './Components/about';
import Contact from './Components/contact';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <header className="App-header">
          <Routes>
            <Route path='/' exact element={<Home/>}/>
            <Route path='/about' exact element={<About/>}/>
            <Route path='/contact' exact element={<Contact/>}/>
          </Routes>
        </header>
      </BrowserRouter>
    </div>
  );
}

export default App;
