import React from "react";

const CertiCard = () => {
  return (
    <>
      <div className="flex justify-between">
        <div className="flex gap-2 items-center ">
          <div className="p-2 bg-mine-shaft-700 rounded-md ">
            <img className="h-7" src={`/Icons/Google.png`} alt="Microsoft " />
          </div>
          <div className="flex flex-col">
            <div className="font-semibold">Cloud Certification</div>
            <div className="text-sm text-mine-shaft-300 ">Google</div>
          </div>
        </div>
        <div className="flex flex-col items-center">
          <div className="text-sm text-mine-shaft-300">june 2023</div>
          <div className="text-sm text-mine-shaft-300">ID: ERTSEFSTER </div>
        </div>
      </div>
    </>
  );
};

export default CertiCard;
