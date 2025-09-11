import { basicCallApi } from "./baseUrl";

const getAllGeneralRolesList = async () => {
    return await basicCallApi().get(`api/v1/generalRole/`);
}

const GeneralRoleApi = {
    getAllGeneralRolesList
};

export default GeneralRoleApi;