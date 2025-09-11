import axios from "axios";

export const BASE_URL = "http://localhost:8084/api/";

export const basicCallApi = () => {
    const instance = axios.create({
        baseURL: BASE_URL,
        headers: {
            "Content-Type": "application/json"
       },

    });

    // instance.interceptors.request.use((config: any) => {
    //     return config;
    // })

    return instance;
}