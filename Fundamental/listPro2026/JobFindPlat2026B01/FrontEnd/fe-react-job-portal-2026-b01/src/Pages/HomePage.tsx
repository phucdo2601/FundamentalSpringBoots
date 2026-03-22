import React from "react";
import Header from "../Header/Header";
import DreamJob from "../LandingPage/DreamJob";
import Companies from "../LandingPage/Companies";
import JobCategories from "../LandingPage/JobCategories";
import Working from "../LandingPage/Working";
import Testimonials from "../LandingPage/Testimonials";
import Subscribe from "../LandingPage/Subscribe";
import Footer from "../Footer/Footer";

const HomePage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins']">
        <Header />
        <DreamJob />
        <Companies />
        <JobCategories />
        <Working />
        <Testimonials />
        <Subscribe />
        <Footer />
      </div>
    </>
  );
};

export default HomePage;
