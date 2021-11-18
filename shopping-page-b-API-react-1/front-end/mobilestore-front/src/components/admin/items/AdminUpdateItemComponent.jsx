import React, { Component } from 'react';
import AdminItemService from '../../../services/admin/AdminItemService';
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminUpdateItemComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            itemId : this.props.match.params.id,
            itemName : "",
            author:"",
            description:"",
            price:"",
            quantity:"",
            cateId: "",
        }
    }

    componentDidMount() {
        if (this.state.itemId == -1) {
            return;
        }

        AdminItemService.getItemById(this.state.itemId).then((res) => {
            let item = res.data;
            this.setState({ 
                itemId: item.itemId,
                itemName: item.itemName,
                author: item.author,
                description: item.description,
                price: item.price,
                quantity: item.quantity,
                cateId: item.cateId,
             });
        });
    }

    changeItemIdHandle = (event) =>{
        this.setState({ itemId: event.target.value });
    }

    changeItemNameHandle = (event) =>{
        this.setState({ itemName: event.target.value });
    }

    changeAuthorHandle = (event) =>{
        this.setState({ author: event.target.value });
    }

    changeDescriptionHandle = (event) =>{
        this.setState({ description: event.target.value });
    }

    changePriceHandle = (event) =>{
        this.setState({ price: event.target.value });
    }

    changeQuantityHandle = (event) =>{
        this.setState({ quantity: event.target.value });
    }

    changeCateIdHandle = (event) => {
        this.setState({ cateId: event.target.value });
    }

    adminUpdateItem = (event) =>{
        event.preventDefault();

        let item = {
            itemId : this.state.itemId,
            itemName : this.state.itemName,
            author : this.state.author,
            description: this.state.description,
            price: this.state.price,
            quantity: this.state.quantity,
            cateId: this.state.cateId,
        };

        console.log("item => "+JSON.stringify(item));

        AdminItemService.updateItemById(item, this.state.itemId).then((res) =>{
            this.props.history.push("/admin/aItem/items");
        })
    }

    cancel() {
        this.props.history.push("/admin/aItem/items");
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <div className="component">
                    <form style={{ width: 700, margin: 'auto', marginTop: 20, marginBottom: 20 }}>
                        <div className="title">
                            <h1>Update Item</h1>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Item ID:
                            </label> <input  name="itemId" 
                            value={this.state.itemId}
                            onChange={this.changeItemIdHandle}
                            className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly/>
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Item
                                Name:</label> <input name="itemName" 
                                value={this.state.itemName}
                                onChange={this.changeItemNameHandle}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Cate
                                Id:</label> <input name="cateId" 
                                value={this.state.cateId}
                                onChange={this.changeCateIdHandle}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="form-group">
                            <label htmlFor="exampleFormControlSelect1">Author:</label> <input  name="author" 
                            value={this.state.author}
                            onChange={this.changeAuthorHandle}
                            className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Price</label> 
                            <input name="price" 
                            value={this.state.price}
                            onChange={this.changePriceHandle}
                            className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Quantity</label>
                            <input name="quantity" 
                            value={this.state.quantity}
                            onChange={this.changeQuantityHandle}
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
                        <button className="btn btn-primary" onClick={this.adminUpdateItem} >Save</button>

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

export default AdminUpdateItemComponent
