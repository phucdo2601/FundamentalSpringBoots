import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { MantineProvider, Slider } from "@mantine/core";
import "@mantine/core/styles.css";
import HomePage from "./Pages/HomePage";

function App() {
  return (
    <>
      <MantineProvider>
        {/* <h1 className="text-3xl text-red-400 font-bold underline">
          Hello world!
        </h1>
        <Slider
          color="blue"
          defaultValue={40}
          marks={[
            { value: 20, label: "20%" },
            { value: 50, label: "50%" },
            { value: 80, label: "80%" },
          ]}
        /> */}

        <HomePage />
      </MantineProvider>
    </>
  );
}

export default App;
