import { Avatar, Button, Divider, Modal, Text } from "@mantine/core";
import {
  IconBookmark,
  IconCalendar,
  IconClockHour3,
  IconHeart,
  IconMapPin,
} from "@tabler/icons-react";
import React, { useRef, useState } from "react";
import { MockJobModel } from "../Model/MockModel/MockJobModel";
import { TalentModel } from "../Model/MockModel/MockTalentModel";
import { Link } from "react-router-dom";
import { useDisclosure } from "@mantine/hooks";
import { DateInput, TimeInput } from "@mantine/dates";

interface TalentCardProps {
  talent: TalentModel;
  posted?: boolean;
  invited?: boolean;
}

const TalentCard = ({
  talent,
  posted = false,
  invited = false,
}: TalentCardProps) => {
  const [opened, { open, close }] = useDisclosure(false);

  const [value, setValue] = useState<Date | any>(null);

  const ref = useRef<HTMLInputElement>(null);

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
        {invited ? (
          <>
            <div className="flex gap-1 text-mine-shaft-200 text-sm items-center">
              <IconCalendar className="w-5 h-5" stroke={1.5} />
              Interview: August 29, 2026 10:00
            </div>
          </>
        ) : (
          <>
            <div className="flex justify-between">
              <div className="font-semibold text-mine-shaft-200">
                &#36; {talent.expectedCtc}
              </div>
              <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
                <IconMapPin className="h-5 w-5" stroke={1.5} />{" "}
                {talent.location}
              </div>
            </div>
          </>
        )}

        <Divider size={`xs`} color="mineShaft.7" />
        <div className="flex [&>*]:w-1/2 [&>*]:p-1">
          {!invited && (
            <>
              <Link to={`/talent-profile`}>
                <Button color="brightSun.4" variant="outline" fullWidth>
                  Profile
                </Button>
              </Link>
            </>
          )}

          {invited && (
            <>
              <div className="">
                <Link to={`/talent-profile`}>
                  <Button color="brightSun.4" variant="outline" fullWidth>
                    Accept
                  </Button>
                </Link>
              </div>
              <div className="">
                <Link to={`/talent-profile`}>
                  <Button color="brightSun.4" variant="light" fullWidth>
                    Reject
                  </Button>
                </Link>
              </div>
            </>
          )}

          <div className="">
            {posted ? (
              <>
                <Button
                  onClick={open}
                  rightSection={<IconCalendar className="w-5 h-5" />}
                  color="brightSun.4"
                  variant="outline"
                  fullWidth
                >
                  Schedule
                </Button>
              </>
            ) : (
              <></>
            )}
          </div>
        </div>
        <Modal
          opened={opened}
          onClose={close}
          title="Schedule Interview"
          centered
        >
          <>
            <div className="flex flex-col gap-4">
              <DateInput
                value={value}
                onChange={setValue}
                label="Date"
                placeholder="Enter Date"
              />
              <TimeInput
                label="Time"
                description="Input description"
                ref={ref}
                onClick={() => ref.current?.showPicker()}
              />
              <Button color="brightSun.4" variant="outline" fullWidth>
                Schedule
              </Button>
            </div>
          </>
        </Modal>
      </div>
    </>
  );
};

export default TalentCard;
