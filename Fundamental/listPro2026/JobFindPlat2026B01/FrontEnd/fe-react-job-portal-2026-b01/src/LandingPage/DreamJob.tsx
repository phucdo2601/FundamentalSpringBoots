import { Avatar, TextInput } from "@mantine/core";
import { IconSearch } from "@tabler/icons-react";
import React from "react";

const DreamJob = () => {
  return (
    <>
      <div className="flex items-center px-20">
        <div className="flex flex-col w-[45%]">
          <div className="text-6xl font-bold leading-tight text-mine-shaft-100 [&>span]:text-bright-sun-400">
            Find your
            <span className="text-bright"> dream</span>
            <span className=""> job </span>
            with us
          </div>
          <div className="text-lg text-mine-shaft-100">
            Good life begins with a good company. Start explore thousands of
            jobs in one place.
          </div>
          <div className="flex gap-3 mt-5">
            <TextInput
              className="bg-mine-shaft-900 rounded-lg p-1 px-2 text-mine-shaft-100 [&_input]:!text-mine-shaft-100"
              variant="unstyled"
              label="Job title"
              placeholder="Software Engineer"
            />

            <TextInput
              className="bg-mine-shaft-900 rounded-lg p-1 px-2 text-mine-shaft-100 [&_input]:!text-mine-shaft-100"
              variant="unstyled"
              label="Job type"
              placeholder="Fulltime"
            />
            <div className="flex items-center justify-center h-full w-20 bg-bright-sun-400 text-mine-shaft-100 rounded-lg p-2 hover:bg-bright-sun-500 cursor-pointer">
              <IconSearch stroke={1.5} className="h-[85%] w-[85%]" />
            </div>
          </div>
        </div>
        <div className="w-[55%] items-center justify-center">
          <div className="w-[30rem] relative">
            <img src="/boy.png" />
            <div className="absolute w-fit -right-10 top-[50%] border-bright-sun-100 border rounded-lg p-2 backdrop-blur-md">
              <div className="text-center mb-1 text-sm text-mine-shaft-100">
                10K+ got job
              </div>
              <Avatar.Group>
                <Avatar src="image.png" />
                <Avatar src="image.png" />
                <Avatar src="image.png" />
                <Avatar>+9K</Avatar>
              </Avatar.Group>
            </div>

            <div className="absolute w-fit -left-15 top-[25%] border-bright-sun-100 border rounded-lg p-2 backdrop-blur-md gap-3 flex flex-col">
              <div className="flex gap-2 items-center ">
                <div className="w-12 h-12 p-2 bg-mine-shaft-700 rounded-lg">
                  <img src="/google.png" alt="" />
                </div>
                <div className="text-sm text-mine-shaft-100">
                  <div>Software Engineer</div>
                  <div className="text-mine-shaft-200 text-xs">Ho Chi Minh</div>
                </div>
              </div>
              <div className="flex gap-2 justify-around text-mine-shaft-300 text-xs">
                <span>1 day ago</span>
                <span>120 applicants</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default DreamJob;
