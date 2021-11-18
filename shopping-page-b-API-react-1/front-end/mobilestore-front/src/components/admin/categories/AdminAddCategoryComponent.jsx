import React, { Component } from "react";
import AdminCategoryService from "../../../services/admin/AdminCategoryService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminAddCategoryComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cateId: "",
            cateName: "",
            description: "",
        };
    }

    changeCateIdHandle = (event) => {
        this.setState({ cateId: event.target.value });
    };

    changeCateNameHandle = (event) => {
        this.setState({ cateName: event.target.value });
    };

    changeDescriptionHandle = (event) => {
        this.setState({ description: event.target.value });
    };

    adminSaveCategory = (event) => {
        event.preventDefault();

        let category = {
            cateId: this.state.cateId,
            cateName: this.state.cateName,
            description: this.state.description,
        };

        AdminCategoryService.createCategory(category).then((res) => {
            this.props.history.push("/admin/aCategory/categories");
        });
    };

    cancel() {
        this.props.history.push("/admin/aCategory/categories");
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <div className="component">
                    <form
                        style={{
                            width: 700,
                            margin: "auto",
                            marginTop: 20,
                            marginBottom: 20,
                        }}
                    >
                        <div className="title">
                            <h1>Add New Items</h1>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">
                                Item ID:
                            </label>{" "}
                            <input
                                placeholder="Category Id"
                                name="cateId"
                                className="form-control"
                                value={this.state.cateId}
                                onChange={this.changeCateIdHandle}
                            />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">
                                Category Name:
                            </label>

                            <input
                                name="cateName"
                                placeholder="Category Name"
                                value={this.state.cateName}
                                onChange={this.changeCateNameHandle}
                                className="form-control"
                                id="exampleInputEmail1"
                                aria-describedby="emailHelp"
                            />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">
                                Description:
                            </label>

                            <input
                                name="cateName"
                                placeholder="Description"
                                value={this.state.description}
                                onChange={this.changeDescriptionHandle}
                                className="form-control"
                                id="exampleInputEmail1"
                                aria-describedby="emailHelp"
                            />
                        </div>

                        <button
                            className="btn btn-success"
                            onClick={this.adminSaveCategory}
                        >
                            Save
                        </button>

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
        );
    }
}

export default AdminAddCategoryComponent;
