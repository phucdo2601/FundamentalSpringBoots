import React from "react";
import { similarCompany } from "../Data/Company";
import CompanyCard from "./CompanyCard";

const SimilarCompaniesComp = () => {
  return (
    <>
      <div className="w-1/4">
        <div className="text-xl font-semibold mb-5">Similar companies</div>
        <div className="flex flex-col flex-wrap gap-5 justify-between">
          {similarCompany.map((company, index) => (
            <>
              <CompanyCard props={company} />
            </>
          ))}
        </div>
      </div>
    </>
  );
};

export default SimilarCompaniesComp;
