import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/admin/categories'

class AdminCategoryService  {
    getCategories(){
        return axios.get(USER_API_BASE_URL);
    }

    createCategory(category){
        return axios.post(USER_API_BASE_URL, category);
    }

    getCategoryById(cateId){
        return axios.get(USER_API_BASE_URL + '/' + cateId);
    }

    updateCategory(category, cateId){
        return axios.put(USER_API_BASE_URL + '/' +cateId, category);
    }

    deleteCategory(cateId){
        return axios.delete(USER_API_BASE_URL + "/" +cateId);
    }

    deleteCategoryOriginal(cateId){
        return axios.put(USER_API_BASE_URL + "/delO/"+cateId)
    }
}

export default new AdminCategoryService()