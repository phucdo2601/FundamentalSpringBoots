import {
  IconBookmark,
  IconExchange,
  IconExternalLink,
} from "@tabler/icons-react";
import React from "react";
import { SimilarCompanyModel } from "../Model/MockModel/CompanyModel";
import { ActionIcon } from "@mantine/core";

interface CompanyCardProps {
  props: SimilarCompanyModel;
}

const CompanyCard = ({ props }: CompanyCardProps) => {
  return (
    <>
      <div className="flex justify-between bg-mine-shaft-900 items-center rounded-lg p-2">
        <div className="flex gap-2 items-center ">
          <div className="p-2 bg-mine-shaft-700 rounded-md ">
            <img
              className="h-7"
              src={`/Icons/${props.name}.png`}
              alt="Microsoft "
            />
          </div>
          <div>
            <div className="font-semibold">{props.name}</div>
            <div className="text-xs text-mine-shaft-300 ">
              {props.employees} Employees
            </div>
          </div>
        </div>
        <ActionIcon color="brightSun.4" variant="subtle">
          <IconExternalLink />
        </ActionIcon>
      </div>
    </>
  );
};

export default CompanyCard;
