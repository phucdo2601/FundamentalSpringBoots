import {
  Button,
  CheckIcon,
  Divider,
  FileInput,
  LoadingOverlay,
  Notification,
  NumberInput,
  rem,
  Textarea,
  TextInput,
} from "@mantine/core";
import { IconBookmark, IconPaperclip } from "@tabler/icons-react";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const ApplyJobComp = () => {
  const [preview, setPreview] = useState(false);

  const [submit, setSubmit] = useState(false);

  const [sec, setSec] = useState(5);

  const navigate = useNavigate();

  const handlePreview = () => {
    setPreview(!preview);
    window.scrollTo({
      top: 0,
      behavior: "smooth",
    });
  };

  const handleSubmit = () => {
    setSubmit(true);
    let x = 5;
    setInterval(() => {
      x--;
      setSec(x);

      if (x == 0) {
        navigate(`/find-jobs`);
      }
    }, 1000);
  };

  return (
    <>
      <div className="w-2/3 mx-auto">
        <LoadingOverlay
          className="!fixed"
          visible={submit}
          zIndex={1000}
          overlayProps={{ radius: "sm", blur: 2 }}
          loaderProps={{
            color: "brightSun.4",
            type: "bars",
          }}
        />
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
        </div>
        <Divider my={`xl`} />
        <div className="text-xl font-semibold mb-5">
          Submit your application
        </div>
        <div className="flex flex-col gap-5">
          <div className="flex gap-10 [&>*]:w-1/2">
            <TextInput
              readOnly={preview}
              variant={preview ? "unstyled" : "default"}
              className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
              label="Full name"
              withAsterisk
              placeholder="Enter Name"
            />
            <TextInput
              readOnly={preview}
              variant={preview ? "unstyled" : "default"}
              className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
              label="Email"
              withAsterisk
              placeholder="Enter email"
            />
            <NumberInput
              readOnly={preview}
              variant={preview ? "unstyled" : "default"}
              className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
              label="Phone Number"
              withAsterisk
              placeholder="Enter Phone Number"
              hideControls
              minLength={8}
              maxLength={10}
              clampBehavior="strict"
            />
            <TextInput
              readOnly={preview}
              variant={preview ? "unstyled" : "default"}
              className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
              label="Personal Website"
              withAsterisk
              placeholder="Enter Url"
            />
          </div>

          <FileInput
            readOnly={preview}
            variant={preview ? "unstyled" : "default"}
            className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
            withAsterisk
            leftSection={<IconPaperclip stroke={1.5} />}
            label="Attach Your CV"
            placeholder="Your CV"
            leftSectionPointerEvents="none"
          />

          <Textarea
            readOnly={preview}
            variant={preview ? "unstyled" : "default"}
            className={`${preview} ? "text-mine-shaft-300 font-semibold" :""`}
            withAsterisk
            placeholder="Type something about yourself"
            label="Cover Letter"
            autosize
            minRows={3}
          />

          {!preview && (
            <>
              <Button
                color="brightSun.4"
                variant="light"
                onClick={handlePreview}
              >
                Preview
              </Button>
            </>
          )}

          {preview && (
            <>
              <div className="flex gap-10 [&>*]:w-1/2">
                <Button
                  fullWidth
                  color="brightSun.4"
                  variant="outline"
                  onClick={handlePreview}
                >
                  Edit
                </Button>

                <Button
                  fullWidth
                  color="brightSun.4"
                  variant="light"
                  onClick={handleSubmit}
                >
                  Submit
                </Button>
              </div>
            </>
          )}
        </div>
      </div>

      <Notification
        icon={
          <CheckIcon
            style={{
              width: rem(20),
              height: rem(20),
            }}
          />
        }
        className={`!border-bright-sun-400 -translate-y-20 !fixed top-0 left-[35%] z-[1001] transition duration-300 ease-in-out ${submit ? "translate-y-0" : "-translate-y-20"}`}
        color="teal"
        withBorder
        title="Application Submitted!"
        mt={`md`}
        withCloseButton={false}
      >
        Redirection to Find Jobs in {sec} seconds...
      </Notification>
    </>
  );
};

export default ApplyJobComp;
