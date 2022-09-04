import { useState } from "react";
import { Link, Navigate } from "react-router-dom";
import { Button, Card, CardContent, Grid, InputLabel, TextField, Typography } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({
    palette: {
        primary: {
            main: '#202DBF',
        }
    },
});

export default function ForgotPassword() {
    const [isClicked, setClicked] = useState<boolean>(false);
    const [error, setError] = useState<string>("");
    const [email, setEmail] = useState<string>("");
    const [emailerror, setEmailerror] = useState<{ invalid: string, required: string }>();
    const [password, setPassword] = useState<string>("");
    const [passerror, setPasserror] = useState<{ passlength: string, required: string, invalid: string }>();
    const updatePasswordUrl = 'https://hu-taxer-backend-urtjok3rza-wl.a.run.app/forgotPassword';
    const axios = require('axios');

    

    async function handleForgotPassword() {
    setError("");
    setEmailerror({ invalid: '', required: '' });
    if (email === "") {
      return setEmailerror({ invalid: '', required: 'this field is required' });
    }
    setEmailerror({ invalid: '', required: '' });
    if (!/\S+@\S+\.\S+/.test(email)) {
      return setEmailerror({ invalid: 'enter a valid Email', required: '' });
    }
    setPasserror({ passlength: '', required: '', invalid: '' });
    if (password === "") {
      return setPasserror({ passlength: '', required: 'this field is required', invalid: '' });
    }
    setPasserror({ passlength: '', required: '', invalid: '' });
    if (password.length < 8) {
      return setPasserror({ passlength: 'Password must have atleast 8 characters', required: '', invalid: '' });
    }
    setPasserror({ passlength: '', required: '', invalid: '' });
    if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/.test(password)) {
      return setPasserror({ passlength: '', required: '', invalid: 'must contain at least 8-20 characters,one digit,one upper case alphabet,one lower case alphabet, one special character which includes !@#$%&*()-+=^ and must not contain any white space.' });
    }
        await axios.put(`${updatePasswordUrl}?email=${email}&pass=${password}`)
        .then(() => {
            setClicked(true);
            return <Navigate to="/login" />;
          })
        .catch((errors: any)=> { 
            setError(errors.response.data.Error);            
            // console.log(errors.response.data.Error);
            // console.log(error);
          })
          
    }
    if(isClicked){
        return <Navigate to="/login" />;
    }

    return (
        <div>
            <ThemeProvider theme={theme}>
                <Grid p={{ xs: 1, sm: 12, md: 2, lg: 30 }} container style={{ backgroundColor: '#202DBF', justifyItems: 'center', height: '100vh', justifyContent: 'space-around' }} >

                    <Grid item lg={6} md={6} sm={12} xs={12} >
                        <Card style={{ borderRadius: '40px' }} >
                            <CardContent  >
                                <Grid container direction="column" justifyContent="space-around" >
                                    <Grid item lg={12} md={12} sm={12} xs={12}>
                                        <Typography variant="h4"> <b>Forgot Password?</b></Typography>
                                        {error && <p style={{color:'red', alignContent:'center'}} >{error}</p>}
                                    </Grid>

                                    <form >
                                        <Grid item lg={12} md={12} sm={12} xs={12}>
                                        <p className="income_form_fields">Useremail</p>
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

                                        <Grid item lg={12} md={12} sm={12} xs={12}>
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
                                            />
                                        </Grid>

                                        <Grid style={{ marginTop: "1rem" }} item lg={12} md={12} sm={12} xs={12}>
                                            {/* <Link to="/login" style={{textDecoration:"none"}}> */}
                                                <Button onClick={handleForgotPassword} variant="contained" color="primary" fullWidth >Update Password</Button>
                                            {/* </Link> */}
                                        </Grid>

                                    </form>
                                </Grid>
                            </CardContent>
                        </Card>
                    </Grid>
                </Grid>
            </ThemeProvider>
        </div>
    );
}