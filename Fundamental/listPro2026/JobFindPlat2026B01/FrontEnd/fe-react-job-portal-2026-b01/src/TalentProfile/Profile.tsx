import { Button, Divider } from "@mantine/core";
import { IconBriefcase, IconMapPin } from "@tabler/icons-react";
import React from "react";
import ExpCard from "./ExpCard";
import CertiCard from "./CertiCard";

const Profile = () => {
  return (
    <>
      <div className="w-2/3">
        <div className="relative">
          <img className="rounded-t-2xl" src="/Profile/banner.jpg" alt="" />
          <img
            className="w-48 h-48 rounded-full -bottom-1/3 absolute left-3 border-mine-shaft-950 border-8"
            src="/Avartar.png"
            alt=""
          />
        </div>
        <div className="px-3 mt-16">
          <div className="text-3xl font-semibold flex justify-between">
            Jarrod Wood
            <Button color="brightSun.4" variant="outline">
              Messages
            </Button>
          </div>
          <div className="text-lg flex gap-1 items-center">
            <IconBriefcase className="h-5 w-5" stroke={1.5} /> Software Engineer
          </div>
          <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
            <IconMapPin className="h-5 w-5" stroke={1.5} /> New York
          </div>
        </div>

        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-3">About</div>
          <div className="text-sm text-mine-shaft-300 text-justify">
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolores
            corrupti debitis doloremque! Tempora maxime id, quidem fugit
            asperiores natus commodi mollitia accusamus harum consequatur
            molestias? Est omnis non vero esse.
          </div>
        </div>

        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-3">Skills</div>
          <div className="flex flex-wrap gap-2">
            <div className="bg-bright-sun-300 text-sm font-semibold bg-opacity-15 rounded-3xl text-bright-sun-400 px-3 py-1">
              React
            </div>
            <div className="bg-bright-sun-300 text-sm font-semibold bg-opacity-15 rounded-3xl text-bright-sun-400 px-3 py-1">
              React
            </div>
            <div className="bg-bright-sun-300 text-sm font-semibold bg-opacity-15 rounded-3xl text-bright-sun-400 px-3 py-1">
              React
            </div>
          </div>
        </div>
        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-5">Experience</div>
          <ExpCard />
        </div>
        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-5">Certifications</div>
          <CertiCard />
        </div>
      </div>
    </>
  );
};

export default Profile;
