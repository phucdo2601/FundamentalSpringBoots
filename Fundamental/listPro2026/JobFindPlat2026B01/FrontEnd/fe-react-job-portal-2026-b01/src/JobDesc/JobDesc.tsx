import { ActionIcon, Button, Divider } from "@mantine/core";
import { IconAdjustments, IconBookmark, IconMapPin } from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";
import { card, desc, skills } from "../Data/JobDescData";
import { JobDesCardModel } from "../Model/MockModel/JobDescModel";
import DOMPurify from "dompurify";

const JobDesc = (props: any) => {
  const data = DOMPurify.sanitize(desc);
  return (
    <>
      <div className="w-2/3 mt-2">
        <div className="flex justify-between">
          <div className="flex gap-2 items-center ">
            <div className="p-3 bg-mine-shaft-700 rounded-lg ">
              <img
                className="h-14"
                src={`/Icons/Google.png`}
                alt="Microsoft "
              />
            </div>
            <div className="flex flex-col gap-1">
              <div className="font-semibold text-2xl">
                Software Engineer III
              </div>
              <div className="text-xs text-mine-shaft-300 ">
                Google &#x2022; 3 days ago &#x2022; 48 Applicants
              </div>
            </div>
          </div>
          <div className="flex flex-col gap-2 items-center">
            <Link to={`/apply-job`}>
              <Button color="brightSun.4" variant="light" size="sm">
                {props.edit ? "Edit" : "Apply"}
              </Button>
            </Link>
            {props.edit ? (
              <>
                <Button color="red.5" variant="outline" size="sm">
                  Delete
                </Button>
              </>
            ) : (
              <>
                <IconBookmark className="text-lg text-bright-sun-400 cursor-pointer" />
              </>
            )}
          </div>
        </div>
        <Divider my={`xl`} />
        <div className="flex justify-between">
          {card.map((item: JobDesCardModel, index: number) => (
            <>
              <div className="flex flex-col items-center gap-1">
                <ActionIcon
                  color="brightSun.4"
                  className="!h-12 !w-12"
                  variant="light"
                  size={`lg`}
                  radius={`xl`}
                  aria-label="Settings"
                >
                  <item.icon className="h-4/5 w-4/5" stroke={1.5} />
                </ActionIcon>
                <div className="text-sm text-mine-shaft-300">{item.name}</div>
                <div className="font-semibold">{item.value}</div>
              </div>
            </>
          ))}
        </div>
        <Divider my={`xl`} />
        <div className="text-xl font-semibold mb-5">Required Skills</div>
        <div className="flex flex-wrap gap-2">
          {skills.map((item: string, index: number) => (
            <>
              <ActionIcon
                color="brightSun.4"
                className="!h-fit !w-fit font-medium text-sm"
                variant="light"
                p={`xs`}
                size={`lg`}
                radius={`xl`}
                aria-label="Settings"
              >
                {item}
              </ActionIcon>
            </>
          ))}
        </div>
        <Divider my={`xl`} />
        <div
          className="[&_*]:text-mine-shaft-300 [&_li]:marker:text-bright-sun-400 [&_li]:mb-1 [&_h4]:text-xl [&_h4]:my-5 [&_h4]:font-semibold [&_h4]:text-mine-shaft-200 [&_p]:text-justify"
          dangerouslySetInnerHTML={{ __html: data }}
        ></div>
        <Divider my={`xl`} />
        <div className="">
          <div className="text-xl font-semibold mb-5">About the company</div>
          <div className="flex justify-between mb-3">
            <div className="flex gap-2 items-center ">
              <div className="p-3 bg-mine-shaft-700 rounded-lg ">
                <img
                  className="h-8"
                  src={`/Icons/Google.png`}
                  alt="Microsoft "
                />
              </div>
              <div className="flex flex-col">
                <div className="font-medium text-lg">Google</div>
                <div className=" text-xs text-mine-shaft-300 ">
                  10k + Employees
                </div>
              </div>
            </div>
            <Link to={`/company`}>
              <Button color="brightSun.4" variant="light" size="sm">
                Company Page
              </Button>
            </Link>
          </div>
          <div className="text-mine-shaft-300 text-justify">
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nostrum,
            eaque eveniet. Facilis, laudantium! Similique, at? Rerum voluptatem
            nobis placeat! Alias ad quis eum optio voluptatibus corrupti eius
            totam nobis veritatis.
          </div>
        </div>
      </div>
    </>
  );
};

export default JobDesc;
