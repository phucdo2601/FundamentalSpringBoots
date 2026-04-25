import { Button, Divider } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";
import JobDesc from "../JobDesc/JobDesc";
import RecommendedJobs from "../JobDesc/RecommendedJobs";

const JobDescriptionPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] p-4">
        <Link className="my-4 inline-block" to={`/find-job`}>
          <Button
            leftSection={<IconArrowLeft />}
            color="brightSun.4"
            variant="light"
          >
            Back
          </Button>
        </Link>

        <div className="flex gap-5 justify-around">
          <JobDesc />
          <RecommendedJobs />
        </div>
      </div>
    </>
  );
};

export default JobDescriptionPage;
