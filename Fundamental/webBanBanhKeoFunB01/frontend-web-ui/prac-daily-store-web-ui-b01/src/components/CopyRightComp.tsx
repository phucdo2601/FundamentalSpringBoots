import { Link, Typography } from "@mui/material";
import React from "react";

const CopyRightComp = (props: any) => {
  return (
    <>
      <Typography
        variant="body2"
        color={`text.secondary`}
        align="center"
        {...props}
      >
        {"Copyright © "}
        <Link color={`inherit`} href="#">
          Daily Product Shop
        </Link>

        {` `}
        {new Date().getFullYear()}
        {"."}
      </Typography>
    </>
  );
};

export default CopyRightComp;
