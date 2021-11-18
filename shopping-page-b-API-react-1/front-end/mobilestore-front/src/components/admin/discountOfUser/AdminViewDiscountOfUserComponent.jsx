import React, { Component } from 'react'
import AdminDiscountOfUserService from "../../../services/admin/AdminDiscountOfUserService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";
class AdminViewDiscountOfUserComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            discountId : this.props.match.params.id,
            discountOfUser: {}
        }
    }

    componentDidMount() {
        AdminDiscountOfUserService.getDiscountOfUserById(this.state.discountId).then((res) => {
            this.setState({ discountOfUser: res.data })
        })
    }

    cancel() {
        this.props.history.push("/admin/aDiscountOfUser/discountOfUser");
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
                        <label htmlFor="exampleInputEmail1" className="form-label">Discount ID:
                        </label> <input placeholder="Discount Id" name="cateId" className="form-control"
                            value={this.state.discountOfUser.discountId} readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Discount
                            Name:</label> <input name="cateName" placeholder="Discount Name"
                                value={this.state.discountOfUser.discountName}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Discount
                            Rate:</label> <input name="cateName" placeholder="Discount Rate"
                                value={this.state.discountOfUser.rateDis}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">Discount
                            Create Or Update:</label> <input name="cateName" placeholder="Date Of Creating or updating"
                                value={this.state.discountOfUser.dateOfCreate}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                        <div id="emailHelp" className="form-text">We'll never share your
                            email with anyone else.</div>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleInputEmail1" className="form-label">
                            Description:
                        </label>

                        <input
                            name="cateName"
                            placeholder="Description"
                            value={this.state.discountOfUser.description}

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
                        Move To Categories Page
                    </button>
                </form>

                <FooterComponent />
            </div>
        )
    }
}

export default AdminViewDiscountOfUserComponent
