import React, { useState, useEffect } from "react";
import { TextField, Card, CardContent, Box } from "@material-ui/core";
import { Grid } from "@mui/material";
import axios from "axios";
import CircularProgress from "@mui/material/CircularProgress";

import { Controller, useFormContext } from "react-hook-form";
import "./styles.css";

export default function IncomeDetails() {
  const { control } = useFormContext();
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

  if (!userData) {
    return (
      <div>
        <Card
          style={{
            minWidth: 800,
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
        <Card
          style={{
            maxWidth: 1000,
            margin: "1rem auto",
            padding: "0px 30px",
          }}
        >
          <CardContent>
            <Grid container spacing={2}>
              <Controller
                control={control}
                name="basicSalary"
                render={({ field }) => (
                  <Grid xs={12} sm={6} item>
                    <p className="income_form_fields">Basic Income</p>
                    <TextField
                      name="basicSalary"
                      placeholder="Enter your Basic Income"
                      fullWidth
                      variant="outlined"
                      size="small"
                      defaultValue={userData.userDetails.basicSalary}
                      {...field}
                    />
                  </Grid>
                )}
              />

              <Controller
                control={control}
                name="rentalIncome"
                render={({ field }) => (
                  <Grid xs={12} sm={6} item>
                    <p className="income_form_fields">Rental Income</p>
                    <TextField
                      name="rentalIncome"
                      variant="outlined"
                      placeholder="Enter your Rental Income"
                      fullWidth
                      size="small"
                      defaultValue={userData.userDetails.rentalIncome}
                      {...field}
                    />
                  </Grid>
                )}
              />
              <Controller
                control={control}
                name="businessIncome"
                render={({ field }) => (
                  <Grid xs={12} sm={6} item>
                    <p className="income_form_fields">Business Income</p>
                    <TextField
                      name="businessIncome"
                      variant="outlined"
                      placeholder="Enter your Business Income"
                      fullWidth
                      defaultValue={userData.userDetails.businessIncome}
                      size="small"
                      {...field}
                    />
                  </Grid>
                )}
              />
              <Controller
                control={control}
                name="capitalGains"
                render={({ field }) => (
                  <Grid xs={12} sm={6} item>
                    <p className="income_form_fields">Capital Gains</p>
                    <TextField
                      name="capitalGains"
                      variant="outlined"
                      placeholder="Enter your Capital Gains"
                      fullWidth
                      size="small"
                      defaultValue={userData.userDetails.capitalGains}
                      {...field}
                    />
                  </Grid>
                )}
              />
              <Controller
                control={control}
                name="otherIncome"
                render={({ field }) => (
                  <Grid xs={12} item>
                    <p className="income_form_fields">
                      Income From Other Sources
                    </p>
                    <TextField
                      name="otherIncome"
                      variant="outlined"
                      placeholder="Enter your Other Income"
                      fullWidth
                      size="small"
                      defaultValue={userData.userDetails.otherIncome}
                      {...field}
                    />
                  </Grid>
                )}
              />
            </Grid>
          </CardContent>
        </Card>
      )}
    </>
  );
}
