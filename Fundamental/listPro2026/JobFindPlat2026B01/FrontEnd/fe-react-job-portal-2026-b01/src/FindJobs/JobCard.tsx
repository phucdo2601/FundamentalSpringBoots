import { Divider, Text } from "@mantine/core";
import { IconBookmark, IconClockHour3 } from "@tabler/icons-react";
import React from "react";
import { MockJobModel } from "../Model/MockModel/MockJobModel";

interface JobCardProps {
  job: MockJobModel;
}

const JobCard = ({ job }: JobCardProps) => {
  return (
    <>
      <div className="bg-mine-shaft-800 p-4 w-72 flex flex-col gap-3 rounded-xl hover:shadow-[0_0_5px_1px_yellow] !shadow-bright-sun-400">
        <div className="flex justify-between">
          <div className="flex gap-2 items-center ">
            <div className="p-2 bg-mine-shaft-700 rounded-md ">
              <img
                className="h-7"
                src={`/Icons/${job.company}.png`}
                alt="Microsoft "
              />
            </div>
            <div>
              <div className="font-semibold">{job.jobTitle}</div>
              <div className="text-xs text-mine-shaft-300 ">
                {job.company} &#x2022; {job.applicants} Applicants
              </div>
            </div>
          </div>
          {/* <div className=""></div> */}
          <IconBookmark className="text-mine-shaft-300 cursor-pointer" />
        </div>
        <div
          className="flex gap-2 
        "
        >
          <div
            className="[&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-700
          [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-xs"
          >
            {job.experience}
          </div>
          <div
            className="[&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-700
          [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-xs"
          >
            {job.jobType}
          </div>
          <div
            className="[&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-700
          [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-xs"
          >
            {job.location}
          </div>
        </div>
        <div>
          <Text
            className="!text-xs text-justify !text-mine-shaft-300"
            lineClamp={3}
          >
            {job.description}
          </Text>
        </div>
        <Divider size={`xs`} color="mineShaft.7" />
        <div className="flex justify-between">
          <div className="font-semibold text-mine-shaft-200">
            &#36; {job.package}
          </div>
          <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
            <IconClockHour3 className="h-5 w-5" stroke={1.5} />{" "}
            {job.postedDayAgo} days ago
          </div>
        </div>
      </div>
    </>
  );
};

export default JobCard;
