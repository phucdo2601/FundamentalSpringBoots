import React from "react";
import { IconAsset, IconBell, IconSettings } from "@tabler/icons-react";
import { Avatar } from "@mantine/core";

const Header = () => {
  return (
    <>
      <div className="w-full bg-black px-6 text-white h-28 flex justify-between items-center">
        <div className="flex gap-3 items-center">
          <IconAsset className="h-10 w-10" stroke={1} />
          <div className="text-2xl font-semibold">iJobs</div>
        </div>
        <div className="flex gap-3">
          <a href="">Find Jobs</a>
          <a href="">Find Talents</a>
          <a href="">Upload Jobs</a>
          <a href="">About Us</a>
        </div>
        <div className="flex gap-5 items-center">
          <IconBell />
          <div className="flex items-center gap-2">
            <div className="">Marshall</div>
            <Avatar src="avatar.png" alt="it's me" />
          </div>
          <IconSettings />
        </div>
      </div>
    </>
  );
};

export default Header;
