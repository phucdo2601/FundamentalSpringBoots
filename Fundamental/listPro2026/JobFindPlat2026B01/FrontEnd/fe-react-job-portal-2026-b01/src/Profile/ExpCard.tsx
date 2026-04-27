import { IconBookmark } from "@tabler/icons-react";
import React, { useState } from "react";
import { ExperienceModel } from "../Model/MockModel/ProfileModel";
import { Button } from "@mantine/core";
import ExpInput from "./ExpInput";

interface ExpCartProp {
  experience: ExperienceModel;
  edit?: any;
}

const ExpCard = ({ experience, edit }: ExpCartProp) => {
  const [editIn, setEditIn] = useState(false);

  return (
    <>
      {!editIn ? (
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

            {edit && (
              <>
                <div className="flex gap-5">
                  <Button
                    color="brightSun.4"
                    variant="outline"
                    onClick={() => setEditIn(true)}
                  >
                    Edit
                  </Button>
                  <Button color="red.8" variant="light">
                    Delete
                  </Button>
                </div>
              </>
            )}
          </div>
        </>
      ) : (
        <>
          <ExpInput setEdit={setEditIn} />
        </>
      )}
    </>
  );
};

export default ExpCard;
