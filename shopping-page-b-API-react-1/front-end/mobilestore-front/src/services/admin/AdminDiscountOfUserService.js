import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/admin/discountOfUser'


class AdminDiscountOfUserService {

    getListDiscountOfUsers(){
        return axios.get(USER_API_BASE_URL)
    }

    createNewDiscountOfUser(discountOfUser){
        return axios.post(USER_API_BASE_URL, discountOfUser)
    }

    getDiscountOfUserById(discountId){
        return axios.get(USER_API_BASE_URL +"/"+discountId);
    }

    updateDiscountOfUser(discountOfUser, discountId){
        return axios.put(USER_API_BASE_URL +"/"+discountId, discountOfUser);
    }

    blockDiscountOfUser(discountId){
        return axios.put(USER_API_BASE_URL +"/delO/"+discountId);
    }

    reActivateDiscountOfUser(discountId){
        return axios.put(USER_API_BASE_URL +"/reActO/"+discountId);
    }
}

export default new AdminDiscountOfUserService();