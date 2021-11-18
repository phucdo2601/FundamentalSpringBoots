import React, { Component } from 'react';
import AdminBookingService from '../../../services/admin/AdminBookingService';
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminViewBookingDetailComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bookingId: this.props.match.params.id,
            bookingDetail: [],
        };
    }

    componentDidMount() {
        AdminBookingService.getDetailOfBookingById(this.state.bookingId).then((res) => {
            this.setState({ bookingDetail: res.data })
        })
    }

    cancel() {
        this.props.history.push("/admin/aBooking/bookings");
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <h1>View Booking Detail</h1>

                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Booking Detail Id</th>
                            <th scope="col">Booking Id</th>
                            <th scope="col">Item Id</th>
                            <th scope="col">Item Name</th>
                            <th scope="col">Unit Price</th>
                            <th scope="col">Quantity</th>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.bookingDetail.map(
                                bookingDetail =>
                                    <tr key={bookingDetail.bookingDeId}>
                                        <th scope="row">1</th>
                                        <td>{bookingDetail.bookingDeId}</td>
                                        <td>{bookingDetail.bookingId}</td>
                                        <td>{bookingDetail.itemId}</td>
                                        <td>{bookingDetail.itemName}</td>
                                        <td>$ {bookingDetail.price}</td>
                                        <td>
                                            {bookingDetail.quantity}
                                        </td>
                                    </tr>
                            )

                        }

                    </tbody>
                </table>

                <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                >
                    Move To Categories Page
                </button>

                <FooterComponent />
            </div>
        )
    }
}

export default AdminViewBookingDetailComponent
