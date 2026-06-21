import axios from "axios";

const base_url = "http://localhost:8080/users";

const registerUser = async (user: any) => {
  return await axios
    .post(`http://localhost:8080/users/register`, user)
    .then((res) => res.data)
    .catch((error) => {
      throw error;
    });
};

const loginUser = async (user: any) => {
  return axios
    .post(`http://localhost:8080/users/login`, user)
    .then((res) => res.data)
    .catch((error) => {
      throw error;
    });
};

const sendOtp = async (email: any) => {
  return axios
    .post(`http://localhost:8080/users/sendOtp/${email}`)
    .then((res) => res.data)
    .catch((error) => {
      throw error;
    });
};

const verifyOtp = (email: any, otp: any) => {
  return axios
    .get(`${base_url}/verifyotp/${email}/${otp}`)
    .then((res) => res.data)
    .catch((error) => {
      throw error;
    });
};

const changePassword = async (email: string, password: string) => {
  return await axios
    .post(`${base_url}/changePassword`, { email, password })
    .then((res) => res.data)
    .catch((error) => {
      throw error;
    });
};

export { registerUser, loginUser, sendOtp, verifyOtp, changePassword };
