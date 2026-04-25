import React from "react";
import { companyData } from "../Data/Company";
import { CompanyModel } from "../Model/MockModel/CompanyModel";

const AboutTabComp = () => {
  const company: { [key: string]: any } = companyData;

  return (
    <>
      <div className="flex flex-col gap-5">
        {Object.keys(companyData).map((key, index) => (
          <>
            {key != "Name" && (
              <>
                <div className="">
                  <div className="text-xl mb-3 font-semibold">{key}</div>
                  {key != "Website" && (
                    <>
                      <div className="text-sm text-mine-shaft-300 text-justify">
                        {key != "Specialties"
                          ? company[key]
                          : company[key].map((item: string, index: number) => (
                              <>&bull; {item}</>
                            ))}
                      </div>
                    </>
                  )}

                  {key === "Website" && (
                    <>
                      <a
                        href={company[key]}
                        target="_blank"
                        className="text-sm text-bright-sun-400 text-justify"
                      >
                        {company[key]}
                      </a>
                    </>
                  )}
                </div>
              </>
            )}
          </>
        ))}
      </div>
    </>
  );
};

export default AboutTabComp;
