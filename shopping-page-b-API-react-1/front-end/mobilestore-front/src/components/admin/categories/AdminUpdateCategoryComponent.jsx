import React, { Component } from 'react'
import AdminCategoryService from "../../../services/admin/AdminCategoryService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

export class AdminUpdateCategoryComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cateId: this.props.match.params.id,
            cateName: "",
            description: "",
        };
        this.changeCateIdHandle = this.changeCateIdHandle.bind(this);
        this.changeCateNameHandle = this.changeCateNameHandle.bind(this);
        this.changeDescriptionHandle = this.changeDescriptionHandle.bind(this);
    }

    componentDidMount() {
        if (this.state.cateId == -1) {
            return;
        }

        AdminCategoryService.getCategoryById(this.state.cateId).then((res) => {
            let category = res.data;
            this.setState({
                cateId: category.cateId,
                cateName: category.cateName,
                description: category.description,
            });
        });
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

    adminUpdateCategory = (event) => {
        event.preventDefault();

        let category = {
            cateId: this.state.cateId,
            cateName: this.state.cateName,
            description: this.state.description,
        };

        console.log("user => " + JSON.stringify(category));
        AdminCategoryService.updateCategory(category, this.state.cateId).then((res) => {
            this.props.history.push("/admin/aCategory/categories");
        });
    }

    cancel() {
        this.props.history.push("/admin/aCategory/categories");
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <div className="component">
                    <form style={{ width: 700, margin: 'auto', marginTop: 20, marginBottom: 20 }}>
                        <div className="title">
                            <h1>Update Category</h1>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Category ID:
                            </label> <input placeholder="Category Id" name="cateId" className="form-control"
                                value={this.state.cateId} onChange={this.changeCateIdHandle} readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Category
                                Name:</label> <input name="cateName"
                                    value={this.state.cateName} onChange={this.changeCateNameHandle}
                                    className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
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
                                value={this.state.description}
                                onChange={this.changeDescriptionHandle}
                                className="form-control"
                                id="exampleInputEmail1"
                                aria-describedby="emailHelp"
                            />
                        </div>


                        <button className="btn btn-primary" onClick={this.adminUpdateCategory}>Update</button>

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

export default AdminUpdateCategoryComponent
