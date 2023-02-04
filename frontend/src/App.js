import { BrowserRouter, Route, Routes } from "react-router-dom";
import Welcome from "./pages/Welcome/Welcome";
import "./App.css";

function App() {
  return (
    <BrowserRouter>
      <main>
        <Routes>
          <Route path="/" element={<Welcome />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
