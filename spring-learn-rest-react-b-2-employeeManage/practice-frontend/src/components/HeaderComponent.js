import React, { Component } from "react";

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <a
                        href="https://www.facebook.com/profile.php?id=100034519140023"
                        className="navbar-brand"
                    >
                        Employee Management
                    </a>
                </nav>
            </div>
        );
    }
}

export default HeaderComponent;
