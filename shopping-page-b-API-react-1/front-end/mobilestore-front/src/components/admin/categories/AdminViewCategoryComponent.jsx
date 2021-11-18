import React, { Component } from 'react';
import AdminCategoryService from "../../../services/admin/AdminCategoryService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminViewCategoryComponent extends Component {
    constructor(props){
        super(props);
        this.state={
            cateId: this.props.match.params.id,
            category:{}
        }
    }

    componentDidMount(){
        AdminCategoryService.getCategoryById(this.state.cateId).then((res) => {
            this.setState({ category : res.data })
        })
    }

    cancel() {
        this.props.history.push("/admin/aCategory/categories");
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <form style={{ width: 700, margin: 'auto', marginTop: 20, marginBottom: 20 }}>
                        <div className="title">
                            <h1>View Category</h1>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Category ID:
                            </label> <input placeholder="Category Id" name="cateId" className="form-control"
                                value={this.state.category.cateId} readOnly />
                            <div id="emailHelp" className="form-text">We'll never share your
                                email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label htmlFor="exampleInputEmail1" className="form-label">Category
                                Name:</label> <input name="cateName"
                                    value={this.state.category.cateName}
                                    className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"readOnly />
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
                                value={this.state.category.description}
                                
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

export default AdminViewCategoryComponent
