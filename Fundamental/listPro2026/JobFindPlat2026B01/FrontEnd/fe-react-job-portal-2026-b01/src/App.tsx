import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { createTheme, MantineProvider, Slider, Divider } from "@mantine/core";
import "@mantine/core/styles.css";
import "@mantine/carousel/styles.css";
import "@mantine/tiptap/styles.css";
import HomePage from "./Pages/HomePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import FindJobs from "./Pages/FindJobsPage";
import Header from "./Header/Header";
import Footer from "./Footer/Footer";
import FindJobsPage from "./Pages/FindJobsPage";
import FindTalentPage from "./Pages/FindTalentPage";
import TalentProfilePage from "./Pages/TalentProfilePage";
import PostJobPage from "./Pages/PostJobPage";

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
        <BrowserRouter>
          <Header />
          <Divider size={`xs`} mx={`md`} />
          <Routes>
            <Route path="/find-jobs" element={<FindJobsPage />} />
            <Route path="/find-talent" element={<FindTalentPage />} />
            <Route path="/talent-profile" element={<TalentProfilePage />} />
            <Route path="/post-job" element={<PostJobPage />} />
            <Route path="*" element={<HomePage />} />
          </Routes>
          <Footer />
        </BrowserRouter>
      </MantineProvider>
    </>
  );
}

export default App;
