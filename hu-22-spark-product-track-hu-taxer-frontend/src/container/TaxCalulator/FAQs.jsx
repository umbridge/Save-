import React, { useEffect } from "react";
import { styled } from "@mui/material/styles";
import ArrowForwardIosSharpIcon from "@mui/icons-material/ArrowForwardIosSharp";
import MuiAccordion from "@mui/material/Accordion";
import MuiAccordionSummary from "@mui/material/AccordionSummary";
import MuiAccordionDetails from "@mui/material/AccordionDetails";
import Typography from "@mui/material/Typography";
import axios from "axios";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import "./styles.css";

const Accordion = styled((props) => (
  <MuiAccordion disableGutters elevation={0} square {...props} />
))(({ theme }) => ({
  border: `1px solid ${theme.palette.divider}`,
  "&:not(:last-child)": {
    borderBottom: 0,
  },
  "&:before": {
    display: "none",
  },
}));

const AccordionSummary = styled((props) => (
  <MuiAccordionSummary
    expandIcon={<ArrowForwardIosSharpIcon sx={{ fontSize: "0.9rem" }} />}
    {...props}
  />
))(({ theme }) => ({
  backgroundColor:
    theme.palette.mode === "dark"
      ? "rgba(255, 255, 255, .05)"
      : "rgba(0, 0, 0, .03)",
  flexDirection: "row-reverse",
  "& .MuiAccordionSummary-expandIconWrapper.Mui-expanded": {
    transform: "rotate(90deg)",
  },
  "& .MuiAccordionSummary-content": {
    marginLeft: theme.spacing(1),
  },
}));

const AccordionDetails = styled(MuiAccordionDetails)(({ theme }) => ({
  padding: theme.spacing(2),
  borderTop: "1px solid rgba(0, 0, 0, .125)",
}));

export default function FAQs() {
  const [expanded, setExpanded] = React.useState("panel1");
  const [FAQs, setFAQs] = React.useState();
  const handleChange = (panel) => (event, newExpanded) => {
    setExpanded(newExpanded ? panel : false);
  };
  useEffect(() => {
    async function fetchData() {
      let data = await axios.get(
        "https://hu-taxer-backend-urtjok3rza-wl.a.run.app/faq"
      );
     
      setFAQs(data.data);
    }
    fetchData();
  },[]);
  return (
    <div>
    
      <Card
        style={{
          maxWidth: 1000,
          margin: "1rem auto",
          padding: "0px 30px",
        }}
      >
        <CardContent>
          <h3 className="faq_head">Frequently Asked Questions</h3>
          <hr />
          <div>
            {FAQs
              ? FAQs.map((f) => (
                  <Accordion
                    expanded={expanded === "panel1"}
                    onChange={handleChange("panel1")}
                  >
                    <AccordionSummary
                      aria-controls="panel1d-content"
                      id="panel1d-header"
                    >
                      <Typography>{f.question}</Typography>
                    </AccordionSummary>
                    <AccordionDetails>
                      <Typography>
                        {f.answer}
                      </Typography>
                    </AccordionDetails>
                  </Accordion>
                ))
              : ""}
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
