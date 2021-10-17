import React, { Component } from 'react'
import UserService from '../services/UserService';

class ListUserComponents extends Component {
    constructor(props){
        super(props)
        this.state = {
            users: []
        }
        this.addUser = this.addUser.bind(this);
        this.editUser = this.editUser.bind(this);
        this.deleteUser = this.deleteUser.bind(this);
    }

    componentDidMount(){
        UserService.getUsers().then((res) =>{
            this.setState({users:res.data});
        });
    }

    addUser() {
        this.props.history.push('/aUser/add-new-user')
    }

    editUser(id) {
        this.props.history.push(`/aUser/edit-user/${id}`)
    }

    viewUser(id) {
        this.props.history.push(`/aUser/view-user/${id}`)
    }
    
    deleteUser(id){
        UserService.deleteUser(id).then(res => {
            this.setState({
                users: this.state.users.filter(user => user.userName !== id)
            });
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">User List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addUser}>Add User</button>
                </div>

                <div className="row">
                <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Employee Account</th>
                                <th>Employee First Name</th>
                                <th>Employee Last Name</th>
                                <th>Employee Mail</th>
                                <th>Action</th>

                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.users.map(
                                    user => 
                                    <tr key={user.userName}>
                                        <td>{user.userName}</td>
                                        <td>{user.fullName}</td>
                                        <td>
                                            <input type="password" name="password" value={user.password} readOnly/>
                                            
                                            </td>
                                        <td>{user.roleId}</td>
                                        <td>
                                            <button onClick = { () => this.editUser(user.userName) }
                                                className="btn btn-info">
                                                    Update
                                            </button>

                                            <button style = {{marginLeft: "10px"}}  onClick = { () => this.deleteUser(user.userName)}
                                                className="btn btn-danger">
                                                    Delete
                                            </button>

                                            <button style = {{marginLeft: "10px"}} onClick = { () => this.viewUser(user.userName)}
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
            </div>
        )
    }
}

export default ListUserComponents
