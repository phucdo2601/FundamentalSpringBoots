import {
  IconAnchor,
  IconBrandFacebook,
  IconBrandInstagram,
  IconBrandX,
} from "@tabler/icons-react";
import React from "react";
import { footerLinks } from "../Data/Data";

const Footer = () => {
  return (
    <>
      <div className="mt-20 pb-5 flex gap-5 justify-around">
        <div
          className="
          w-1/4 flex flex-col gap-4
        "
        >
          <div className="flex gap-1 items-center text-bright-sun-400">
            <IconAnchor className="h-7 w-7" stroke={2.5} />
            <div className="text-xl font-semibold">iJobs</div>
          </div>
          <div className="text-sm text-mine-shaft-300">
            Job portal with user profiles, skill updates, certification, work
            experince and job posting
          </div>
          <div className="flex gap-3 text-bright-sun-400 [&>div]:bg-mine-shaft-900 [&>div]:p-2 [&>div]:rounded-full [&>div]:cursor-pointer hover:[&>div]:bg-mine-shaft-600">
            <div className="">
              <IconBrandFacebook />
            </div>
            <div className="">
              <IconBrandInstagram />
            </div>
            <div className="">
              <IconBrandX />
            </div>
          </div>
        </div>
        {footerLinks.map((link, index) => (
          <>
            <div className="" key={index}>
              <div className="text-lg font-semibold mb-4 text-bright-sun-400">
                {link.title}
              </div>
              {link.links.map((link, index) => (
                <>
                  <div className="text-mine-shaft-300 text-sm hover:text-bright-sun-400 cursor-pointer mb-1 hover:translate-x-2 transition duration-300 ease-in-out">
                    {link}
                  </div>
                </>
              ))}
            </div>
          </>
        ))}
      </div>
    </>
  );
};

export default Footer;
