import React, { Component } from 'react';
import AdminUserService from "../../../services/admin/AdminUserService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminViewUserComponent extends Component {
    constructor(props) {
        super(props);
        this.state={
            userId : this.props.match.params.id,
            user: {},
        };
    }

    componentDidMount() {
        AdminUserService.getUserById(this.state.userId).then((res) => {
            this.setState({ user: res.data })
        })
    }

    cancel() {
        this.props.history.push("/admin/aUser/users");
    }

    render() {
        return (
            <div>
                <HeaderComponent />

                <form style={{ width: 700, margin: 'auto', marginTop: 20, marginBottom: 20 }}>
                    <div className="title">
                        <h1>View Discount Detail</h1>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">User ID:
                        </label> <input placeholder="Discount Id" name="cateId" className="form-control"
                            value={this.state.user.userId} readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Full
                            Name:</label> <input name="cateName" placeholder="Discount Name"
                                value={this.state.user.fullName}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Phone:</label> <input name="cateName" placeholder="Discount Rate"
                                value={this.state.user.phone}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Email:</label> <input name="cateName" placeholder="Discount Rate"
                                value={this.state.user.email}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Address:</label> <input name="cateName" placeholder="Discount Rate"
                                value={this.state.user.address}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">User
                            Create Or Update:</label> <input name="cateName" placeholder="Date Of Creating or updating"
                                value={this.state.user.dateOfCreate}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">
                            Status:
                        </label>

                        <input
                            name="cateName"
                            placeholder="Description"
                            value={this.state.user.status}

                            className="form-control"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp" readOnly
                        />
                    </div>

                    <button
                        className="btn btn-danger"
                        onClick={this.cancel.bind(this)}
                        style={{ marginLeft: "10px" }}
                    >
                        Move To Users Page
                    </button>
                </form>

                <FooterComponent />
            </div>
        )
    }
}

export default AdminViewUserComponent
