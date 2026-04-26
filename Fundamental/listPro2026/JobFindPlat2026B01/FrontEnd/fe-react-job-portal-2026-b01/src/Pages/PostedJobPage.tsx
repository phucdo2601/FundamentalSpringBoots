import { Button, Divider } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import PostedJobComp from "../PostedJob/PostedJobComp";
import PostedJobDesc from "../PostedJob/PostedJobDesc";

const PostedJobPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] px-4">
        <div className="flex gap-5">
          <PostedJobComp />
          <PostedJobDesc />
        </div>
      </div>
    </>
  );
};

export default PostedJobPage;
