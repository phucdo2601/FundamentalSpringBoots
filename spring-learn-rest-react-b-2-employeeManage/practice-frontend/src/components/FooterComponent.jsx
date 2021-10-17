import React, { Component } from "react";

export default class FooterComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <footer className="footer text-center">
            <span className="text-muted">
                All rights Reverved 2021 @PhucDo
            </span>
        </footer>
      </div>
    );
  }
}
