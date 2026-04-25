import { Avatar, Button, Divider, Tabs } from "@mantine/core";
import { IconBriefcase, IconMapPin } from "@tabler/icons-react";
import React from "react";
import AboutTabComp from "./AboutTabComp";
import CompanyJobTabComp from "./CompanyJobTabComp";
import CompanyEmployeeTabComp from "./CompanyEmployeeTabComp";

const CompanyComp = () => {
  return (
    <>
      <div className="w-3/4">
        <div className="relative">
          <img className="rounded-t-2xl" src="/Profile/banner.jpg" alt="" />
          <img
            className="w-36 h-36 rounded-3xl -bottom-1/3 absolute left-5 border-mine-shaft-600 border-8 p-2 bg-mine-shaft-600"
            src="/Icons/Google.png"
            alt=""
          />
        </div>
        <div className="px-3 mt-12">
          <div className="text-3xl font-semibold flex justify-between">
            Google
            <Avatar.Group>
              <Avatar src="avartar.png" />
              <Avatar src="avartar.png" />
              <Avatar src="avartar.png" />
              <Avatar>+10k</Avatar>
            </Avatar.Group>
          </div>

          <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
            <IconMapPin className="h-5 w-5" stroke={1.5} /> New York
          </div>
        </div>

        <Divider mx={`xs`} my={`xl`} />

        <div className="">
          <Tabs variant="outline" radius={`lg`} defaultValue={`about`}>
            <Tabs.List className="[&_button]:!text-lg font-semibold [&_button[data-active='true']]:text-bright-sun-400">
              <Tabs.Tab value="about">About</Tabs.Tab>
              <Tabs.Tab value="jobs">Jobs</Tabs.Tab>
              <Tabs.Tab value="employees">Employees</Tabs.Tab>
            </Tabs.List>

            <Tabs.Panel value="about">
              <AboutTabComp />
            </Tabs.Panel>
            <Tabs.Panel value="jobs">
              <CompanyJobTabComp />
            </Tabs.Panel>
            <Tabs.Panel value="employees">
              <CompanyEmployeeTabComp />
            </Tabs.Panel>
          </Tabs>
        </div>
      </div>
    </>
  );
};

export default CompanyComp;
