import { PostedJobModel } from "../Model/MockModel/PostedJobModel";

const activeJobs = [
  {
    jobTitle: "DevOps Engineer",
    location: "Berlin, Germany",
    posted: "4 days ago",
  },

  {
    jobTitle: "Mobile App Developer",
    location: "Austin, USA",

    posted: "J days ago",
  },

  {
    jobTitle: "Data Analyst",
    location: "Mumbai, India",
    posted: "6 days ago",
  },

  {
    jobTitle: "Cloud Architect",
    location: "Dublin, Ireland",
    posted: "3 days ago",
  },
  {
    jobTitle: "Front End Developer",
    location: "New York, USA",
    posted: "7 days ago",
  },
] as PostedJobModel[];

const drafts = [
  {
    joblitle: "Junior Web Developer",
    location: "Nem York, USA",
    posted: "3 days ago",
  },

  {
    joblitle: "ML Engineer",
    location: "Toronto, Canada",
    posted: "6 days ago",
  },
  {
    jobTitle: "DevOps Specialist",
    location: "Amsterdam, Netherlands",
    posted: "2 days ago",
  },
] as PostedJobModel[];

export { activeJobs, drafts };
