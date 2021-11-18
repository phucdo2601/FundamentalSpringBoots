import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/v1/admin/bookings';

class AdminBookingService {
    getListBookings(){
        return axios.get(USER_API_BASE_URL);
    }

    getDetailOfBookingById(bookingId){
        return axios.get(USER_API_BASE_URL +"/"+bookingId);
    }
}

export default new AdminBookingService();