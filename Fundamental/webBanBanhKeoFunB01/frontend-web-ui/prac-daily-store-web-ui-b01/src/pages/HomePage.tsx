import { Button } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const HomePage = () => {
  const navigate = useNavigate();

  const handleChangeLoginPage = () => {
    navigate(`/sign-in`);
  };

  const handleChangeGenRole = () => {
    navigate(`/general-roles`);
  };

  return (
    <>
      <div>
        <Button onClick={handleChangeLoginPage}>Sign In Page</Button>
        <Button onClick={handleChangeGenRole}>General Roles</Button>
      </div>
    </>
  );
};

export default HomePage;
