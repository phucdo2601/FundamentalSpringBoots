import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/admin/users';

class AdminUserService {
    getListUser(){
        return axios.get(USER_API_BASE_URL);
    }

    getUserById(userId){
        return axios.get(USER_API_BASE_URL + "/"+userId);
    }

    banUserByUserId(userId){
        return axios.put(USER_API_BASE_URL + "/delO/"+userId);
    }

    reActivateUserByUserId(userId){
        return axios.put(USER_API_BASE_URL + "/reActO/"+userId);
    }
}

export default new AdminUserService();