import React from "react";
import ProfileComp from "../Profile/ProfileComp";
import { profile } from "../Data/TalentData";

const ProfilePage = () => {
  return (
    <>
      <div className="min-h-[100vh] bg-mine-shaft-800 font-['poppins'] p-4 overflow-hidden">
        <ProfileComp profile={profile} />
      </div>
    </>
  );
};

export default ProfilePage;
