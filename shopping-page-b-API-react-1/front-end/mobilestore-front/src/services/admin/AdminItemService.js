import axios from "axios";

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/admin/items'

class AdminItemService {

    getItems(){
        return axios.get(USER_API_BASE_URL);
    }

    createItem(item){
        return axios.post(USER_API_BASE_URL, item);
    }

    getItemById(itemId){
        return axios.get(USER_API_BASE_URL +"/"+itemId);
    }

    updateItemById(item, itemId){
        return axios.put(USER_API_BASE_URL +"/"+itemId, item);
    }

    deleteItem(itemId){
        return axios.delete(USER_API_BASE_URL +"/"+itemId);
    }

    deleteItemOriginal(itemId){
        return axios.put(USER_API_BASE_URL + "/delO/" +itemId);
    }
}

export default new AdminItemService();