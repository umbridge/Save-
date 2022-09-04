import { useState } from "react";

import {
  Box,
  Button,
  Grid,
  TextField,
  Typography,
} from "@mui/material";
import "./scss/styles.scss";
import Logo from "../../assets/logoimg.png";
import { Link, Navigate } from 'react-router-dom';
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
      borderRadius: 0,
      borderTopLeftRadius: 50,
      borderBottomLeftRadius: 50,
      backgroundColor: "white",
      width: "100%",
      height: "100vh",
      margin: "0rem 0rem",
      padding: "0rem 0rem",
      [theme.breakpoints.down(720)]: {
        borderRadius: 10,
        padding: "0rem 0rem",
        maxWidth: 400,
      },
    },
  };
});

export default function LoginForm() {
  const [error, setError] = useState<string>("");
  const [username, setUsername] = useState<string>("");
  // const [nameerror, setNameerror] = useState<{required: string }>();
  const [password, setPassword] = useState<string>("");
  // const [passerror, setPasserror] = useState<{required: string }>();
  const [loggedIn, setloggedIn] = useState(false);
  const loginUrl = 'https://hu-taxer-backend-urtjok3rza-wl.a.run.app/login/authenticate';
  const axios = require('axios');
  const classes = useStyles();


  async function handleLogin() {
    // setNameerror({required: '' });
    // if (username === "") {
    //   return setNameerror({required: 'this field is required' });
    // }
    // setPasserror({required: ''});
    // if (password === "") {
    //   return setPasserror({required: 'this field is required'});
    // }
    axios({
      method: "post",
      url: loginUrl,
      headers:
      {
        "Content-Type":
          "application/json",
      },
      data: { userName: username, userPassword: password },
    }).then((response: any) => {
      console.log(response);
      localStorage.setItem("token", response.data.jwtToken);
      localStorage.setItem("email", response.data.user.userEmail);
      setloggedIn(true);
    })
      .catch((errors: any)=> { 
        setError(errors.response.data.Error);
        console.log(errors.response.data.Error);
      })
  }
  if (loggedIn) {
    return <Navigate to="/taxpage" />;
  }
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Grid container className="form__grid">
          <Box className={classes.custom}>
            <Grid item justifyContent="space-evenly" container xs={12} md={12} lg={12}>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around">
                <img src={Logo} alt="logo" style={{ height: "20rem" }} />
              </Grid>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around">
                <Typography gutterBottom variant="h4">
                  Welcome Back!                  
                </Typography>
                {error && <p style={{color:'red', alignContent:'center'}} >{error}</p>}
              </Grid>
              
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around">
                <p className="income_form_fields">Username</p>
                <TextField
                  onChange={(e) => setUsername(e.target.value)}
                  name="username"
                  // error={Boolean(nameerror?.required)}
                  // helperText={(nameerror?.required)}
                  placeholder="Enter your Username"
                  value={username}
                  size="small"
                  fullWidth required
                />
              </Grid>
              <Grid xs={10} md={10} lg={7} item justifyContent="space-around">
                <p className="income_form_fields">Password</p>
                <TextField
                  type="password"
                  onChange={(e) => setPassword(e.target.value)}
                  name="password"
                  // error={Boolean(passerror?.required)}
                  // helperText={(passerror?.required)}
                  value={password}
                  size="small"
                  placeholder="Enter your Password"
                  fullWidth required
                />
                <Typography textAlign={"right"} variant="subtitle1">
                  <Link
                    to="/forgotpassword"
                    style={{ textDecoration: "none", color: "primary" }}
                  >
                    Forgot Password?
                  </Link>
                </Typography>
              </Grid>

              <Grid xs={10} md={10} lg={7} item justifyContent="space-around">
                <Button
                  onClick={handleLogin}
                  variant="contained"
                  color="primary"
                  fullWidth
                  className="submit__button"
                >
                  {" "}
                  LogIn
                </Button>
              </Grid>
            </Grid>
            <div className="alreadyMember">
              <Grid item xs={10} md={10} lg={7} justifyContent="space-around">
                <Typography variant="subtitle1">New to HU Taxer?
                  <Link
                    to="/signup"
                    style={{
                      textDecoration: "none",
                      color: "#202DBF",
                      fontWeight: "bolder",
                      marginTop:"1rem"
                    }}
                  >
                    {" "}
                    Create new Account
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
