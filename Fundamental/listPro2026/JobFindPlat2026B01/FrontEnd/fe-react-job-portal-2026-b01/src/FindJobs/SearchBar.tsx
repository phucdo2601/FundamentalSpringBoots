import React, { useState } from "react";
import { MultiInput } from "./MultiInput";
import { dropDownData } from "../Data/Data";
import { Divider, RangeSlider } from "@mantine/core";

const SearchBar = () => {
  const [value, setValue] = useState<[number, number]>([1, 1000]);

  return (
    <>
      <div className="flex px-5 py-8">
        {dropDownData.map((item, index) => (
          <>
            <div className="w-1/5">
              <MultiInput {...item} />
            </div>

            <Divider mr={`xs`} size="xs" orientation="vertical" />
          </>
        ))}
        <div className="w-1/5 [&_.mantine-Slider-label]:!translate-y-10">
          <div className="flex text-sm justify-between">
            <div className="">Salary</div>
            <div className="">
              &#36; {value[0]}USD - &#36; {value[1]}USD
            </div>
          </div>

          <RangeSlider
            color="brightSun.4"
            size={`xs`}
            value={value}
            onChange={setValue}
            labelTransitionProps={{
              transition: "skew-down",
              duration: 150,
              timingFunction: "linear",
            }}
            labelAlwaysOn
          />
        </div>
      </div>
    </>
  );
};

export default SearchBar;
