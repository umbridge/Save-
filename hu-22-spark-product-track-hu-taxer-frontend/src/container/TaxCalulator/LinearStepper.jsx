import React, { useState } from "react";
import {
  Typography,
  Button,
  Stepper,
  Step,
  StepLabel,
} from "@material-ui/core";

import axios from "axios";
import { makeStyles } from "@material-ui/core/styles";

import { useForm, FormProvider } from "react-hook-form";
import "./styles.css";
import BasicForm from "./BasicForm";
import IncomeDetails from "./IncomeDetails";
import Deductions from "./Deductions";
import Summary from "./Summary";

const useStyles = makeStyles((theme) => ({
  button: {
    marginRight: theme.spacing(1),
  },
}));

function getSteps() {
  return ["Basic information", "Income Details", "Deductions", "Summary"];
}

const LinaerStepper = () => {
  const classes = useStyles();

  const [activeStep, setActiveStep] = useState(0);
  const [skippedSteps, setSkippedSteps] = useState([]);
  const [scrollClass, setScrollClass] = useState("section80C__container");
  const steps = getSteps();

  const isStepOptional = (step) => {
    return step === -1;
  };

  const isStepSkipped = (step) => {
    return skippedSteps.includes(step);
  };

  const handleNext = async (data) => {
    const emailFromLocalStorage = localStorage.getItem("email");
    if (activeStep === steps.length - 2) {
      await axios
        .get(
          `https://hu-taxer-backend-urtjok3rza-wl.a.run.app/getUser?email=${emailFromLocalStorage}`
        )
        .then(async (response) => {
          await axios({
            method: "put",
            url: "https://hu-taxer-backend-urtjok3rza-wl.a.run.app/updateUser",
            headers: {
              "Content-Type": "application/json",
            },
            data: {
              userFirstName: response.data.userFirstName,
              userLastName: response.data.userLastName,
              userName: response.data.userName,
              userEmail: response.data.userEmail,
              userCompany: response.data.userCompany,
              userPassword: response.data.userPassword,
              userDetails: {
                year: data.year ? data.year : response.data.userDetails.year,
                age: data.age ? data.age : response.data.userDetails.age,
                sex: data.sex ? data.sex : response.data.userDetails.sex,
                basicSalary: data.basicSalary
                  ? data.basicSalary
                  : response.data.userDetails.basicSalary,
                rentalIncome: data.rentalIncome
                  ? data.rentalIncome
                  : response.data.userDetails.rentalIncome,
                otherIncome: data.otherIncome
                  ? data.otherIncome
                  : response.data.userDetails.otherIncome,
                capitalGains: data.capitalGains
                  ? data.capitalGains
                  : response.data.userDetails.capitalGains,
                businessIncome: data.businessIncome
                  ? data.businessIncome
                  : response.data.userDetails.capitalGains,
              },
              userDeductions: {
                employerEpfContri: data.employerEpfContri
                  ? data.employerEpfContri
                  : response.data.userDeductions.employerEpfContri,
                additionNps: data.additionNps
                  ? data.additionNps
                  : response.data.userDeductions.additionNps,
                employerNpsContri: data.employerNpsContri
                  ? data.employerNpsContri
                  : response.data.userDeductions.employerNpsContri,
                medicalInsurance: data.medicalInsurance
                  ? data.medicalInsurance
                  : response.data.userDeductions.medicalInsurance,
                educationLoanInterest: data.educationLoanInterest
                  ? data.educationLoanInterest
                  : response.data.userDeductions.educationLoanInterest,
                savingAccountInterest: data.savingAccountInterest
                  ? data.savingAccountInterest
                  : response.data.userDeductions.savingAccountInterest,
                charityDonation: data.charityDonation
                  ? data.charityDonation
                  : response.data.userDeductions.charityDonation,
                section24: {
                  rent: data.rent,
                },
                section80C: {
                  ppf: data.ppf
                    ? data.ppf
                    : response.data.userDeductions.section80C.ppf,
                  employeeEpfContri: data.employeeEpfContri
                    ? data.employeeEpfContri
                    : response.data.userDeductions.section80C.employeeEpfContri,
                  nsc: data.nsc
                    ? data.nsc
                    : response.data.userDeductions.section80C.nsc,
                  elss: data.elss
                    ? data.elss
                    : response.data.userDeductions.section80C.elss,
                  ulip: data.ulip
                    ? data.ulip
                    : response.data.userDeductions.section80C.ulip,
                  lic: data.lic
                    ? data.lic
                    : response.data.userDeductions.section80C.lic,
                  fd: data.fd
                    ? data.fd
                    : response.data.userDeductions.section80C.fd,
                  ssy: data.ssy
                    ? data.ssy
                    : response.data.userDeductions.section80C.ssy,
                  homeLoanPrincipal: data.homeLoanPrincipal
                    ? data.homeLoanPrincipal
                    : response.data.userDeductions.section80C.homeLoanPrincipal,
                  tutionFees: data.tutionFees
                    ? data.tutionFees
                    : response.data.userDeductions.section80C.tutionFees,
                  nps_80c: data.nps_80c
                    ? data.nps_80c
                    : response.data.userDeductions.section80C.nps_80c,
                },
                section10: {
                  actualRentPaid: data.actualRentPaid
                    ? data.actualRentPaid
                    : response.data.userDeductions.section10.actualRentPaid,
                  hra: data.hr
                    ? data.hr
                    : response.data.userDeductions.section10.hra,
                  lta: data.lta
                    ? data.lta
                    : response.data.userDeductions.section10.lta,
                  childEducationAllowance: data.childEducationAllowance
                    ? data.childEducationAllowance
                    : response.data.userDeductions.section10
                        .childEducationAllowance,
                  childHostelAllowance: data.childHostelAllowance
                    ? data.childHostelAllowance
                    : response.data.userDeductions.section10
                        .childHostelAllowance,
                  otherRepay: data.otherRepay
                    ? data.otherRepay
                    : response.data.userDeductions.section10.otherRepay,
                  metro: data.metro
                    ? data.metro
                    : response.data.userDeductions.section10.metro,
                },
                homeLoanInterest: data.homeLoanInterest
                  ? data.homeLoanInterest
                  : response.data.userDeductions.homeLoanInterest,
              },
            },
          });
        });

      setActiveStep(activeStep + 1);
      setSkippedSteps(
        skippedSteps.filter((skipItem) => skipItem !== activeStep)
      );
    } else {
      setActiveStep(activeStep + 1);
      setSkippedSteps(
        skippedSteps.filter((skipItem) => skipItem !== activeStep)
      );
    }
  };

  const handleBack = () => {
    setActiveStep(activeStep - 1);
  };

  const handleSkip = () => {
    if (!isStepSkipped(activeStep)) {
      setSkippedSteps([...skippedSteps, activeStep]);
    }
    setActiveStep(activeStep + 1);
  };
  let methods = useForm();

  return (
    <div>
      <Stepper alternativeLabel activeStep={activeStep}>
        {steps.map((step, index) => {
          const labelProps = {};
          const stepProps = {};
          if (isStepOptional(index)) {
            labelProps.optional = (
              <Typography
                variant="caption"
                align="center"
                style={{ display: "block" }}
              >
                optional
              </Typography>
            );
          }
          if (isStepSkipped(index)) {
            stepProps.completed = false;
          }
          return (
            <Step {...stepProps} key={index}>
              <StepLabel {...labelProps}>{step}</StepLabel>
            </Step>
          );
        })}
      </Stepper>

      {activeStep === steps.length ? (
        <Typography variant="h3" align="center">
          Thank You
        </Typography>
      ) : (
        <>
          <FormProvider {...methods}>
            <form onSubmit={methods.handleSubmit(handleNext)}>
              
              {activeStep === 0 ? (
                <BasicForm />
              ) : activeStep === 1 ? (
                <IncomeDetails />
              ) : activeStep === 2 ? (
                <Deductions scrollClass={scrollClass}/>
              ) : (
                <Summary
                  setActiveStep={setActiveStep}
                  activeStep={activeStep}
                  setScrollClass={setScrollClass}

                />
              )}
              <Button
                className={classes.button}
                disabled={activeStep === 0}
                onClick={handleBack}
              >
                back
              </Button>
              {isStepOptional(activeStep) && (
                <Button
                  className={classes.button}
                  variant="contained"
                  color="primary"
                  onClick={handleSkip}
                >
                  skip
                </Button>
              )}
              {activeStep < steps.length - 1 && (
                <Button
                  className={classes.button}
                  variant="contained"
                  color="primary"
                  type="submit"
                >
                  Next
                </Button>
              )}
            </form>
          </FormProvider>
        </>
      )}
    </div>
  );
};

export default LinaerStepper;
