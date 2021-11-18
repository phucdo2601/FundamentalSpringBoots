import React, { Component } from 'react'
import AdminDiscountOfUserService from "../../../services/admin/AdminDiscountOfUserService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminUpdateDiscountOfUserComponent extends Component {
    constructor(props){
        super(props);
        this.state={
            discountId : this.props.match.params.id,
            discountName : "",
            rateDis : "",
            description : "",
        };
    }

    componentDidMount(){
        if (this.state.discountId == -1) {
            return;
        }

        AdminDiscountOfUserService.getDiscountOfUserById(this.state.discountId).then((res) =>{
            let discountOfUser = res.data;
            this.setState({
                discountId : discountOfUser.discountId,
            discountName : discountOfUser.discountName,
            rateDis : discountOfUser.rateDis,
            description : discountOfUser.description,
            })
        })
    }

    changeDiscountIdHandle = (event) => {
        this.setState({ discountId: event.target.value })
    }

    changeDiscountNameHandle = (event) => {
        this.setState({ discountName: event.target.value })
    }

    changeRateDisHandle = (event) => {
        this.setState({ rateDis: event.target.value })
    }

    changeDescriptionHandle = (event) => {
        this.setState({ description: event.target.value })
    }

    cancel(){
        this.props.history.push("/admin/aDiscountOfUser/discountOfUser");
    }

    adminUpdateDiscountOfUser = (event) => {
        event.preventDefault();

        let discountOfUser = {
            discountId : this.state.discountId,
            discountName : this.state.discountName,
            rateDis : this.state.rateDis,
            description : this.state.description,
        }

        AdminDiscountOfUserService.updateDiscountOfUser(discountOfUser, this.state.discountId).then((res) =>{
            this.props.history.push("/admin/aDiscountOfUser/discountOfUser");
        })
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                    <div className="component">
                    <form style={{ width: 700, margin: 'auto', marginTop: 20, marginBottom: 20 }}>
                        <div className="title">
                            <h1>Update Discount Of User</h1>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Discount ID:
                            </label> <input  name="itemId" 
                            value={this.state.discountId}
                            onChange={this.changeDiscountIdHandle}
                            className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly/>
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Discount
                                Name:</label> <input name="itemName" 
                                value={this.state.discountName}
                                onChange={this.changeDiscountNameHandle}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Cate
                                Id:</label> <input name="cateId" 
                                value={this.state.rateDis}
                                onChange={this.changeRateDisHandle}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputPassword1" className="form-label">Description</label>
                            <input name="description" 
                            value={this.state.description}
                            onChange={this.changeDescriptionHandle}
                            className="form-control" id="exampleInputPassword1" />
                        </div>
                        <button className="btn btn-primary" onClick={this.adminUpdateDiscountOfUser} >Save</button>

                        <button
                            className="btn btn-danger"
                            onClick={this.cancel.bind(this)}
                            style={{ marginLeft: "10px" }}
                        >
                            Cancel
                        </button>
                    </form>
                </div>
                <FooterComponent />
            </div>
        )
    }
}

export default AdminUpdateDiscountOfUserComponent
