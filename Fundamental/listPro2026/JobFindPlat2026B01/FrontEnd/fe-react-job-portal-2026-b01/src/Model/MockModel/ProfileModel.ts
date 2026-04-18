export interface ProfileModel {
  name?: string;
  role?: string;
  company?: string;
  location?: string;
  about?: string;
  skills?: string[];
  experience?: ExperienceModel[];
  certifications?: CertificationModel[];
}

export interface ExperienceModel {
  title?: string;
  company?: string;
  location?: string;
  startDate?: string;
  endDate?: string;
  description?: string;
}

export interface CertificationModel {
  name?: string;
  issuer?: string;
  issueDate: string;
  certificateId: string;
}
