import React, { Component } from "react";
import UserService from "../services/UserService";

class AddUserComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: this.props.match.params.id,
      fullName: "",
      password: "",
      roleId: "",
    };

    this.changeUsernameHandle = this.changeUsernameHandle.bind(this);
    this.changeFullnameHandle = this.changeFullnameHandle.bind(this);
    this.changePasswordHandle = this.changePasswordHandle.bind(this);
    this.changeRoleHandle = this.changeRoleHandle.bind(this);

  }

  componentDidMount() {
    if (this.state.userName == -1) {
      return;
    }
    UserService.getUserById(this.state.userName).then((res) => {
      let user = res.data;
      this.setState({
        userName: user.userName,
        fullName: user.fullName,
        password: user.password,
        roleId: user.roleId,
      });
    });
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

  saveOrUpdateUser = (e) => {
    e.preventDefault();

    let user = {
        userName: this.state.userName,
      fullName: this.state.fullName,
      password: this.state.password,
      roleId: this.state.roleId,
    };
    console.log("user => " + JSON.stringify(user));

    //step 5:
    if (this.state.userName === "_add") {
      UserService.createUser(user).then((res) => {
        this.props.history.push("/aUser/users");
      });
    } else {
      UserService.updateUser(user, this.state.userName).then((res) => {
        this.props.history.push("/aUser/users/");
      });
    }
  };

  cancel() {
    this.props.history.push("/aUser/users");
  }

  getTitles() {
    if (this.state.userName === "_add") {
      return <h3 className="text-center">Add Employee</h3>;
    } else {
      return <h3>Update Employee</h3>;
    }
  }

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">

                {
                    this.getTitles()
                }

<div className="card-body">
                                    <form>
                                        <div className="form-group">
                                            <label > Account:  </label>
                                            <input placeholder="Account Name" name="userName" className="form-control"
                                                value={this.state.userName} onChange={this.changeUsernameHandle} readOnly/>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUser}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>

                                    </form>
                                </div>

            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default AddUserComponent;
