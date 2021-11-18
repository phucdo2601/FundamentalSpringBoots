import React, { Component } from "react";
import AdminDiscountOfUserService from "../../../services/admin/AdminDiscountOfUserService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";
class AdminListDiscountOfUserComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            discountsOfUser: [],
        };

        this.adminAddDiscountOfUser = this.adminAddDiscountOfUser.bind(this);
        this.adminViewDiscountOfUser = this.adminViewDiscountOfUser.bind(this);
        this.adminBanDiscountOfUser = this.adminBanDiscountOfUser.bind(this);
        this.adminUnBanDiscountOfUser = this.adminUnBanDiscountOfUser.bind(this);
        this.adminEditDiscountOfUser = this.adminEditDiscountOfUser.bind(this);
    }

    componentDidMount() {
        AdminDiscountOfUserService.getListDiscountOfUsers().then((res) => {
            this.setState({ discountsOfUser: res.data });
        });
    }

    adminAddDiscountOfUser() {
        this.props.history.push("/admin/aDiscountOfUser/add-new-disOfUser");
    }

    adminViewDiscountOfUser(discountId) {
        this.props.history.push(`/admin/aDiscountOfUser/view-disOfUser/${discountId}`);
    }

    adminEditDiscountOfUser(discountId) {
        this.props.history.push(`/admin/aDiscountOfUser/edit-disOfUser/${discountId}`)
    }

    adminBanDiscountOfUser(discountId) {
        AdminDiscountOfUserService.blockDiscountOfUser(discountId).then((res) => {
            this.setState({
                discountsOfUser: this.state.discountsOfUser

            });
            window.location.reload();
        })
    }

    adminUnBanDiscountOfUser(discountId){
        AdminDiscountOfUserService.reActivateDiscountOfUser(discountId).then((res) => {
            this.setState({
                discountsOfUser: this.state.discountsOfUser

            });
            window.location.reload();
        })
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <h1>List Discount Of User</h1>
                <button className="btn btn-primary" onClick={this.adminAddDiscountOfUser}>
                    Add New Discount Of User
                </button>
                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Discount Id</th>
                            <th scope="col">Discount Name</th>
                            <th scope="col">Rate Of discount</th>
                            <th scope="col">Date Of Create Or Update</th>
                            <th scope="col">Status of Dis</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.discountsOfUser.map(
                                discountOfUser =>
                                    <tr key={discountOfUser.discountId}>
                                        <th scope="row">1</th>
                                        <td>{discountOfUser.discountId}</td>
                                        <td>{discountOfUser.discountName}</td>
                                        <td>{discountOfUser.rateDis}</td>
                                        <td>{discountOfUser.dateOfCreate}</td>
                                        <td>{discountOfUser.status}</td>
                                        <td>
                                            <button
                                                onClick={() => this.adminEditDiscountOfUser(discountOfUser.discountId)}
                                                className="btn btn-info"
                                            >
                                                Update
                                            </button>

                                            {discountOfUser.status === 'Active' &&

                                                <button
                                                    style={{ marginLeft: "10px" }}
                                                    onClick={() => this.adminBanDiscountOfUser(discountOfUser.discountId)}
                                                    className="btn btn-danger"
                                                >
                                                    Ban
                                                </button>
                                            }

                                            {discountOfUser.status === 'InActive' &&

                                                <button
                                                    style={{ marginLeft: "10px" }}
                                                    onClick={() => this.adminUnBanDiscountOfUser(discountOfUser.discountId)}
                                                    className="btn btn-danger"
                                                >
                                                    Un Ban
                                                </button>
                                            }

                                            <button
                                                style={{ marginLeft: "10px" }}
                                                onClick={() => this.adminViewDiscountOfUser(discountOfUser.discountId)}
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
        );
    }
}

export default AdminListDiscountOfUserComponent;
