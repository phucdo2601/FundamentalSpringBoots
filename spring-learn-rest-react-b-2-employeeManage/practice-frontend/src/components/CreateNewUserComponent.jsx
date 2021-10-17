import React, { Component } from "react";
import UserService from "../services/UserService";

class CreateNewUserComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: "",
      fullName: "",
      password: "",
      roleId: "",
    };
  }

  changeUsernameHandle = (event) => {
    this.setState({ userName: event.target.value });
  };

  changeFullnameHandle = (event) => {
    this.setState({ fullName: event.target.value });
  };

  changePasswordHandle = (event) => {
    this.setState({ password: event.target.value });
  };

  changeRoleHandle = (event) => {
    this.setState({ roleId: event.target.value });
  };

  saveUser = (event) => {
    event.preventDefault();

    let user = {
      userName: this.state.userName,
      fullName: this.state.fullName,
      password: this.state.password,
      roleId: this.state.roleId,
    };

    UserService.createUser(user).then((res) => {
        this.props.history.push("/aUser/users");
      });

  };

  cancel() {
      this.props.history.push("/aUser/users");
  }

  render() {
    return (
        <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
                    <h3 className="text-center">Add New User</h3>
<div className="card-body">
                                    <form>
                                        <div className="form-group">
                                            <label > Account:  </label>
                                            <input placeholder="Account Name" name="userName" className="form-control"
                                                value={this.state.userName} onChange={this.changeUsernameHandle}/>
                                        </div>

                                        <div className="form-group">
                                            <label > Full Name:  </label>
                                            <input placeholder="Full Name" name="fullName" className="form-control"
                                                value={this.state.fullName} onChange={this.changeFullnameHandle}/>
                                        </div>

                                        <div className="form-group">
                                            <label > Password:  </label>
                                            <input placeholder="Password" name="password" className="form-control"
                                                value={this.state.password} onChange={this.changePasswordHandle}/>
                                        </div>

                                        <div className="form-group">
                                            <label > Role:  </label>
                                            <input placeholder="Role" name="roleId" className="form-control"
                                                value={this.state.roleId} onChange={this.changeRoleHandle}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveUser}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>

                                    </form>
                                </div>

            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default CreateNewUserComponent;
