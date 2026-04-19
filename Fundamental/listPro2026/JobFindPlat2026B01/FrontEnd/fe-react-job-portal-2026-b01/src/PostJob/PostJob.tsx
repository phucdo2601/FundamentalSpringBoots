import React from "react";
import SelectInput from "./SelectInput";
import { fields } from "../Data/PostJob";
import { Button, TagsInput } from "@mantine/core";
import TextEditor from "./TextEditor";
import { IconArrowLeft } from "@tabler/icons-react";

const PostJob = () => {
  const selects = fields;

  return (
    <>
      <div className="w-4/5 mx-auto">
        <div className="text-2xl font-semibold mb-5">Post a Job</div>
        <div className="flex flex-col gap-5">
          <div className="flex gap-10 [&>*]:w-1/2">
            <SelectInput props={selects[0]} />
            <SelectInput props={selects[1]} />
          </div>
          <div className="flex gap-10 [&>*]:w-1/2">
            <SelectInput props={selects[2]} />
            <SelectInput props={selects[3]} />
          </div>
          <div className="flex gap-10 [&>*]:w-1/2">
            <SelectInput props={selects[4]} />
            <SelectInput props={selects[5]} />
          </div>
          <TagsInput
            withAsterisk
            label="Skils"
            placeholder="Enter skills"
            acceptValueOnBlur
            splitChars={[",", " ", "|"]}
            clearable
          />
          <div className="[&_button[data-active='true']]:!text-bright-sun-400 [&_button[data-active='true']]:!bg-bright-sun-400/20">
            <div className="text-sm font-medium">Job Description</div>
            <TextEditor />
          </div>
          <div className="flex gap-4">
            <Button color="brightSun.4" variant="light">
              Publish Job
            </Button>
            <Button color="brightSun.4" variant="outline">
              Save as Draft
            </Button>
          </div>
        </div>
      </div>
    </>
  );
};

export default PostJob;
