import React from 'react'
import Login from './LoginForm'
import TaxCalcImg from "../../assets/Tax-bro.png";
import "./scss/styles.scss"
export default function LoginPage() {
  return (
    <div>
      <div className="auth__container">
        <div className="auth__imgandText">
          <div className="auth_img">
            <img src={TaxCalcImg} alt="authImg" className="auth__image" />
          </div>
          <div className="auth__text">
            <p className="auth_text">Tax--  |  Savings++  |  Time--</p>
            <p className="auth_subtext">Save More Tax in Less Time</p>
          </div>
        </div>

        <div className="login__form">
          <Login />
        </div>
      </div>
    </div>
  )
}
