import axios from "axios";
import { LoginFormRequestDto } from "../models/request/LoginFormRequestDto";
import { BASE_URL, basicCallApi } from "./baseUrl";

const login = async (model: LoginFormRequestDto) => {
    return await axios.post(`http://localhost:8084/api/api/v1/auth/general-login`, model);
}

const AuthApi = {
    login,
}

export default AuthApi;