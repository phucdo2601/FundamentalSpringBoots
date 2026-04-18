import React from "react";
import { CertificationModel } from "../Model/MockModel/ProfileModel";

interface CertiCardProp {
  certProp?: CertificationModel;
}

const CertiCard = ({ certProp }: CertiCardProp) => {
  return (
    <>
      <div className="flex justify-between">
        <div className="flex gap-2 items-center ">
          <div className="p-2 bg-mine-shaft-700 rounded-md ">
            <img
              className="h-7"
              src={`/Icons/${certProp?.issuer}.png`}
              alt="Microsoft "
            />
          </div>
          <div className="flex flex-col">
            <div className="font-semibold">{certProp?.name}</div>
            <div className="text-sm text-mine-shaft-300 ">
              {certProp?.issuer}
            </div>
          </div>
        </div>
        <div className="flex flex-col items-center">
          <div className="text-sm text-mine-shaft-300">
            {certProp?.issueDate}
          </div>
          <div className="text-sm text-mine-shaft-300">
            ID: {certProp?.certificateId}{" "}
          </div>
        </div>
      </div>
    </>
  );
};

export default CertiCard;
