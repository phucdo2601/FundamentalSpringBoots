import { IconBookmark } from "@tabler/icons-react";
import React from "react";
import { ExperienceModel } from "../Model/MockModel/ProfileModel";

interface ExpCartProp {
  experience: ExperienceModel;
}

const ExpCard = ({ experience }: ExpCartProp) => {
  return (
    <>
      <div className="flex flex-col gap-2">
        <div className="flex justify-between">
          <div className="flex gap-2 items-center ">
            <div className="p-2 bg-mine-shaft-700 rounded-md ">
              <img
                className="h-7"
                src={`/Icons/${experience.company}.png`}
                alt="Microsoft "
              />
            </div>
            <div className="flex flex-col">
              <div className="font-semibold">{experience.title}</div>
              <div className="text-sm text-mine-shaft-300 ">
                {experience.company} &#x2022; {experience.location}
              </div>
            </div>
          </div>
          <div className="text-sm text-mine-shaft-300">
            {experience.startDate} - {experience.endDate}
            {/* <IconBookmark className="text-mine-shaft-300 cursor-pointer" /> */}
          </div>
        </div>
        <div className="text-sm text-mine-shaft-300 text-justify">
          {experience.description}
        </div>
      </div>
    </>
  );
};

export default ExpCard;
