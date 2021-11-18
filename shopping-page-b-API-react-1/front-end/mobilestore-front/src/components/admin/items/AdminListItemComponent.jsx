import React, { Component } from "react";
import AdminItemService from "../../../services/admin/AdminItemService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

export class AdminListItemComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
        };

        this.adminAddItem = this.adminAddItem.bind(this);
        this.adminViewItem = this.adminViewItem.bind(this);
        this.adminEditItem = this.adminEditItem.bind(this);
        this.adminDeleteItem = this.adminDeleteItem.bind(this);
    }

    componentDidMount() {
        AdminItemService.getItems().then((res) => {
            this.setState({ items: res.data });
        });
    }

    adminAddItem() {
        this.props.history.push("/admin/aItem/add-new-item");
    }

    adminViewItem(itemId) {
        this.props.history.push(`/admin/aItem/view-item/${itemId}`);
    }

    adminEditItem(itemId) {
        this.props.history.push(`/admin/aItem/edit-item/${itemId}`);
    }

    adminDeleteItem(itemId) {
        AdminItemService.deleteItemOriginal(itemId).then((res) => {
            this.setState({
                items: this.state.items.filter((item) => item.itemId !== itemId),
            });
        });
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <div className="component">
                    <h2 className="text-center">Item List</h2>
                    <div className="row">
                        <button className="btn btn-primary" onClick={this.adminAddItem}>
                            Add Category
                        </button>
                    </div>
                    <div className="row">
                        <table className="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Item Id</th>
                                    <th scope="col">Item Name</th>
                                    <th scope="col">Cate Id</th>

                                    <th scope="col">Author</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.items.map((item) => (
                                    <tr key={item.itemId}>
                                        <td scope="row">1</td>
                                        <td>{item.itemId}</td>
                                        <td>{item.itemName}</td>
                                        <td>{item.cateId}</td>
                                        <td>{item.author}</td>

                                        <td>{item.price}</td>
                                        <td>{item.quantity}</td>
                                        <td>
                                            <button
                                                onClick={() => this.adminEditItem(item.itemId)}
                                                className="btn btn-info"
                                            >
                                                Update
                                            </button>

                                            <button
                                                style={{ marginLeft: "10px" }}
                                                onClick={() => this.adminDeleteItem(item.itemId)}
                                                className="btn btn-danger"
                                            >
                                                Delete
                                            </button>

                                            <button
                                                style={{ marginLeft: "10px" }}
                                                onClick={() => this.adminViewItem(item.itemId)}
                                                className="btn btn-success"
                                            >
                                                View
                                            </button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
                <FooterComponent />
            </div>
        );
    }
}

export default AdminListItemComponent;
