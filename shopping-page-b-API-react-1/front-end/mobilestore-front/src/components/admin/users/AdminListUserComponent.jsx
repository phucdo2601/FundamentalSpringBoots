import React, { Component } from 'react';
import AdminUserService from "../../../services/admin/AdminUserService";
import HeaderComponent from "../../../components/admin/HeaderComponent";
import FooterComponent from "../../../components/admin/FooterComponent";

class AdminListUserComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [],
        }
    }

    componentDidMount() {
        AdminUserService.getListUser().then((res) =>{
            this.setState({ users: res.data })
        });
    }

    adminBanUserByUserId(userId){
        AdminUserService.banUserByUserId(userId).then((res) =>{
            this.setState({ users: this.state.users })
            window.location.reload();
        })
    }

    adminUnBanUserByUserId(userId){
        AdminUserService.reActivateUserByUserId(userId).then((res) =>{
            this.setState({ users: this.state.users })
            window.location.reload();
        })
    }

    adminViewUserDetailsByUserId(userId){
        this.props.history.push(`/admin/aUser/view-user/${userId}`);
    }

    render() {
        return (
            <div>
                <HeaderComponent />
                <h1>List Of User</h1>

                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">User Id</th>
                            <th scope="col">Full Name</th>            
                            <th scope="col">Status of User</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                    <tr key={user.userId}>
                                        <th scope="row">1</th>
                                        <td>{user.userId}</td>
                                        <td>{user.fullName}</td>
                                        <td>{user.status}</td>
                                        
                                        <td>

                                            {user.status === 'Active' &&

                                                <button
                                                    style={{ marginLeft: "10px" }}
                                                    onClick={() => this.adminBanUserByUserId(user.userId)}
                                                    className="btn btn-danger"
                                                >
                                                    Ban
                                                </button>
                                            }

                                            {user.status === 'InActive' &&

                                                <button
                                                    style={{ marginLeft: "10px" }}
                                                    onClick={() => this.adminUnBanUserByUserId(user.userId)}
                                                    className="btn btn-warning"
                                                >
                                                    Re-Activate
                                                </button>
                                            }

                                            <button
                                                style={{ marginLeft: "10px" }}
                                                onClick={() => this.adminViewUserDetailsByUserId(user.userId)}
                                                className="btn btn-success"
                                            >
                                                View
                                            </button>
                                        </td>
                                    </tr>
                            )

                        }

                    </tbody>
                </table>

                <FooterComponent />
            </div>
        )
    }
}

export default AdminListUserComponent
