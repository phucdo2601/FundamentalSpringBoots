import { Button } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";
import ApplyJobComp from "../ApplyJob/ApplyJobComp";

const ApplyJobPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] p-4">
        <Link className="my-4 inline-block" to={`/jobs`}>
          <Button
            leftSection={<IconArrowLeft />}
            color="brightSun.4"
            variant="light"
          >
            Back
          </Button>
        </Link>

        <ApplyJobComp />
      </div>
    </>
  );
};

export default ApplyJobPage;
