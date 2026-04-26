import {
  IconBookmark,
  IconBookmarkFilled,
  IconCalendar,
  IconClockHour3,
} from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";
import { MockJobModel } from "../Model/MockModel/MockJobModel";
import { Button, Divider, Text } from "@mantine/core";

interface JobCardProps {
  job: MockJobModel;
  applied?: boolean;
  saved?: boolean;
  offered?: boolean;
  interviewing?: boolean;
}

const JobHistoryCard = ({
  job,
  applied = false,
  saved = false,
  offered = false,
  interviewing = false,
}: JobCardProps) => {
  return (
    <>
      <Link
        to={`/jobs`}
        className="bg-mine-shaft-800 p-4 w-72 flex flex-col gap-3 rounded-xl hover:shadow-[0_0_5px_1px_yellow] !shadow-bright-sun-400"
      >
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
          {saved ? (
            <>
              <IconBookmarkFilled className=" cursor-pointer text-bright-sun-400" />
            </>
          ) : (
            <>
              <IconBookmark className="text-mine-shaft-300 cursor-pointer" />
            </>
          )}
        </div>
        <div
          className="flex gap-2 [&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-700
          [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-xs
        "
        >
          <div className="">{job.experience}</div>
          <div className="">{job.jobType}</div>
          <div className="">{job.location}</div>
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
            <IconClockHour3 className="h-5 w-5" stroke={1.5} />
            {applied || interviewing
              ? "Applied"
              : offered
                ? "Interviewed"
                : "Posted"}{" "}
            {job.postedDayAgo} days ago
          </div>
        </div>

        {(offered || interviewing) && (
          <>
            <Divider color="mineShaft.7" size={`xs`} />
          </>
        )}
        {offered && (
          <>
            <div className="flex gap-2">
              <Button color="brightSun.4" variant="outline" fullWidth>
                Accept
              </Button>

              <Button color="brightSun.4" variant="light" fullWidth>
                Reject
              </Button>
            </div>
          </>
        )}
        {interviewing && (
          <>
            <div className="flex gap-1 text-sm items-center">
              <IconCalendar
                className="text-bright-sun-400 w-5 h-5"
                stroke={1.5}
              />
              August 29, 2026 &bull;{" "}
              <span className="text-mine-shaft-400">10:00</span>
            </div>
          </>
        )}
      </Link>
    </>
  );
};

export default JobHistoryCard;
