import { PostJobFieldModel } from "../Model/MockModel/PostJobModel";

const fields = [
  {
    label: "Job title",
    placeholder: "Enter a job title",
    options: [
      "Designer",
      "Developer",
      "Product Manager",
      "Makerting Specialist",
      "Data Analyst",
      "Sale Exclusive",
      "Content Writer",
      "Customer Support",
    ],
  },
  {
    label: "Company",
    placeholder: "Enter Company Name",
    options: [
      "Adobe",
      "Amazon",
      "Apple",
      "Google",
      "Meta",
      "Microsoft",
      "Netflix",
      "Spotify",
    ],
  },
  {
    label: "Experience",
    placeholder: "Enter an experience level",
    options: ["Entry Level", "Intermediate", "Expert"],
  },
  {
    label: "Job Type",
    placeholder: "Enter a job type",
    options: ["Full Time", "Part Time", "Contract", "Freelance"],
  },
  {
    label: "Location",
    placeholder: "Enter Job Location",
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
    label: "Salary",
    placeholder: "Enter Salary",
    options: [
      "500 USD",
      "1000 USD",
      "1500 USD",
      "2000 USD",
      "2500 USD",
      "3000 USD",
    ],
  },
] as PostJobFieldModel[];

const content = `<h4>About The Job</h4>
      <p>Write the description here...</p>
      <h4>Responsibilities</h4>
      <ul>
        <li>Add Responsibilities here...</li>
      </ul>
      <h4>Qualifications and Skills sets</h4>
      <ul>
        <li>Add required qualification and skill set here...</li>
      </ul>`;

const content2 =
  "<h4>About The Job</h4><p>Write the description here...</p><h4>Responsibilities</h4><ul><li>Add Responsibilities here...</li></ul><h4>Qualifications and Skills sets</h4><ul><li>Add required qualification and skill set here...</li></ul>";

export { fields, content };
