import { Tabs } from "@mantine/core";
import React from "react";
import { activeJobs } from "../Data/PostedJob";
import PostedJobCard from "./PostedJobCard";

const PostedJobComp = () => {
  return (
    <>
      <div className="w-1/6 mt-5">
        <div className="text-2xl font-semibold mb-5">Jobs</div>
        <div className="">
          <Tabs
            variant="pills"
            defaultValue={`active`}
            // value={activeTab}
            // onChange={setActiveTab}
          >
            <Tabs.List className="[&_button[aria-selected='false']]:bg-mine-shaft-800">
              <Tabs.Tab value="active">Active [4]</Tabs.Tab>
              <Tabs.Tab value="drafts">Drafts [1]</Tabs.Tab>
            </Tabs.List>

            <Tabs.Panel value="active">
              <>
                <div className="flex flex-col gap-5 mt-5">
                  {activeJobs.map((item, index) => (
                    <>
                      <PostedJobCard props={item} />
                    </>
                  ))}
                </div>
              </>
            </Tabs.Panel>
            <Tabs.Panel value="drafts">s</Tabs.Panel>
          </Tabs>
        </div>
      </div>
    </>
  );
};

export default PostedJobComp;
