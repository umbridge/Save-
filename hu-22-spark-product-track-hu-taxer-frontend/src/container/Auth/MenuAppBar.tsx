import * as React from "react";
import Box from "@mui/material/Box";
import Menu from "@mui/material/Menu";
import { Link } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import MenuItem from "@mui/material/MenuItem";
import logoicon from "../../assets/logoicon.png";
import IconButton from "@mui/material/IconButton";
import AccountCircle from "@mui/icons-material/AccountCircle";
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#202DBF',
    }
  },
});

export default function MenuAppBar() {
  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

  const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleLogout = () => {
    localStorage.removeItem("token");
  };

  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ flexGrow: 1 }} color="primary">
        <AppBar position="static">
          <Toolbar style={{ justifyContent: "space-between" }}>
            <img src={logoicon} style={{ height: "4rem" }} />

            {localStorage.getItem("token") && (
              <div >
                <IconButton
                  size="large"
                  onClick={handleMenu}
                  color="inherit"
                >
                  <AccountCircle />
                </IconButton>
                <Menu
                  id="menu-appbar"
                  anchorEl={anchorEl}
                  anchorOrigin={{
                    vertical: "bottom",
                    horizontal: "right",
                  }}
                  keepMounted
                  transformOrigin={{
                    vertical: "top",
                    horizontal: "right",
                  }}
                  open={Boolean(anchorEl)}
                  onClose={handleClose}
                >
                  <Link to="/login" style={{ color: "black", textDecoration: "none" }}>
                    <MenuItem onClick={handleLogout}>Logout</MenuItem>
                  </Link>
                </Menu>

              </div>
            )}



          </Toolbar>
        </AppBar>
      </Box>
    </ThemeProvider>
  );
}
