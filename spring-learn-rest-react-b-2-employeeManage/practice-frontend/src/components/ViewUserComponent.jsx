import React, { Component } from 'react'
import UserService from '../services/UserService'

class ViewUserComponent extends Component {
    constructor(props){
        super(props)

        this.state={
            id: this.props.match.params.id,
            user: {}
        }
    }

    componentDidMount(){
        UserService.getUserById(this.state.id).then(res => {
            this.setState({user: res.data})
        })    
    }

    render() {
        return (
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h3>View User Details</h3>
                    <div className="card-body">
                        <div className="row">
                           <label>Account:</label>
                            <div style={{marginLeft: "5px"}}> {this.state.user.userName};</div>
                            <br />
                            <label style={{marginLeft: "5px"}}>Fullname:</label>
                            <div style={{marginLeft: "5px"}}> {this.state.user.fullName};</div>
                            <br />
                            <label style={{marginLeft: "5px"}}> Role:</label>
                            <div style={{marginLeft: "5px"}}> {this.state.user.roleId}</div>
                            <br />
                           


                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUserComponent
