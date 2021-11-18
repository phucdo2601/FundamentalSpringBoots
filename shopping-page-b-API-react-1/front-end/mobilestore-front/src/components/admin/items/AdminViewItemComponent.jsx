import React, { Component } from 'react';
import AdminItemService from '../../../services/admin/AdminItemService';
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminViewItemComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            itemId: this.props.match.params.id,
            item: {}
        }
    }

    componentDidMount() {
        AdminItemService.getItemById(this.state.itemId).then((res) => {
            this.setState({ item: res.data })
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
                            <h1>View Item</h1>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Item ID:
                            </label> <input placeholder="Item Id" name="itemId" className="form-control"
                                value={this.state.item.itemId} readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Item
                                Name:</label> <input name="itemName"
                                    value={this.state.item.itemName}
                                    className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Cate
                                ID:</label> <input name="cateId"
                                    value={this.state.item.cateId}
                                    className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Price:</label> <input name="price"
                                value={this.state.item.price}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Quantity:</label> <input name="quantity"
                                value={this.state.item.quantity}
                                className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>


                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">
                                Description:
                            </label>

                            <input
                                name="description"
                                placeholder="Description"
                                value={this.state.item.description}

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
                </div>
                <FooterComponent />
            </div>
        )
    }
}

export default AdminViewItemComponent
