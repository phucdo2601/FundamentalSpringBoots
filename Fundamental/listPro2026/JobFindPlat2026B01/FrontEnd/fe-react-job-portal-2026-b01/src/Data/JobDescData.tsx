import {
  IconBriefcase,
  IconMapPin,
  IconPremiumRights,
  IconRecharging,
} from "@tabler/icons-react";
import { JobDesCardModel } from "../Model/MockModel/JobDescModel";

const card = [
  {
    name: "Location",
    icon: IconMapPin,
    value: "New York",
  },
  {
    name: "Experience",
    icon: IconBriefcase,
    value: "Expert",
  },
  {
    name: "Salary",
    icon: IconPremiumRights,
    value: "1000 USD",
  },
  {
    name: "Job Type",
    icon: IconRecharging,
    value: "Full Time",
  },
] as JobDesCardModel[];

const skills = [
  "React",
  "Spring Boot",
  "Java",
  "Python",
  "Node.js",
  "MongoDB",
  "Express",
  "Django",
  "PostgreSQL",
] as string[];

const desc = "<h4>About the job</h4>";

export { card, skills, desc };
