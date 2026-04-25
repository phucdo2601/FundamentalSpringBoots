import React from "react";
import { jobList } from "../Data/JobData";
import JobCard from "../FindJobs/JobCard";

const CompanyJobTabComp = () => {
  return (
    <>
      <div className="flex mt-10 flex-wrap gap-3">
        {jobList.map((job, index) => (
          <>
            <JobCard job={job} />
          </>
        ))}
      </div>
    </>
  );
};

export default CompanyJobTabComp;
