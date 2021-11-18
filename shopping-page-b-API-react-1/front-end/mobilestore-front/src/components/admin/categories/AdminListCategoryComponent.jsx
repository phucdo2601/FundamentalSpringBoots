import React, { Component } from "react";
import AdminCategoryService from "../../../services/admin/AdminCategoryService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";
class AdminListCategoryComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            categories: [],
        };

        this.adminAddCategory = this.adminAddCategory.bind(this);

    }

    componentDidMount() {
        AdminCategoryService.getCategories().then((res) => {
            this.setState({ categories: res.data });
        });
    }

    adminAddCategory(){
        this.props.history.push('/admin/aCategory/add-new-cate');
    }

    adminViewCategory(cateId){
        this.props.history.push(`/admin/aCategory/view-cate/${cateId}`)
    }

    adminEditCategory(cateId){
        this.props.history.push(`/admin/aCategory/edit-cate/${cateId}`)
    }

    adminDeleteCategory(cateId){
        AdminCategoryService.deleteCategoryOriginal(cateId).then((res) => {
            this.setState({ 
                categories: this.state.categories.filter(category => category.cateId !== cateId)

             });
        })
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <h2 className="text-center">Category List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.adminAddCategory}>
                        Add Category
                    </button>
                </div>
                <div className="row">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Category Id</th>
                                <th scope="col">Category Name</th>
                                <th scope="col">Date Of Creating Or Updating</th>
                                <th scope="col">Description</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.categories.map(
                                    category =>
                                        <tr key={category.cateId}>
                                            <td scope="row">1</td>
                                            <td>{category.cateId}</td>
                                            <td>{category.cateName}</td>
                                            <td>{category.dateOfCreate}</td>
                                            <td>{category.description}</td>
                                            <td>
                                                <button onClick={() => this.adminEditCategory(category.cateId)}
                                                    className="btn btn-info">
                                                    Update
                                                </button>

                                                <button style={{marginLeft: "10px"}} onClick={() => this.adminDeleteCategory(category.cateId)}
                                                    className="btn btn-danger">
                                                    Delete
                                                </button>

                                                <button style={{marginLeft: "10px"}} onClick={() => this.adminViewCategory(category.cateId)}
                                                    className="btn btn-success">
                                                    View
                                                </button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
                <FooterComponent />
            </div>
        );
    }
}

export default AdminListCategoryComponent;
