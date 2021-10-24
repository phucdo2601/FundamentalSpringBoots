import axios from "axios";

const USER_BASE_URI = "http://localhost:8080";

class UploadFileService {

    uploadFile(file, onUploadProgress) {
        let formData = new FormData();
        formData.append("file", file);

        return axios.post(USER_BASE_URI + "/upload", formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            onUploadProgress,
        });

    }

    getFiles() {
        return axios.get(USER_BASE_URI + "/files");
    }
}

export default new UploadFileService();