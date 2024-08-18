import './App.css';
import { BrowserRouter as Router, Route, Switch, Routes } from 'react-router-dom';
import SearchBar from './components/Search';
import DefaultOpenPage from './components/Default';
function App() {
  return (
    <div className="App">
      <header className="App-header">
       <SearchBar/>
       <Router>
      <Routes>
        <Route path="/openingparent/" element={<DefaultOpenPage endpoint="" />} />
        <Route path="/openingparent/open" element={<DefaultOpenPage endpoint="open" />} />
        {/* <Route path="*" element={<h2>404 Not Found</h2>} /> */}
      </Routes>
    </Router>
      </header>
    </div>
  );
}

export default App;
