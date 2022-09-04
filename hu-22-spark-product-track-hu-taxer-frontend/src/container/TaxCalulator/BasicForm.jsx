import React, { useState, useEffect } from "react";
import { Card, CardContent, Box } from "@material-ui/core";
import { Grid } from "@mui/material";
import axios from "axios";

import CircularProgress from "@mui/material/CircularProgress";

import { Controller, useFormContext } from "react-hook-form";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";

import "./styles.css";

export default function BasicForm() {
  const { control } = useFormContext();
  const [year, setYear] = React.useState("");
  const [sex, setSex] = React.useState("");
  const [age, setAge] = React.useState("");

  const [userData, setUserData] = useState();

  useEffect(() => {
    async function fetchData() {
      const emailFromLocalStorage = localStorage.getItem("email");
      let data = await axios.get(
        `https://hu-taxer-backend-urtjok3rza-wl.a.run.app/getUser?email=${emailFromLocalStorage}`
      );
      setUserData(data.data);
    }
    fetchData();
  }, []);

  const handleChange = (event) => {
    setYear(event.target.value);
  };

  const handleAgeChange = (event) => {
    setAge(event.target.value);
  };

  const handleGenderChange = (event) => {
    setSex(event.target.value);
  };
  if (!userData) {
    return (
      <div>
        <Card
          style={{
            maxWidth: 1000,
            margin: "1rem auto",
            padding: "5rem 5rem",
            height: "90vh",
          }}
        >
          <CardContent>
            <Box sx={{ display: "flex" }}>
              <CircularProgress />
            </Box>
          </CardContent>
        </Card>
      </div>
    );
  }
  return (
    <>
      {userData.userId !== "" && (
        <div className="basic__details">
          <Card
            style={{
              maxWidth: 1000,
              margin: "1rem auto",
              padding: "0px 2rem",
            }}
          >
            <CardContent>
              <Grid container spacing={2}>
                <Controller
                  control={control}
                  name="year"
                  render={({ field }) => (
                    <Grid xs={8} md={8} item>
                      <div className="financial_year">
                        <FormControl>
                          <FormLabel id="demo-controlled-radio-buttons-group">
                            <p className="BasicQs">
                              Which Financial Year do you want to calculate
                              taxes for?
                            </p>
                          </FormLabel>
                          <RadioGroup
                            aria-labelledby="demo-controlled-radio-buttons-group"
                            name="controlled-radio-buttons-group"
                            value={year}
                            defaultValue={userData.userDetails.year}
                            onChange={handleChange}
                            {...field}
                          >
                            <FormControlLabel
                              value="2022"
                              control={<Radio />}
                              label="FY 2022-2023 (Return to be filed between 1st April 2023 - 31st March 2024)"
                            />
                            <FormControlLabel
                              value="2021"
                              control={<Radio />}
                              label="FY 2021-2022 (Return to be filed between 1st April 2022 - 31st March 2023)"
                            />
                          </RadioGroup>
                        </FormControl>
                      </div>
                    </Grid>
                  )}
                />
                <Controller
                  control={control}
                  name="sex"
                  render={({ field }) => (
                    <Grid xs={8} item>
                      <div className="gender">
                        <FormControl>
                          <FormLabel id="demo-row-controlled-radio-buttons-group">
                            <p className="BasicQs">Gender</p>
                          </FormLabel>
                          <RadioGroup
                            aria-labelledby="demo-controlled-radio-buttons-group"
                            name="controlled-radio-buttons-group"
                            value={sex}
                            defaultValue={userData.userDetails.sex}
                            onChange={handleGenderChange}
                            {...field}
                          >
                            <FormControlLabel
                              value="female"
                              control={<Radio />}
                              label="Female"
                            />
                            <FormControlLabel
                              value="male"
                              control={<Radio />}
                              label="Male"
                            />
                            <FormControlLabel
                              value="transgender"
                              control={<Radio />}
                              label="Transgender"
                            />
                          </RadioGroup>
                        </FormControl>
                      </div>
                    </Grid>
                  )}
                />
                <Controller
                  control={control}
                  name="age"
                  render={({ field }) => (
                    <Grid xs={8} item>
                      <div className="age">
                        <FormControl>
                          <FormLabel id="demo-row-controlled-radio-buttons-group">
                            <p className="BasicQs">Age</p>
                          </FormLabel>
                          <RadioGroup
                            aria-labelledby="demo-controlled-radio-buttons-group"
                            name="controlled-radio-buttons-group"
                            value={age}
                            onChange={handleAgeChange}
                            defaultValue={userData.userDetails.age}
                            {...field}
                          >
                            <FormControlLabel
                              value="59"
                              control={<Radio />}
                              label="Below 60yrs"
                            />
                            <FormControlLabel
                              value="62"
                              control={<Radio />}
                              label="61yr-80yr"
                            />
                            <FormControlLabel
                              value="82"
                              control={<Radio />}
                              label="81yr & above"
                            />
                          </RadioGroup>
                        </FormControl>
                      </div>
                    </Grid>
                  )}
                />
              </Grid>
            </CardContent>
          </Card>
        </div>
      )}
    </>
  );
}
