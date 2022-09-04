import React, { useState } from "react";
import { Button, Card, CardContent } from "@material-ui/core";
import axios from "axios";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import MuiAlert from "@material-ui/lab/Alert";

import SummaryImg from "../../assets/SummaryImg.gif";
import editBtn from "../../assets/write.png";
import "./styles.css";
function Alert(props) {
  return (
    <MuiAlert
      elevation={4}
      variant="filled"
      style={{ marginTop: ".5rem" }}
      {...props}
    />
  );
}

export default function Summary({ setActiveStep, activeStep, setScrollClass }) {
  const [oldTaxRegime, setoldTaxRegime] = useState("");
  const [Deductions, setDeductions] = useState("");
  const [GrossTotalIncome, setGrossTotalIncome] = useState("");
  const [newTaxRegime, setnewTaxRegime] = useState("");
  const [suggestions, setSuggestions] = useState("");

  const [EducationCessNewRegime, setEducationCessNewRegime] = useState("");
  const [EducationCessOldRegime, setEducationCessOldRegime] = useState("");
  const [FinalOldTax, setFinalOldTax] = useState(0);
  const [FinalNewRegimeTax, setFinalNewRegimeTax] = useState(0);
  const [isCalculated, setIsCalculated] = useState(false);
  const emailFromLocalStorage = localStorage.getItem("email");
  const token = localStorage.getItem("token");

  const handleGetResults = async (e) => {
    const res = await axios({
      method: "get",
      url: `https://hu-taxer-backend-urtjok3rza-wl.a.run.app/taxCalculate/?email=${emailFromLocalStorage}`,
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    });
    setoldTaxRegime(res.data.OldTaxRegime);
    setnewTaxRegime(res.data.NewTaxRegime);
    setSuggestions(res.data.suggestion);
    setDeductions(res.data.Deductions);
    setGrossTotalIncome(res.data.GrossSalary);
    setEducationCessOldRegime(res.data.EducationCessOldRegime);
    setEducationCessNewRegime(res.data.EducationCessNewRegime);
    setFinalNewRegimeTax(res.data.FinalNewRegimeTax);
    setFinalOldTax(res.data.FinalOldTax);
    setIsCalculated(true);
  };

  const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
      fontSize: 14,
    },
  }));

  const StyledTableRow = styled(TableRow)(({ theme }) => ({
    "&:nth-of-type(odd)": {
      backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    "&:last-child td, &:last-child th": {
      border: 0,
    },
  }));

  function createData(name, calories, fat) {
    return { name, calories, fat };
  }

  const rows = [
    createData("Gross Total Income", GrossTotalIncome, GrossTotalIncome),
    createData("Deductions", Deductions, 0),
    createData("Tax due on above", oldTaxRegime, newTaxRegime),
    createData(
      "Educational Cess",
      EducationCessOldRegime,
      EducationCessNewRegime
    ),
    createData("Total Tax", FinalOldTax, FinalNewRegimeTax),
  ];

  const handleModifyDeductions = (scrollClassName) => {
    setActiveStep(activeStep - 1);
    console.log(scrollClassName);
    setScrollClass(scrollClassName);
  };

  return (
    <>
   
      <Card
        style={{
          minWidth: 1000,
          maxWidth: 1000,
          margin: "1rem auto",
          padding: "0px 30px",
        }}
      >
        <CardContent>
          {!isCalculated && (
            <div className="not_calculated">
              <img src={SummaryImg} alt="loading" className="summary__img" />
              <Button
                variant="contained"
                color="primary"
                style={{ marginTop: "2rem" }}
                onClick={handleGetResults}
              >
                Calculate
              </Button>
            </div>
          )}
          {isCalculated && (
            <div>
              {FinalNewRegimeTax >= FinalOldTax ? (
                <Alert severity="success">
                  <b>
                    Suggestion: You should opt for New Regime as it allows you
                    to save ₹{(FinalNewRegimeTax - FinalOldTax).toFixed(2)} as
                    compared to Old Regime.
                  </b>
                  {console.log(FinalNewRegimeTax.toFixed(2))}
                </Alert>
              ) : (
                <Alert severity="success">
                  <b>
                    Suggestion: You should opt for Old Regime as it allows you
                    to save ₹{(FinalOldTax - FinalNewRegimeTax).toFixed(2)} as
                    compared to New Regime.
                  </b>
                </Alert>
              )}
              <br />
              <TableContainer component={Paper}>
                <Table sx={{ mWidth: 700 }} aria-label="customized table">
                  <TableHead>
                    <TableRow>
                      <StyledTableCell align="right"></StyledTableCell>
                      <StyledTableCell align="center">
                        Old Regime
                      </StyledTableCell>
                      <StyledTableCell align="center">
                        New Regime
                      </StyledTableCell>
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {rows.map((row) => (
                      <StyledTableRow key={row.name}>
                        <StyledTableCell component="th" scope="row">
                          {row.name}
                        </StyledTableCell>
                        <StyledTableCell align="center">
                          ₹ {row.calories.toFixed(2)}
                        </StyledTableCell>
                        <StyledTableCell align="center">
                          ₹ {row.fat.toFixed(2)}
                        </StyledTableCell>
                      </StyledTableRow>
                    ))}
                  </TableBody>
                </Table>
              </TableContainer>
            </div>
          )}
        </CardContent>

        {isCalculated && (
          <CardContent>
            <h3>Suggestions for Old Regime</h3>
            <div>
              {suggestions.length !== 0
                ? suggestions.map((s) => (
                    <div>
                      <Alert severity="success">
                        <div className="innerSugg_container">
                          <div className="suggestion__Text">
                            <b>{s.message}</b>
                          </div>

                          <div className="Edit__btn">
                            <img
                              onClick={() => handleModifyDeductions(s.section)}
                              src={editBtn}
                              alt="Edit"
                              style={{ width: "7%" }}
                            />
                          </div>
                        </div>
                      </Alert>
                    </div>
                  ))
                : ""}
            </div>
          </CardContent>
        )}
      </Card>
    </>
  );
}
