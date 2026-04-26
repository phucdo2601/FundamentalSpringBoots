import { Tabs } from "@mantine/core";
import React from "react";
import { jobList } from "../Data/JobData";
import { MockJobModel } from "../Model/MockModel/MockJobModel";
import JobHistoryCard from "./JobHistoryCard";

const JobHistoryComp = () => {
  return (
    <>
      <div className="">
        <div className="text-2xl font-semibold mb-5">Job History</div>
        <div className="">
          <Tabs variant="outline" radius={`lg`} defaultValue={`applied`}>
            <Tabs.List className="[&_button]:!text-lg font-semibold [&_button[data-active='true']]:text-bright-sun-400">
              <Tabs.Tab value="applied">Applied</Tabs.Tab>
              <Tabs.Tab value="saved">Saved</Tabs.Tab>
              <Tabs.Tab value="offered">Offered</Tabs.Tab>
              <Tabs.Tab value="interviewing">Interviewing</Tabs.Tab>
            </Tabs.List>

            <Tabs.Panel value="applied">
              <>
                <div className="mt-10 flex flex-wrap gap-5">
                  {jobList.map((job: MockJobModel, index: number) => (
                    <>
                      <JobHistoryCard key={index} job={job} applied={true} />
                    </>
                  ))}
                </div>
              </>
            </Tabs.Panel>
            <Tabs.Panel value="saved">
              <>
                <div className="mt-10 flex flex-wrap gap-5">
                  {jobList.map((job: MockJobModel, index: number) => (
                    <>
                      <JobHistoryCard key={index} job={job} saved={true} />
                    </>
                  ))}
                </div>
              </>
            </Tabs.Panel>
            <Tabs.Panel value="offered">
              <>
                <div className="mt-10 flex flex-wrap gap-5">
                  {jobList.map((job: MockJobModel, index: number) => (
                    <>
                      <JobHistoryCard key={index} job={job} offered={true} />
                    </>
                  ))}
                </div>
              </>
            </Tabs.Panel>
            <Tabs.Panel value="interviewing">
              <>
                <div className="mt-10 flex flex-wrap gap-5">
                  {jobList.map((job: MockJobModel, index: number) => (
                    <>
                      <JobHistoryCard
                        key={index}
                        job={job}
                        interviewing={true}
                      />
                    </>
                  ))}
                </div>
              </>
            </Tabs.Panel>
          </Tabs>
        </div>
      </div>
    </>
  );
};

export default JobHistoryComp;
