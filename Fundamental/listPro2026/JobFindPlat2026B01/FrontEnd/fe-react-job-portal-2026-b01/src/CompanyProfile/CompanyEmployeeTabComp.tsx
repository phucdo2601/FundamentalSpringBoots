import React from "react";
import { jobList } from "../Data/JobData";
import JobCard from "../FindJobs/JobCard";
import { talents } from "../Data/TalentData";
import TalentCard from "../FindTalent/TalentCard";

const CompanyEmployeeTabComp = () => {
  return (
    <>
      <div className="flex mt-10 flex-wrap gap-3">
        {talents.map((talent, index) => (
          <>
            <TalentCard talent={talent} />
          </>
        ))}
      </div>
    </>
  );
};

export default CompanyEmployeeTabComp;
