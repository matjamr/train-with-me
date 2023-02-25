import { BrowserRouter, Route, Routes } from "react-router-dom";
import Welcome from "./pages/Welcome/Welcome";
import "./App.css";
import { Login } from "./pages/Login/Login";
import UserProvider from "./context/User/UserContext";
import Home from "./pages/Home/Home";

function App() {
  return (
    <UserProvider>
      <BrowserRouter>
        <main>
          <Routes>
            <Route path="/" element={<Welcome />} />
            <Route path="/login" element={<Login />} />
            <Route path="/home" element={<Home />} />
          </Routes>
        </main>
      </BrowserRouter>
    </UserProvider>
  );
}

export default App;
