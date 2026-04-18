import { IconMapPin, IconRecharging, IconSearch } from "@tabler/icons-react";
import {
  SearchFieldsTalentModel,
  TalentModel,
} from "../Model/MockModel/MockTalentModel";
import { ProfileModel } from "../Model/MockModel/ProfileModel";

const searchFields: SearchFieldsTalentModel[] = [
  {
    title: "Job Title",
    icon: IconSearch,
    options: [
      "Designer",
      "Developer",
      "Product Manager",
      "Marketing Speacialist",
      "Data Analyst",
      "Sale Executive",
      "Content Writer",
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
    title: "Skills",
    icon: IconRecharging,
    options: [
      // Core Programming & Development
      "Data Structures and Algorithms",
      "Object-Oriented Programming (OOP)",
      "Functional Programming",
      "Test-Driven Development (TDD)",
      "Code Refactoring",
      "API Design (REST, GraphQL, gRPC)",
      "Microservices Architecture",
      "Serverless Computing",

      // Web & Frontend
      "HTML5",
      "CSS3/SASS",
      "JavaScript (ES6+)",
      "TypeScript",
      "React/Angular/Vue.js",
      "State Management (Redux, Vuex)",
      "Responsive Design",
      "Web Performance Optimization",

      // Backend & Databases
      "Node.js/Python/Java/Go/C#",
      "Relational Databases (PostgreSQL, MySQL, Oracle)",
      "NoSQL Databases (MongoDB, Redis, Cassandra)",
      "Database Indexing and Query Optimization",
      "ORM (Sequelize, TypeORM, Hibernate)",
      "Caching Strategies",

      // DevOps & Infrastructure
      "Git / Version Control",
      "CI/CD Pipelines (Jenkins, GitHub Actions, GitLab CI)",
      "Docker / Containerization",
      "Kubernetes / Orchestration",
      "Infrastructure as Code (Terraform, Ansible)",
      "Cloud Platforms (AWS, Azure, GCP)",
      "Linux/Unix Administration",
      "Monitoring and Logging (ELK Stack, Prometheus, Grafana)",

      // Security & Quality Assurance
      "OAuth2 / OpenID Connect",
      "Web Security (OWASP Top 10)",
      "Unit, Integration, and End-to-End Testing",
      "Static Code Analysis",
      "Load Testing",

      // Soft Skills & Methodology
      "Agile / Scrum / Kanban",
      "System Design and Scalability",
      "Technical Documentation",
      "Code Review",
      "Problem Solving",
      "Communication and Collaboration",
      "Time Management",
      "Mentoring and Leadership",
    ],
  },
];

const talents: TalentModel[] = [
  {
    name: "Jarrod Wood",
    role: "Software Engineer",
    company: "Google",
    topSkills: ["React", "SpringBoot", "MongoDB"],
    about:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    expectedCtc: "2000 - 3000 USD",
    location: "New York",
    image: "Avartar",
  },

  {
    name: "Evan Chu",
    role: "Data Analyst",
    company: "Adobe",
    topSkills: ["Relationship Database Management", "NO SQL", "ERD Skills"],
    about:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    expectedCtc: "1500 - 5000 USD",
    location: "Singapore",
    image: "Avartar",
  },
];

const profile = {
  name: "Phuc Do Ngoc",
  role: "Software Engineer",
  company: "ABC Company",
  location: "Viet Nam",
  about: "I am a ",
  skills: ["Java", "Reactjs", "React Native"],
  experience: [
    {
      title: "Java Developer",
      company: "Spotify",
      location: "UK",
      startDate: "2017-12-01",
      endDate: "2019-12-31",
      description: "test-desc-b01",
    },
    {
      title: "Software Developer",
      company: "Google",
      location: "UK",
      startDate: "2019-12-31",
      endDate: "2023-12-31",
      description: "test-desc-b02",
    },
    {
      title: "Remote Software Developer",
      company: "Amazon",
      location: "Singapore",
      startDate: "2024-01-31",
      endDate: "",
      description: "test-desc-b03",
    },
  ],
  certifications: [
    {
      name: "Java-cert-b01",
      issuer: "Adobe",
      issueDate: "2019-01-01",
      certificateId: "12312123",
    },
    {
      name: "Cloud-cert-b01",
      issuer: "Google",
      issueDate: "2019-01-01",
      certificateId: "12312123",
    },
  ],
} as ProfileModel;

export { searchFields, talents, profile };
