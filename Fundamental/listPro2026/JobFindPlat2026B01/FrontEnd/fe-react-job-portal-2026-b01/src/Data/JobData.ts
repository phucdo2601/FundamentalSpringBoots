import {
  IconBriefcase,
  IconMapPin,
  IconRecharging,
  IconSearch,
} from "@tabler/icons-react";
import { MockJobModel } from "../Model/MockModel/MockJobModel";

const dropDownData = [
  {
    title: "Job Title",
    icon: IconSearch,
    options: [
      "Designer",
      "Developer",
      "Product Manager",
      "Marketing Speacialist",
      "Data Analyst",
      "Sales Execlutive",
      "Content writer",
      "Customer Support",
    ],
  },
  {
    title: "Location",
    icon: IconMapPin,
    options: [
      "Delhi",
      "New York",
      "San Francisco",
      "London",
      "Berlin",
      "Tokyo",
      "Sydney",
      "Toronto",
      "Viet Nam",
    ],
  },
  {
    title: "Experience",
    icon: IconBriefcase,
    options: ["Entry Level", "Intermediate", "Expert"],
  },
  {
    title: "Job Type",
    icon: IconRecharging,
    options: ["Full Time", "Part Time", "Contract", "Freelance", "Intership"],
  },
];

const jobList: MockJobModel[] = [
  {
    jobTitle: "Product Designer",
    company: "Meta",
    applicants: 25,
    experience: "Entry Level",
    jobType: "Full-Time",
    location: "New York",
    package: "500 USD",
    postedDayAgo: 12,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Product Designer",
    company: "Microsoft",
    applicants: 25,
    experience: "Entry Level",
    jobType: "Full-Time",
    location: "New York",
    package: "500 USD",
    postedDayAgo: 12,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Sr. UX designer",
    company: "Netflix",
    applicants: 30,
    experience: "Expert",
    jobType: "Full-Time",
    location: "Singapor",
    package: "600 USD",
    postedDayAgo: 17,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Product Designer",
    company: "Apple",
    applicants: 25,
    experience: "Entry Level",
    jobType: "Full-Time",
    location: "New York",
    package: "500 USD",
    postedDayAgo: 12,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Product Designer",
    company: "Amazon",
    applicants: 25,
    experience: "Entry Level",
    jobType: "Full-Time",
    location: "New York",
    package: "500 USD",
    postedDayAgo: 12,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Junior System designer",
    company: "Adobe",
    applicants: 40,
    experience: "Experience",
    jobType: "Remote",
    location: "Malaysia",
    package: "400 USD",
    postedDayAgo: 11,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Sr System Maintemaince",
    company: "Spotify",
    applicants: 18,
    experience: "Expert",
    jobType: "Full-Time",
    location: "Silicon Valley",
    package: "1000 USD",
    postedDayAgo: 18,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
  {
    jobTitle: "Business Analyst",
    company: "Google",
    applicants: 11,
    experience: "Experience",
    jobType: "Hybrid",
    location: "London",
    package: "700 USD",
    postedDayAgo: 3,
    description:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
  },
];

export { dropDownData, jobList };
