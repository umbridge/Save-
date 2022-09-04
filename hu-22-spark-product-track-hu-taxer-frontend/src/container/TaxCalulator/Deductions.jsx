import React, { useState, useEffect } from "react";
import { TextField, Card, CardContent, Box } from "@material-ui/core";
import { Grid } from "@mui/material";
import axios from "axios";
import CircularProgress from "@mui/material/CircularProgress";
import { Controller, useFormContext } from "react-hook-form";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import IBtn from "../../components/IBtn";

import { useRef } from "react";
import "./styles.css";

export default function Deductions({ scrollClass }) {
  const { control } = useFormContext();
  const [metroCity, setmetroCity] = React.useState("female");
  const [userData, setUserData] = useState();

  const handleMetroCityChange = (event) => {
    setmetroCity(event.target.value);
  };

  const section80C_Scroll = useRef(null);
  const section10_Scroll = useRef(null);
  const section24_Scroll = useRef(null);
  const OtherDeductions_Scroll = useRef(null);
  const deductions__Container_Scroll = useRef(null);

  

  const scrollToSection = (elementRef) => {
    window.scrollTo({
      top: elementRef.current.offsetTop,
      behavior: "smooth",
    });
  };
  useEffect(() => {
    if (section80C_Scroll.current) {
      scrollClass === "Section80C"
        ? scrollToSection(section80C_Scroll)
        : scrollClass === "Section10"
        ? scrollToSection(section10_Scroll)
        : scrollClass === "Section24"
        ?scrollToSection(section24_Scroll)
        :scrollClass==="OtherDeductions"
        ?scrollToSection(OtherDeductions_Scroll)
        :scrollToSection(deductions__Container_Scroll);
    }
  });
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
      <Card
        style={{
          maxWidth: 1000,
          margin: "1rem auto",
          padding: "0px 30px",
        }}
        className="deductions__Container"
        ref={deductions__Container_Scroll}
      >
        <CardContent>
          <div className="ibtn">
            <p
              ref={section80C_Scroll}
              className="deductions_sub_heads section80C_Scroll"
            >
              Under Section 80C
            </p>
            <div className="ibtnIcon">
              <IBtn information="Max Limit 1.5Lacs" />
            </div>
          </div>

          <hr />
          <Grid container spacing={2} className="section80C__container">
            <Controller
              control={control}
              name="elss"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      Investment under equity saving scheme (u/s 80CCG)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="limit of 10% * gross income" />
                    </div>
                  </div>

                  <TextField
                    name="elss"
                    fullWidth
                    variant="outlined"
                    size="small"
                    defaultValue={userData.userDeductions.section80C.elss}
                    {...field}
                  />
                </Grid>
              )}
            />

            <Controller
              control={control}
              name="employeeEpfContri"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text"> Employee’s contribution towards EPF</p>
                    <div className="ibtnIcon">
                      <IBtn information="tax-exempted up to 12% of basic salary" />
                    </div>
                  </div>

                  <TextField
                    name="employeeEpfContri"
                    variant="outlined"
                    fullWidth
                    defaultValue={
                      userData.userDeductions.section80C.employeeEpfContri
                    }
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="fd"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">5 Years fixed deposit</p>
                  <TextField
                    name="fd"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.fd}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="homeLoanPrincipal"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Home Loan Principal Repayment
                  </p>
                  <TextField
                    name="homeLoanPrincipal"
                    variant="outlined"
                    fullWidth
                    defaultValue={
                      userData.userDeductions.section80C.homeLoanPrincipal
                    }
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />

            <Controller
              control={control}
              name="lic"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Life Insurance premium paid
                  </p>
                  <TextField
                    name="lic"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.lic}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="ulip"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">Contribution toward ULIP</p>
                  <TextField
                    name="ulip"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.ulip}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="nsc"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Investment in NSC (VIII issue) + Interest
                  </p>
                  <TextField
                    name="nsc"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.nsc}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />

            <Controller
              control={control}
              name="employeeContributionToEPF"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Contribution toward provident fund / PPF
                  </p>
                  <TextField
                    name="businessIncome"
                    variant="outlined"
                    fullWidth
                    defaultValue={
                      userData.userDeductions.section80C.businessIncome
                    }
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="ssy"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Deposit with Sukanya Samriddhi Accounts
                  </p>
                  <TextField
                    name="ssy"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.ssy}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="tutionFees"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">
                    Tuition fees paid for children
                  </p>
                  <TextField
                    name="tutionFees"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.tutionFees}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="nps_80c"
              render={({ field }) => (
                <Grid xs={12} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Employee's / Self-employed contribution toward NPS (up to
                      20%) (u/s 80CCD)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="max limit 50k" />
                    </div>
                  </div>

                  <TextField
                    name="nps_80c"
                    variant="outlined"
                    fullWidth
                    defaultValue={userData.userDeductions.section80C.nps_80c}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
          </Grid>
        </CardContent>

        {/* *****************Under Section 10******************** */}
        <CardContent>
          <p ref={section10_Scroll} className="deductions_sub_heads">
            Under Section 10
          </p>
          <hr />
          <Grid container spacing={2}>
            <Controller
              control={control}
              name="childEducationAllowance"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">Child Education allowance</p>
                    <div className="ibtnIcon">
                      <IBtn information=" up to INR 100/child/month for a maximum of two children" />
                    </div>
                  </div>

                  <TextField
                    name="childEducationAllowance"
                    fullWidth
                    variant="outlined"
                    size="small"
                    defaultValue={
                      userData.userDeductions.section10.childEducationAllowance
                    }
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="childHostelAllowance"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">Child Hostel Allowance</p>
                    <div className="ibtnIcon">
                      <IBtn information="  up to INR 300/child/month for a maximum of two children" />
                    </div>
                  </div>

                  <TextField
                    name="childHostelAllowance"
                    variant="outlined"
                    fullWidth
                    size="small"
                    defaultValue={
                      userData.userDeductions.section10.childHostelAllowance
                    }
                    {...field}
                  />
                </Grid>
              )}
            />
          </Grid>
          <p className="income_form_fields sub-heading">HRA</p>
          <Grid container spacing={2}>
            <Controller
              control={control}
              name="hra"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Actual House Rent Allowance received
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="The limit of exemption allowed is min ( 50% * salary [metro city], HRA received, Rent paid in excess of 10% of the salary of the employee" />
                    </div>
                  </div>

                  <TextField
                    name="hra"
                    fullWidth
                    variant="outlined"
                    size="small"
                    defaultValue={userData.userDeductions.section10.hra}
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="actualRentPaid"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text"> Actual Rent paid</p>
                    <div className="ibtnIcon">
                      <IBtn information="minus 10% of salary" />
                    </div>
                  </div>

                  <TextField
                    name="actualRentPaid"
                    variant="outlined"
                    {...field}
                    fullWidth
                    defaultValue={
                      userData.userDeductions.section10.actualRentPaid
                    }
                    size="small"
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="tutionFees"
              render={({ field }) => (
                <Grid item>
                  <FormControl>
                    <FormLabel id="demo-row-controlled-radio-buttons-group">
                      <p className="BasicQs">
                        Do you live in Metro City (Mumbai, Chennai, Kolkata,
                        Delhi)
                      </p>
                    </FormLabel>
                    <RadioGroup
                      row
                      aria-labelledby="demo-controlled-radio-buttons-group"
                      name="controlled-radio-buttons-group"
                      value={metroCity}
                      onChange={handleMetroCityChange}
                      defaultValue={userData.userDeductions.section10.metro}
                    >
                      <FormControlLabel
                        value="true"
                        control={<Radio />}
                        label="True"
                      />
                      <FormControlLabel
                        value="false"
                        control={<Radio />}
                        label="False"
                      />
                    </RadioGroup>
                  </FormControl>
                </Grid>
              )}
            />
          </Grid>

          <div className="income_form_fields ibtn sub-heading">
            <p className="text">Leave Travel Allowance</p>
            <div className="ibtnIcon">
              <IBtn information="(Max limit 50000, taxable on provided-spent" />
            </div>
          </div>
          <Grid container spacing={2}>
            <Grid xs={12} item>
              <Controller
                control={control}
                name="lta"
                render={({ field }) => (
                  <Grid item>
                    <div className="income_form_fields ibtn">
                      <p className="text">Amount</p>
                      <div className="ibtnIcon">
                        <IBtn information="Enter 0 If you have claimed it atleast two times in last four years" />
                      </div>
                    </div>

                    <TextField
                      name="lta"
                      variant="outlined"
                      {...field}
                      fullWidth
                      defaultValue={userData.userDeductions.section10.lta}
                      size="small"
                    />
                  </Grid>
                )}
              />
            </Grid>
          </Grid>
        </CardContent>
        {/* ***************Under Section 24************** */}
        <CardContent>
          <div className="ibtn">
            <p ref={section24_Scroll} className="deductions_sub_heads">
              Under Section 24
            </p>
            <div className="ibtnIcon">
              <IBtn information="Max Limit 2Lacs" />
            </div>
          </div>
          <hr />
          <Grid container spacing={2}>
            <Controller
              control={control}
              name="rent"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">Rent of Property</p>
                  <TextField
                    name="rent"
                    placeholder="0"
                    fullWidth
                    variant="outlined"
                    defaultValue={userData.userDeductions.section24.rent}
                    size="small"
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="propertyTax"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <p className="income_form_fields">Property Tax</p>
                  <TextField
                    name="propertyTax"
                    variant="outlined"
                    fullWidth
                    size="small"
                    defaultValue={userData.userDeductions.section24.propertyTax}
                    {...field}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="interest"
              render={({ field }) => (
                <Grid xs={12} item>
                  <p className="income_form_fields">
                    Interest on Home loan taken
                  </p>
                  <TextField
                    name="interest"
                    fullWidth
                    variant="outlined"
                    size="small"
                    defaultValue={userData.userDeductions.section24.interest}
                    {...field}
                  />
                </Grid>
              )}
            />
            {/* <Controller
                control={control}
                name="lossfromHouseProperty"
                render={({ field}) => (
                  <Grid xs={12} sm={6} item>
                    <div className="income_form_fields ibtn">
                      <p className="text"> Loss from House Property</p>
                      <div className="ibtnIcon">
                        <IBtn information=" rent-property tax - 30% of rent - interest" />
                      </div>
                    </div>
                    {console.log(lossfromHousePropertyVal)}
                    {
                      
                    }
                    <TextField
                      name="lossfromHouseProperty"
                      variant="outlined"
                      placeholder="We will Calculate it"
                      fullWidth
                      defaultValue={lossfromHousePropertyVal}
                      
                      size="small"
                    />
                  </Grid>
                )}
              /> */}
          </Grid>
        </CardContent>
        {/* ****************Other Deductions***************** */}
        <CardContent>
          <p ref={OtherDeductions_Scroll} className="deductions_sub_heads">
            Other Deductions
          </p>
          <hr />
          <Grid container spacing={2}>
            <Controller
              control={control}
              name="medicalInsurance"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text"> Medical Insurance premium (u/s 80D)</p>
                    <div className="ibtnIcon">
                      <IBtn information=" tax-exempted upto 25k" />
                    </div>
                  </div>

                  <TextField
                    name="medicalInsurance"
                    {...field}
                    fullWidth
                    size="small"
                    defaultValue={userData.userDeductions.medicalInsurance}
                    variant="outlined"
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="additionNps"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Additional contribution towards NPS [u/s 80CCD(1B)]
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="max deduction of 50k and is independent of exemptions under Sec 80 C" />
                    </div>
                  </div>

                  <TextField
                    name="additionNps"
                    variant="outlined"
                    {...field}
                    fullWidth
                    defaultValue={userData.userDeductions.additionNps}
                    size="small"
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="employerEpfContri"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text"> Employer's contribution toward EPF</p>
                    <div className="ibtnIcon">
                      <IBtn information="Tax-exempted up to 12% of basic salary" />
                    </div>
                  </div>

                  <TextField
                    name="employerEpfContri"
                    {...field}
                    fullWidth
                    defaultValue={userData.userDeductions.employerEpfContri}
                    variant="outlined"
                    size="small"
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="charityDonation"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text"> Donations (u/s 80G)</p>
                    <div className="ibtnIcon">
                      <IBtn information="max limit is 10% of gross income out of which 50% amount is tax exempted" />
                    </div>
                  </div>

                  <TextField
                    name="charityDonation"
                    variant="outlined"
                    {...field}
                    fullWidth
                    defaultValue={userData.userDeductions.charityDonation}
                    size="small"
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="employerNpsContri"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Employer's contribution toward NPS (u/s 80CCD)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="deduction of  10% of their annual income up to maximum of Rs 1.5 Lakhs" />
                    </div>
                  </div>

                  <TextField
                    name="employerNpsContri"
                    {...field}
                    fullWidth
                    variant="outlined"
                    size="small"
                    defaultValue={userData.userDeductions.employerNpsContri}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="educationLoanInterest"
              render={({ field }) => (
                <Grid xs={12} sm={6} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Interest on loan for higher education (u/s 80E)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="No max limit, 100% tax-exempted" />
                    </div>
                  </div>

                  <TextField
                    name="educationLoanInterest"
                    variant="outlined"
                    {...field}
                    fullWidth
                    defaultValue={userData.userDeductions.educationLoanInterest}
                    size="small"
                  />
                </Grid>
              )}
            />

            <Controller
              control={control}
              name="savingAccountInterest"
              render={({ field }) => (
                <Grid xs={12} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Interest on deposits in saving account (u/s 80TTA)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="tax-exempted upto 10k" />
                    </div>
                  </div>

                  <TextField
                    name="savingAccountInterest"
                    variant="outlined"
                    {...field}
                    fullWidth
                    size="small"
                    defaultValue={userData.userDeductions.savingAccountInterest}
                  />
                </Grid>
              )}
            />
            <Controller
              control={control}
              name="HomeLoanInterest"
              render={({ field }) => (
                <Grid xs={12} item>
                  <div className="income_form_fields ibtn">
                    <p className="text">
                      {" "}
                      Interest on loan taken for Residential House (u/s 80EE)
                    </p>
                    <div className="ibtnIcon">
                      <IBtn information="max deduction of 50k For loan amount of up to Rs.35 lakh and for property value of up to Rs.50 lakh" />
                    </div>
                  </div>

                  <TextField
                    name="homeLoanInterest"
                    variant="outlined"
                    {...field}
                    fullWidth
                    defaultValue={userData.userDeductions.homeLoanInterest}
                    size="small"
                  />
                </Grid>
              )}
            />
          </Grid>
        </CardContent>
      </Card>
    </>
  );
}
