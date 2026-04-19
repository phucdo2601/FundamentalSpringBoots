import { Button, Divider } from "@mantine/core";
import { IconArrowLeft } from "@tabler/icons-react";
import React from "react";
import PostJob from "../PostJob/PostJob";

const PostJobPage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-600 font-['poppins'] p-4">
        <PostJob />
      </div>
    </>
  );
};

export default PostJobPage;
