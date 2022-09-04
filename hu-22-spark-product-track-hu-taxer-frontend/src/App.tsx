import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TaxPage from "./container/TaxCalulator/TaxPage";
import ForgotPassword from "./container/Auth/ForgotPassword";
import SignUpPage from "./container/Auth/SignUpPage";
import LoginPage from "./container/Auth/LoginPage";


import NotFoundPage from "./container/Auth/NotFoundPage";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          {!localStorage.getItem("token") && <Route path="/" element={<LoginPage />} />}
          {localStorage.getItem("token") && <Route path="/" element={<TaxPage />} />}
          {/* <Route path="/" element={<LoginPage />} /> */}
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/forgotpassword" element={<ForgotPassword />} />
          <Route path="/taxpage" element={<TaxPage />} />
         
          <Route path="/*" element={<NotFoundPage />} />
          
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
