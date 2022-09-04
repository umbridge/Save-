
import ErrorcImg from "../../assets/404 error.png";
import "./scss/styles.scss"
export default function LoginPage() {
  return (
    <div>
      <div className="auth__container">
        <div className="auth__imgandText">
        
          <div className="auth_img">
            <img src={ErrorcImg} alt="authImg" className="auth__image" />
          </div>
          <div className="auth__text">
            <p className="auth_text">We searched everywhere, but the requested URL could not be found.</p>
          </div>
        </div>
      </div>
    </div>
  )
}
