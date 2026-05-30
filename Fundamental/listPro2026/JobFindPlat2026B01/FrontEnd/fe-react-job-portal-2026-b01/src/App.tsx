import React from "react";
import logo from "./logo.svg";
import "./App.css";
import {
  createTheme,
  MantineProvider,
  Slider,
  Divider,
  Notification,
} from "@mantine/core";
import "@mantine/core/styles.css";
import "@mantine/carousel/styles.css";
import "@mantine/tiptap/styles.css";
import "@mantine/dates/styles.css";
import "@mantine/notifications/styles.css";
import HomePage from "./Pages/HomePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import FindJobs from "./Pages/FindJobsPage";
import Header from "./Header/Header";
import Footer from "./Footer/Footer";
import FindJobsPage from "./Pages/FindJobsPage";
import FindTalentPage from "./Pages/FindTalentPage";
import TalentProfilePage from "./Pages/TalentProfilePage";
import PostJobPage from "./Pages/PostJobPage";
import JobDescriptionPage from "./Pages/JobDescriptionPage";
import ApplyJobPage from "./Pages/ApplyJobPage";
import CompanyPage from "./Pages/CompanyPage";
import PostedJobPage from "./Pages/PostedJobPage";
import JobHistoryPage from "./Pages/JobHistoryPage";
import SignUpPage from "./Pages/SignUpPage";
import ProfilePage from "./Pages/ProfilePage";
import { Notifications } from "@mantine/notifications";

function App() {
  const theme = createTheme({
    colors: {
      brightSun: [
        "#fffbeb",
        "#fff3c6",
        "#ffe588",
        "#ffd149",
        "#ffbd20",
        "#f99b07",
        "#dd7302",
        "#b75006",
        "#943c0c",
        "#7a330d",
        "#461902",
      ],
      mineShaft: [
        "#fafafa",
        "#f5f5f5",
        "#e6e6e6",
        "#d6d6d6",
        "#a5a5a5",
        "#767676",
        "#575757",
        "#434343",
        "#2d2d2d",
        "#1a1a1a",
        "#0a0a0a",
      ],
    },
    fontFamily: "poppins, sans-serif",
    primaryColor: "brightSun",
    primaryShade: 4,
  });

  return (
    <>
      <MantineProvider defaultColorScheme="dark" theme={theme}>
        <Notifications position={"top-right"} zIndex={1000} />
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
              <Route path="/signup" element={<SignUpPage />} />
              <Route path="/login" element={<SignUpPage />} />
              <Route path="/profile" element={<ProfilePage />} />
              <Route path="*" element={<HomePage />} />
            </Routes>
            <Footer />
          </div>
        </BrowserRouter>
      </MantineProvider>
    </>
  );
}

export default App;
