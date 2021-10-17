import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import ListUserComponents from "./components/ListUserComponents";
import AddUserComponent  from "./components/AddUserComponent";
import ViewUserComponent from "./components/ViewUserComponent";
import CreateNewUserComponent from "./components/CreateNewUserComponent";


function App() {
  return (
    <Router>
      <div className="container">
        <HeaderComponent />
          <Switch>
          <Route path="/" exact component={ListUserComponents}></Route>
          <Route path="/aUser/users" component={ListUserComponents}></Route>
          <Route path="/aUser/edit-user/:id" component={AddUserComponent}></Route>
          <Route path="/aUser/view-user/:id" component={ViewUserComponent}></Route>
          <Route path="/aUser/add-new-user" component={CreateNewUserComponent}></Route>
          </Switch>
        <FooterComponent />
      </div>
    </Router>
  );
}

export default App;
