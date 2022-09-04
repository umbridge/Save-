import React from "react";
import TaxCalcImg from "../../assets/Tax_calc.png";
import Signup from "./SignupForm";
import "./scss/styles.scss"
export default function SignUpPage() {
  return (
    <div>
      <div className="auth__container">
        <div className="auth__imgandText">
          <div className="auth_img">
            <img src={TaxCalcImg} alt="SignupImg" className="auth__image" />
          </div>
          <div className="auth__text">
            <p className="auth_text">Save Tax in less than 5 minutes</p>
            <p className="auth_subtext">Saving tax is like taking a selfie. Try it yourself</p>
          </div>
        </div>

        <div className="signup__form">
          <Signup />
        </div>
      </div>
    </div>
  );
}
