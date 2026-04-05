import { Avatar, Button, Divider, Text } from "@mantine/core";
import {
  IconBookmark,
  IconClockHour3,
  IconHeart,
  IconMapPin,
} from "@tabler/icons-react";
import React from "react";
import { MockJobModel } from "../Model/MockModel/MockJobModel";
import { TalentModel } from "../Model/MockModel/MockTalentModel";
import { Link } from "react-router-dom";

interface TalentCardProps {
  talent: TalentModel;
}

const TalentCard = ({ talent }: TalentCardProps) => {
  return (
    <>
      <div className="bg-mine-shaft-800 p-4 w-96 flex flex-col gap-3 rounded-xl hover:shadow-[0_0_5px_1px_yellow] !shadow-bright-sun-400">
        <div className="flex justify-between">
          <div className="flex gap-2 items-center ">
            <div className="p-2 bg-mine-shaft-700 rounded-full ">
              <Avatar
                size={`lg`}
                src={`/${talent.image}.png`}
                alt="Microsoft "
              />
            </div>
            <div>
              <div className="font-semibold text-lg">{talent.name}</div>
              <div className="text-sm text-mine-shaft-300 ">
                {talent.role} &bull; {talent.company}
              </div>
            </div>
          </div>
          <IconHeart className="text-mine-shaft-300 cursor-pointer" />
        </div>
        <div
          className="flex gap-2 
        "
        >
          {talent.topSkills?.map((item, index) => (
            <>
              <div
                className="[&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-700
          [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-xs"
              >
                {item}
              </div>
            </>
          ))}
        </div>
        <div>
          <Text
            className="!text-xs text-justify !text-mine-shaft-300"
            lineClamp={3}
          >
            {talent.about}
          </Text>
        </div>
        <Divider size={`xs`} color="mineShaft.7" />
        <div className="flex justify-between">
          <div className="font-semibold text-mine-shaft-200">
            &#36; {talent.expectedCtc}
          </div>
          <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
            <IconMapPin className="h-5 w-5" stroke={1.5} /> {talent.location}
          </div>
        </div>
        <Divider size={`xs`} color="mineShaft.7" />
        <div className="flex [&>*]:w-1/2 [&>*]:p-1">
          <Link to={`talent-profile`}>
            <Button color="brightSun.4" variant="light" fullWidth>
              Profile
            </Button>
          </Link>
          <div className="">
            <Link to={``}>
              <Button color="brightSun.4" variant="outline" fullWidth>
                Messages
              </Button>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default TalentCard;
