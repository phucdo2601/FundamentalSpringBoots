import { IconAnchor, IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import SignUpComp from "../SignUpLogin/SignUpComp";
import LoginComp from "../SignUpLogin/LoginComp";
import { Button } from "@mantine/core";

const SignUpPage = () => {
  const location = useLocation();

  const navigate = useNavigate();

  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-800 font-['poppins'] p-4 overflow-hidden relative">
        <Button
          size="sm"
          leftSection={<IconArrowLeft />}
          color="brightSun.4"
          variant="light"
          onClick={() => navigate("/")}
          className="!absolute left-5 z-10"
        >
          Home
        </Button>
        <div
          className={`w-[100vw] h-[100vh] transition-all ease-in-out flex [&>*]:flex-shrink-0 ${location.pathname == "/signup" ? "-translate-x-1/2" : "translate-x-0"} `}
        >
          <LoginComp />
          <div
            className={`w-1/2 h-full transition-all duration-1000 ease-in-out ${location.pathname == "/signup" ? "rounded-r-[200px]" : "rounded-l-[200px]"}  bg-mine-shaft-600 flex items-center gap-5 justify-center flex-col`}
          >
            <div className="flex gap-1 items-center text-bright-sun-400">
              <IconAnchor className="h-16 w-16" stroke={2.5} />
              <div className="text-2xl font-semibold">iJobs</div>
            </div>
            <div className="text-2xl text-mine-shaft-200 font-semibold">
              Find the mate job for you
            </div>
          </div>
          <SignUpComp />
        </div>
      </div>
    </>
  );
};

export default SignUpPage;
