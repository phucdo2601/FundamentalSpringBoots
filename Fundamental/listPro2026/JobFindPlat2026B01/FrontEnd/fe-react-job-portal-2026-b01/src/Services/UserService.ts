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

export { registerUser, loginUser };
