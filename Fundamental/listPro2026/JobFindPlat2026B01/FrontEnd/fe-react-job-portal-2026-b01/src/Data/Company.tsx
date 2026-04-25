import {
  CompanyModel,
  SimilarCompanyModel,
} from "../Model/MockModel/CompanyModel";

const companyData = {
  Name: "Google",
  Overview:
    "Google is a global leader in technology, specializing in internet-related services and products. Our mission is to organize the worlds information and make it universally accessible and useful. Founded by Larry Page and Sergey Brin, Google has grown into one of the most influential companies in the world, providing innovative tools and services that help billions of people across the globe.",
  Industry: "Internet, Software & Technology Services",
  Website: "https://www.google.com",
  Size: "100,000+ Employees",
  Headquarters: "Mountain View, California, United States",
  Specialties: [
    "Search Engine",
    "Online Advertising",
    "Cloud Computing",
    "Software",
    "Hardware",
    "AI & Machine Learning",
    "Mobile Operating Systems",
    "Consumer Electronic",
  ],
};

const similarCompany = [
  { name: "Adobe", employees: "1000" },
  { name: "Amazon", employees: "2000" },
  { name: "Apple", employees: "3000" },
  { name: "Google", employees: "4000" },
  { name: "Meta", employees: "5000" },
  { name: "Microsoft", employees: "6000" },
  { name: "Netflix", employees: "7000" },
  { name: "Spotify", employees: "8000" },
] as SimilarCompanyModel[];

export { companyData, similarCompany };
