import { IconBookmark } from "@tabler/icons-react";
import React from "react";

const ExpCard = () => {
  return (
    <>
      <div className="flex flex-col gap-2">
        <div className="flex justify-between">
          <div className="flex gap-2 items-center ">
            <div className="p-2 bg-mine-shaft-700 rounded-md ">
              <img className="h-7" src={`/Icons/Google.png`} alt="Microsoft " />
            </div>
            <div className="flex flex-col">
              <div className="font-semibold">Software Engineer</div>
              <div className="text-sm text-mine-shaft-300 ">
                Google &#x2022; New York
              </div>
            </div>
          </div>
          <div className="text-sm text-mine-shaft-300">
            Jan 2022 - Present
            {/* <IconBookmark className="text-mine-shaft-300 cursor-pointer" /> */}
          </div>
        </div>
        <div className="text-sm text-mine-shaft-300 text-justify">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Illum
          voluptates, quae at beatae facilis distinctio saepe adipisci, amet
          dolor quo perspiciatis placeat cupiditate soluta iste eaque sequi
          repudiandae molestias asperiores.
        </div>
      </div>
    </>
  );
};

export default ExpCard;
