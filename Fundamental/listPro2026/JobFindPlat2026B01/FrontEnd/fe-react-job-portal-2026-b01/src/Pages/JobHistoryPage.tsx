import React from "react";
import JobHistoryComp from "../JobHistory/JobHistoryComp";

const JobHistoryPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] px-4">
        <div className="my-5">
          <JobHistoryComp />
        </div>
      </div>
    </>
  );
};

export default JobHistoryPage;
