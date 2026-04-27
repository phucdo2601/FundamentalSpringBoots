import {
  ActionIcon,
  Button,
  Divider,
  TagsInput,
  Textarea,
} from "@mantine/core";
import {
  IconBriefcase,
  IconDeviceFloppy,
  IconMapPin,
  IconPencil,
  IconPlus,
} from "@tabler/icons-react";
import { profile } from "console";
import React, { use, useState } from "react";
import ExpCard from "./ExpCard";
import CertiCard from "./CertiCard";
import { ProfileModel } from "../Model/MockModel/ProfileModel";
import { fields } from "../Data/Profile";
import SelectInput from "./SelectInput";
import ExpInput from "./ExpInput";
import CertInput from "./CertInput";

interface ProfileProps {
  profile: ProfileModel;
}

const ProfileComp = ({ profile }: ProfileProps) => {
  const [edit, setEdit] = useState([false, false, false, false, false]);
  const [addExp, setAddExp] = useState(false);

  const [addCerti, setAddCerti] = useState(false);

  const [about, setAbout] = useState("Test About");

  const [skills, setSkills] = useState<string[]>([
    "Java",
    "Reactjs",
    "React Native",
  ]);

  const selects = fields;

  const handleEdit = (index: any) => {
    const newEdit = [...edit];
    newEdit[index] = !newEdit[index];
    setEdit(newEdit);
    console.log(edit);
  };

  return (
    <>
      <div className="w-4/5 mx-auto">
        <div className="relative">
          <img className="rounded-t-2xl" src="/Profile/banner.jpg" alt="" />
          <img
            className="w-48 h-48 rounded-full -bottom-1/3 absolute left-3 border-mine-shaft-950 border-8"
            src="/Avartar.png"
            alt=""
          />
        </div>
        <div className="px-3 mt-16">
          <div className="text-3xl font-semibold flex justify-between">
            {profile.name}
            <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
              {edit[0] ? (
                <>
                  <IconDeviceFloppy
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(0)}
                  />
                </>
              ) : (
                <>
                  <IconPencil
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(0)}
                  />
                </>
              )}
            </ActionIcon>
          </div>

          {edit[0] ? (
            <>
              <div className="flex gap-10 [&>*]:w-1/2">
                <SelectInput props={selects[0]} />
                <SelectInput props={selects[1]} />
              </div>

              <SelectInput props={selects[2]} />
            </>
          ) : (
            <>
              <div className="text-lg flex gap-1 items-center">
                <IconBriefcase className="h-5 w-5" stroke={1.5} />{" "}
                {profile.role} &bull; {profile.company}
              </div>
              <div className="flex gap-1 text-xs items-center text-mine-shaft-400">
                <IconMapPin className="h-5 w-5" stroke={1.5} />{" "}
                {profile.location}
              </div>
            </>
          )}
        </div>

        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-3 flex justify-between">
            About
            <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
              {edit[1] ? (
                <>
                  <IconDeviceFloppy
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(1)}
                  />
                </>
              ) : (
                <>
                  <IconPencil
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(1)}
                  />
                </>
              )}
            </ActionIcon>
          </div>

          {edit[1] ? (
            <>
              <Textarea
                value={about}
                autosize
                minRows={2}
                placeholder="Enter about yourself..."
                onChange={(event) => setAbout(event.currentTarget.value)}
              />
            </>
          ) : (
            <>
              <div className="text-sm text-mine-shaft-300 text-justify">
                {profile.about}
              </div>
            </>
          )}
        </div>

        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-3 flex justify-between">
            Skills
            <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
              {edit[2] ? (
                <>
                  <IconDeviceFloppy
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(2)}
                  />
                </>
              ) : (
                <>
                  <IconPencil
                    className="h-4/5 w-4/5"
                    onClick={() => handleEdit(2)}
                  />
                </>
              )}
            </ActionIcon>
          </div>

          {edit[2] ? (
            <>
              <TagsInput
                placeholder="Add Skill"
                splitChars={[",", " ", "|"]}
                value={skills}
                onChange={setSkills}
              />
            </>
          ) : (
            <>
              <div className="flex flex-wrap gap-2">
                {skills.map((skill: string, index: number) => (
                  <>
                    <div className="bg-bright-sun-300 text-sm font-semibold bg-opacity-15 rounded-3xl text-bright-sun-400 px-3 py-1">
                      {skill}
                    </div>
                  </>
                ))}
              </div>
            </>
          )}
        </div>
        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-5 flex justify-between">
            Experience
            <div className="flex gap-2">
              <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
                <>
                  <IconPlus
                    className="h-4/5 w-4/5"
                    onClick={() => setAddExp(true)}
                  />
                </>
              </ActionIcon>

              <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
                {edit[3] ? (
                  <>
                    <IconDeviceFloppy
                      className="h-4/5 w-4/5"
                      onClick={() => handleEdit(3)}
                    />
                  </>
                ) : (
                  <>
                    <IconPencil
                      className="h-4/5 w-4/5"
                      onClick={() => handleEdit(3)}
                    />
                  </>
                )}
              </ActionIcon>
            </div>
          </div>
          <div className="flex flex-col gap-8">
            {profile.experience?.map((exp, index) => (
              <>
                <ExpCard experience={exp} edit={edit[3]} />
              </>
            ))}
            {addExp && (
              <>
                <ExpInput setEdit={setAddExp} add={true} />
              </>
            )}
          </div>
        </div>
        <Divider mx={`xs`} my={`xl`} />
        <div className="px-3">
          <div className="text-2xl font-semibold mb-5 flex justify-between">
            Certifications
            <div className="flex gap-2">
              <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
                <>
                  <IconPlus
                    className="h-4/5 w-4/5"
                    onClick={() => setAddCerti(true)}
                  />
                </>
              </ActionIcon>

              <ActionIcon color="brightSun.4" variant="subtle" size={`lg`}>
                {edit[4] ? (
                  <>
                    <IconDeviceFloppy
                      className="h-4/5 w-4/5"
                      onClick={() => handleEdit(4)}
                    />
                  </>
                ) : (
                  <>
                    <IconPencil
                      className="h-4/5 w-4/5"
                      onClick={() => handleEdit(4)}
                    />
                  </>
                )}
              </ActionIcon>
            </div>
          </div>

          <div className="flex flex-col gap-8">
            {profile.certifications?.map((cert, index) => (
              <>
                <CertiCard certProp={cert} edit={edit[4]} />
              </>
            ))}
            {addCerti && (
              <>
                <CertInput setEdit={setAddCerti} add={true} />
              </>
            )}
          </div>
        </div>
      </div>
    </>
  );
};

export default ProfileComp;
