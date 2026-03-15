import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { createTheme, MantineProvider, Slider } from "@mantine/core";
import "@mantine/core/styles.css";
import "@mantine/carousel/styles.css";
import HomePage from "./Pages/HomePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";

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
  });

  return (
    <>
      <MantineProvider theme={theme}>
        <BrowserRouter>
          <Routes>
            <Route path="*" element={<HomePage />} />
          </Routes>
        </BrowserRouter>
      </MantineProvider>
    </>
  );
}

export default App;
