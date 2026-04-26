import React from "react";
import { PostedJobModel } from "../Model/MockModel/PostedJobModel";

interface PostedJobCardProps {
  props: PostedJobModel;
}

const PostedJobCard = ({ props }: PostedJobCardProps) => {
  return (
    <>
      <div className="bg-mine-shaft-800 rounded-xl p-2 border-l-2 border-l-bright-sun-400">
        <div className="text-sm font-semibold">{props.jobTitle}</div>
        <div className="text-xs text-mine-shaft-300 font-medium">
          {props.location}
        </div>
        <div className="text-xs text-mine-shaft-300">{props.posted}</div>
      </div>
    </>
  );
};

export default PostedJobCard;
