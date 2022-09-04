import { useState } from "react";
import {
  Box,
  Button,
  Grid,
  TextField,
  Typography,
} from "@mui/material";
import "./scss/styles.scss";
import { Link, Navigate } from "react-router-dom";
import Logo from "../../assets/logoimg.png";
import { makeStyles } from "@material-ui/core/styles";
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#202DBF',
    }
  },
});


const useStyles = makeStyles((theme) => {
  return {
    custom: {
      border: "1px solid pink",
      borderRadius: "0px",
      borderTopLeftRadius: "50px",
      borderBottomLeftRadius: "50px",
      backgroundColor: "white",
      width: "100%",
      height: "100vh",
      margin: "0rem 0rem",
      padding: "0rem 0rem",
      [theme.breakpoints.down(720)]: {
        borderTopLeftRadius: "10px",
        borderBottomLeftRadius: "10px",
        padding: "0rem 0rem",
        maxWidth: 400,
      }
    },
  }
});

export default function SignupForm() {
  const [error, setError] = useState<string>("");
  const [firstname, setFirstname] = useState<string>("");
  const [fnameerror, setFnameerror] = useState<{ required: string }>();
  const [lastname, setLastname] = useState<string>("");
  const [lnameerror, setLnameerror] = useState<{ required: string }>();
  const [username, setUsername] = useState<string>("");
  const [nameerror, setNameerror] = useState<{ unique: string, required: string }>();
  const [email, setEmail] = useState<string>("");
  const [emailerror, setEmailerror] = useState<{ invalid: string, required: string }>();
  const [company_name, setCompanyName] = useState<string>("");
  const [cnameerror, setCnameerror] = useState<{ required: string }>();
  const [password, setPassword] = useState<string>("");
  const [passerror, setPasserror] = useState<{ passlength: string, required: string, invalid: string }>();
  const [user, setUser] = useState<boolean>(false);
  const signupUrl = 'https://hu-taxer-backend-urtjok3rza-wl.a.run.app/addUser';
  const axios = require('axios');
  const classes = useStyles();

  async function addNewUser() {
    setFnameerror({ required: '' });
    if (firstname === "") {
      return setFnameerror({ required: 'this field is required' });
    }
    setLnameerror({ required: '' });
    if (lastname === "") {
      return setLnameerror({ required: 'this field is required' });
    }
    setNameerror({ unique: '', required: '' });
    if (username === "") {
      return setNameerror({ unique: '', required: 'this field is required' });
    }
    setEmailerror({ invalid: '', required: '' });
    if (email === "") {
      return setEmailerror({ invalid: '', required: 'this field is required' });
    }
    setEmailerror({ invalid: '', required: '' });
    if (!/\S+@\S+\.\S+/.test(email)) {
      return setEmailerror({ invalid: 'enter a valid Email', required: '' });
    }
    setCnameerror({ required: '' });
    if (company_name === "") {
      return setCnameerror({ required: 'this field is required' });
    }
    setPasserror({ passlength: '', required: '', invalid: '' });
    if (password === "") {
      return setPasserror({ passlength: '', required: 'this field is required', invalid: '' });
    }
    setPasserror({ passlength: '', required: '', invalid: '' });
    if (password.length < 8) {
      return setPasserror({ passlength: 'Password must have atleast 8 characters', required: '', invalid: '' });
    }
    if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/.test(password)) {
      return setPasserror({ passlength: '', required: '', invalid: 'must contain at least 8-20 characters,one digit,one upper case alphabet,one lower case alphabet, one special character which includes !@#$%&*()-+=^ and must not contain any white space.' });
    }
    await axios.post(signupUrl,
      {
        userFirstName: firstname, userLastName: lastname,
        userName: username, userEmail: email,
        userCompany: company_name,
        userPassword: password
      }).then(() => {
        setUser(true);
      })
      .catch((errors: any)=> { 
        setError(errors.response.data.Error);
        console.log(errors.response.data.Error);
      })
  }

  if (user) {
    return <Navigate to="/login" />;
  }

  return (
    <div>
      <ThemeProvider theme={theme}>
        <Grid container className="form__grid" >
          <Box className={classes.custom} >
            <Grid item xs={10} md={10} lg={12} >
              <img src={Logo} style={{ height: "10rem" }} />
            </Grid>

            <Grid item justifyContent="space-evenly" container lg={12} role='form'  >
              <Grid item justifyContent="space-around" lg={7} >
                <Typography gutterBottom variant="h4"  >
                  Create an Account
                </Typography>
                {error && <p style={{color:'red', alignContent:'center'}} >{error}</p>}
              </Grid>

              <Grid xs={10} md={10} lg={7} item justifyContent="space-around" >
                <p className="income_form_fields">First Name</p>
                <TextField
                  onChange={(e) => setFirstname(e.target.value)}
                  name="firstname"
                  error={Boolean(fnameerror?.required)}
                  helperText={(fnameerror?.required)}
                  placeholder="Enter your First Name"
                  value={firstname}
                  size="small" required
                  fullWidth
                />
              </Grid>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"  >
                <p className="income_form_fields">Last Name</p>
                <TextField
                  onChange={(e) => setLastname(e.target.value)}
                  name="lastname"
                  error={Boolean(lnameerror?.required)}
                  helperText={(lnameerror?.required)}
                  placeholder="Enter your Last Name"
                  value={lastname}
                  size="small" required
                  fullWidth
                />
              </Grid>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"   >
                <p className="income_form_fields">Username</p>
                <TextField
                  onChange={(e) => setUsername(e.target.value)}
                  name="username"
                  error={Boolean(nameerror?.required) || Boolean(nameerror?.unique)}
                  helperText={(nameerror?.required) || (nameerror?.unique)}
                  placeholder="Enter your unique Username"
                  value={username}
                  size="small" required
                  fullWidth
                />
              </Grid>

              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"   >
                <p className="income_form_fields">Email</p>
                <TextField
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                  name="email"
                  type="email"
                  error={Boolean(emailerror?.required) || Boolean(emailerror?.invalid)}
                  helperText={(emailerror?.required) || (emailerror?.invalid)}
                  placeholder="Enter your Email Id"
                  fullWidth
                  size="small" required
                />
              </Grid>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"   >
                <p className="income_form_fields">Company Name</p>
                <TextField
                  onChange={(e) => setCompanyName(e.target.value)}
                  name="company_name"
                  error={Boolean(cnameerror?.required)}
                  helperText={(cnameerror?.required)}
                  size="small" required
                  placeholder="Enter your Company Name"
                  value={company_name}
                  fullWidth
                />
              </Grid>

              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"   >
                <p className="income_form_fields">Password</p>
                <TextField
                  type="password"
                  onChange={(e) => setPassword(e.target.value)}
                  name="password"
                  error={Boolean(passerror?.required) || Boolean(passerror?.passlength) || Boolean(passerror?.invalid)}
                  helperText={(passerror?.required) || (passerror?.passlength) || (passerror?.invalid)}
                  value={password}
                  size="small" required
                  placeholder="Enter your Password"
                  fullWidth
                >
                </TextField>
              </Grid>
              <Grid xs={10} md={10} lg={7} item style={{ marginTop: "1rem" }} justifyContent="space-around"  >
                <Button
                  onClick={addNewUser}
                  variant="contained"
                  className="submit__button"
                  color="primary"
                  fullWidth
                >
                  {" "}
                  Sign Up
                </Button>
              </Grid>


            </Grid>



            <div className="alreadyMember">
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around"  >
                <Typography variant="subtitle1">Already a Member?
                  <Link
                    to="/login"
                    style={{ textDecoration: "none", color: "#202DBF", fontWeight: "bolder" }}
                  >{" "}
                    Login
                  </Link>
                </Typography>
              </Grid>

            </div>
          </Box>
        </Grid>
      </ThemeProvider>
    </div>
  );
}
