import { Button, Divider } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";
import Profile from "../TalentProfile/Profile";

const TalentProfilePage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] p-4">
        <Divider size={`xs`} mx={`md`} />
        <Link className="my-4 inline-block" to={`/find-talent`}>
          <Button
            leftSection={<IconArrowLeft />}
            color="brightSun.4"
            variant="light"
          >
            Back
          </Button>
        </Link>

        <Divider size={`xs`} />
        <div className="flex gap-5">
          <Profile />
        </div>
      </div>
    </>
  );
};

export default TalentProfilePage;
