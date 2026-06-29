import React from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Header from "../Header/Header";
import { Divider } from "@mantine/core";
import FindJobsPage from "./FindJobsPage";
import FindTalentPage from "./FindTalentPage";
import TalentProfilePage from "./TalentProfilePage";
import PostJobPage from "./PostJobPage";
import JobDescriptionPage from "./JobDescriptionPage";
import ApplyJobPage from "./ApplyJobPage";
import CompanyPage from "./CompanyPage";
import PostedJobPage from "./PostedJobPage";
import JobHistoryPage from "./JobHistoryPage";
import SignUpPage from "./SignUpPage";
import ProfilePage from "./ProfilePage";
import HomePage from "./HomePage";
import Footer from "../Footer/Footer";
import { useSelector } from "react-redux";

interface AppRoutesProps {
  user: any;
}

const AppRoutes = () => {
  const user = useSelector((state: any) => state.user);

  return (
    <>
      <BrowserRouter>
        <div className="relative">
          <Header />
          <Divider size={`xs`} mx={`md`} />
          <Routes>
            <Route path="/find-jobs" element={<FindJobsPage />} />
            <Route path="/find-talent" element={<FindTalentPage />} />
            <Route path="/talent-profile" element={<TalentProfilePage />} />
            <Route path="/post-job" element={<PostJobPage />} />
            <Route path="/jobs" element={<JobDescriptionPage />} />
            <Route path="/apply-job" element={<ApplyJobPage />} />
            <Route path="/company" element={<CompanyPage />} />
            <Route path="/posted-job" element={<PostedJobPage />} />
            <Route path="/job-history" element={<JobHistoryPage />} />
            <Route
              path="/signup"
              element={
                user ? (
                  <>
                    <Navigate to={`/`} />
                  </>
                ) : (
                  <>
                    <SignUpPage />
                  </>
                )
              }
            />
            <Route
              path="/login"
              element={
                user ? (
                  <>
                    <Navigate to={`/`} />
                  </>
                ) : (
                  <>
                    <SignUpPage />
                  </>
                )
              }
            />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path="*" element={<HomePage />} />
          </Routes>
          <Footer />
        </div>
      </BrowserRouter>
    </>
  );
};

export default AppRoutes;
