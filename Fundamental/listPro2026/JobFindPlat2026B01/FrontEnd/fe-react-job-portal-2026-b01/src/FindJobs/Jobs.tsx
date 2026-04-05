import React from "react";
import Sort from "./Sort";
import JobCard from "./JobCard";
import { jobList } from "../Data/JobData";
import { MockJobModel } from "../Model/MockModel/MockJobModel";

const Jobs = () => {
  return (
    <>
      <div className="p-5">
        <div className="flex justify-between">
          <div className="text-2xl font-semibold">Recommended Jobs</div>
          <Sort />
        </div>

        <div className="mt-10 flex flex-wrap gap-5">
          {jobList.map((job: MockJobModel, index: number) => (
            <>
              <JobCard key={index} job={job} />
            </>
          ))}
        </div>
      </div>
    </>
  );
};

export default Jobs;
