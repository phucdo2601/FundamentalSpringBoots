import { Button, Divider } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import { Link, useNavigate } from "react-router-dom";
import CompanyComp from "../CompanyProfile/CompanyComp";
import SimilarCompaniesComp from "../CompanyProfile/SimilarCompaniesComp";

const CompanyPage = () => {
  const navigate = useNavigate();

  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] p-4">
        <Button
          leftSection={<IconArrowLeft />}
          color="brightSun.4"
          variant="light"
          onClick={() => navigate(-1)}
        >
          Back
        </Button>

        <div className="flex gap-5 justify-between">
          <CompanyComp />
          <SimilarCompaniesComp />
        </div>
      </div>
    </>
  );
};

export default CompanyPage;
