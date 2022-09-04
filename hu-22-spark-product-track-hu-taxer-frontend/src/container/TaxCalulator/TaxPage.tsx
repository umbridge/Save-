import { Navigate } from "react-router-dom";
import MenuAppBar from "../Auth/MenuAppBar";
import FAQs from "./FAQs";
import LinearStepper from "./LinearStepper";


import "./styles.css";

export default function TaxPage() {
  return (
    <div className="tax">
      {localStorage.getItem("token") && (
        <>
          <MenuAppBar />
          <h1>Income Tax Calculator</h1>
          <div className="tax__container">
            <div className="tax__form">
              <LinearStepper />
            </div>
          </div>
          <div className="faqs">
            <FAQs />
          </div>
        </>
      )}
      {!localStorage.getItem("token") && (
        <>
          <Navigate to="/login"></Navigate>
        </>
      )}
    </div>
  );
}
