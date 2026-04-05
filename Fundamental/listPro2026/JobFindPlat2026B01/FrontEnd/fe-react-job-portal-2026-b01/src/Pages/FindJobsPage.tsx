import React from "react";
import SearchBar from "../FindJobs/SearchBar";
import { Divider } from "@mantine/core";
import Jobs from "../FindJobs/Jobs";

const FindJobsPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins']">
        <Divider size={`xs`} mx={`md`} />
        <SearchBar />
        <Divider size={`xs`} mx={`md`} />

        <Jobs />
      </div>
    </>
  );
};

export default FindJobsPage;
