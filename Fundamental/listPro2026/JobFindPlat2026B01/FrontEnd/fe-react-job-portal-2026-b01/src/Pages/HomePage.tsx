import React from "react";
import Header from "../Header/Header";
import DreamJob from "../LandingPage/DreamJob";
import Companies from "../LandingPage/Companies";
import JobCategories from "../LandingPage/JobCategories";

const HomePage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins']">
        <Header />
        <DreamJob />
        <Companies />
        <JobCategories />
      </div>
    </>
  );
};

export default HomePage;
