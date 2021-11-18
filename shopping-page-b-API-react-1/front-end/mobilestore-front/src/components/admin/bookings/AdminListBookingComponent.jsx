import React, { Component } from 'react';
import AdminBookingService from '../../../services/admin/AdminBookingService';
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminListBookingComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            booking : [],
        };
    }

    componentDidMount() {
        AdminBookingService.getListBookings().then((res) =>{
            this.setState({ booking: res.data })
        });
    }

    adminViewBookingById(bookingId){
        this.props.history.push(`/admin/aBooking/view-booking-de/${bookingId}`);
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <h1>List of Bookings</h1>

                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Booking Id</th>
                            <th scope="col">User Id</th>
                            <th scope="col">Discount Id</th>
                            <th scope="col">Date Of Booking</th>
                            <th scope="col">Total</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.booking.map(
                                booking =>
                                    <tr key={booking.bookingId}>
                                        <th scope="row">1</th>
                                        <td>{booking.userId}</td>
                                        <td>{booking.bookingId}</td>
                                        <td>{booking.discountId}</td>
                                        <td>{booking.dateOfCreate}</td>
                                        <td>$ {booking.total}</td>
                                        <td>
                                            

                                            <button
                                                style={{ marginLeft: "10px" }}
                                                onClick={() => this.adminViewBookingById(booking.bookingId)}
                                                className="btn btn-success"
                                            >
                                                View
                                            </button>
                                        </td>
                                    </tr>
                            )

                        }

                    </tbody>
                </table>
                <FooterComponent />
            </div>
        )
    }
}

export default AdminListBookingComponent
