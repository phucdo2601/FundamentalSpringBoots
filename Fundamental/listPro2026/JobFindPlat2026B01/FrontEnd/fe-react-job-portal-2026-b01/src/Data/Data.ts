import {
  IconBriefcase,
  IconMapPin,
  IconRecharging,
  IconSearch,
} from "@tabler/icons-react";

const companies = [
  "Amazon",
  "Figma",
  "Google",
  "Meta",
  "Microsoft",
  "Netflix",
  "Oracle",
  "Pinterest",
  "Slack",
  "Spotify",
  "Walmart",
];

const jobCategories = [
  {
    name: "ArtAndDesign",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "ContentWriting",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "CustomerSupervisor",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "DataEntry",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "DigitalMarketing",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "Finance",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "HumanResource",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "Sales",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "UI-UX-Designer",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
  {
    name: "web-developer",
    desc: "Lorem Ipsum is simply dummy text of the printing",
    jobs: 1,
  },
];

const work = [
  {
    name: "Build your resume",
    desc: "Create a standout resume with your profile",
    imgName: "BuildYourResume",
  },
  {
    name: "Apply for job",
    desc: "Find and apply for jobs that match your skills.",
    imgName: "ApplyForJob",
  },
  {
    name: "Get Hired",
    desc: "Connect with employers and start your new job.",
    imgName: "GetHired",
  },
];

const testimonials = [
  {
    name: "user-employee-01",
    testimonial:
      "This job portal made job searhc easy and quick. Recommended to all job seekers!",
    rating: 5,
  },
  {
    name: "user-employee-02",
    testimonial:
      "Found my dream job within a week! The application process was smooth.",
    rating: 5,
  },
  {
    name: "user-employee-03",
    testimonial: "This platform is very convenient!",
    rating: 5,
  },
  { name: "user-employee-04", testimonial: "This is so fantastic!", rating: 5 },
];

const footerLinks = [
  { title: "Product", links: ["Find Job", "Find Company", "Find Employee"] },
  {
    title: "Company",
    links: ["About Us", "Contact Us", "Privacy Policy", "Terms & Conditions"],
  },
  { title: "Support", links: ["Help & Support", "Feedback", "FAQs"] },
];

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

export {
  companies,
  jobCategories,
  work,
  testimonials,
  footerLinks,
  dropDownData,
};
