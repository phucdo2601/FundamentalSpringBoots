import {
  Box,
  Button,
  Container,
  createTheme,
  CssBaseline,
  TextField,
  ThemeProvider,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import CopyRightComp from "./CopyRightComp";
import { LoginFormRequestDto } from "../models/request/LoginFormRequestDto";
import AuthApi from "../api/AuthApi";
import { toast } from "react-toastify";
import axios from "axios";

const SignInFormComp = () => {
  const defaultTheme = createTheme();

  const [formLogin, setFormLogin] = useState<LoginFormRequestDto>({
    username: "",
    password: "",
  });

  const handleChangeInput = (event: any) => {
    const { name, value } = event.target;
    setFormLogin({
      ...formLogin,
      [name]: value,
    });
  };

  const handleSubmit = (event: any) => {
    event.preventDefault();
    console.log(formLogin);

    AuthApi.login(formLogin)
      .then((res) => {
        toast.success("Login successful!");
        console.log(res.data);
      })
      .catch((err: any) => {
        toast.error("Invalid credentials!");
      });

    // await axios
    //   .post("http://localhost:8084/api/api/v1/auth/general-login", formLogin)
    //   .then((res) => {
    //     toast.success("Login successful!");
    //     console.log(res.data);
    //   })
    //   .catch((err: any) => {
    //     toast.error("Invalid credentials!");
    //   });
  };

  return (
    <>
      <ThemeProvider theme={defaultTheme}>
        <Container component={`main`} maxWidth={`xs`}>
          <Typography variant="subtitle1" gutterBottom>
            Login Form
          </Typography>

          <CssBaseline />
          <form onSubmit={handleSubmit}>
            <Box>
              <TextField
                margin="normal"
                fullWidth
                name="username"
                id="username"
                autoFocus
                value={formLogin.username}
                onChange={handleChangeInput}
              />

              <TextField
                margin="normal"
                fullWidth
                name="password"
                id="password"
                value={formLogin.password}
                onChange={handleChangeInput}
              />

              <Button type="submit">Sign In</Button>
            </Box>
          </form>
          <CopyRightComp sx={{ mt: 8, mb: 4 }} />
        </Container>
      </ThemeProvider>
    </>
  );
};

export default SignInFormComp;
