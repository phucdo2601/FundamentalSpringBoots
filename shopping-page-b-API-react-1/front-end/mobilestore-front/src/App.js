import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import AdminManagementComponent from "./components/admin/AdminManagementComponent"
import AListCategoryComponent from "./components/admin/categories/AdminListCategoryComponent";
import AAddCategoryComponent from "./components/admin/categories/AdminAddCategoryComponent";
import AUpdateCategortComponent from "./components/admin/categories/AdminUpdateCategoryComponent";
import AViewCategoryComponent from "./components/admin/categories/AdminViewCategoryComponent";
import AListItemComponent from "./components/admin/items/AdminListItemComponent";
import AAddItemComponent from "./components/admin/items/AdminAddItemComponent";
import AUpdateItemComponent from "./components/admin/items/AdminUpdateItemComponent";
import AViewItemComponent from "./components/admin/items/AdminViewItemComponent";
import AListDiscountOfUserComponent from "./components/admin/discountOfUser/AdminListDiscountOfUserComponent";
import AAddDiscountOfUserComponent from "./components/admin/discountOfUser/AdminAddDiscountOfUserComponent";
import AUpdateDiscountOfUserComponent from "./components/admin/discountOfUser/AdminUpdateDiscountOfUserComponent";
import AViewDiscountOfUserComponent from "./components/admin/discountOfUser/AdminViewDiscountOfUserComponent";
import AListUserComponent from "./components/admin/users/AdminListUserComponent";
import AViewUserComponent from "./components/admin/users/AdminViewUserComponent";
import AListBookingComponent from "./components/admin/bookings/AdminListBookingComponent";
import AViewBookingDetailComponent from "./components/admin/bookings/AdminViewBookingDetailComponent";

function App() {
  return (
    <Router>
    <div className="component">
      
          <Switch>
            <Route path="/" exact component={AdminManagementComponent}></Route>
            <Route path="/admin/managePage" exact component={AdminManagementComponent}></Route>
            <Route path="/admin/aCategory/categories" component={AListCategoryComponent}></Route>
            <Route path="/admin/aCategory/add-new-cate" component={AAddCategoryComponent}></Route>
            <Route path="/admin/aCategory/edit-cate/:id" component={AUpdateCategortComponent}></Route>
            <Route path="/admin/aCategory/view-cate/:id" component={AViewCategoryComponent}></Route>
            <Route path="/admin/aItem/items" component={AListItemComponent}></Route>
            <Route path="/admin/aItem/add-new-item" component={AAddItemComponent}></Route>
            <Route path="/admin/aItem/view-item/:id" component={AViewItemComponent}></Route>
            <Route path="/admin/aItem/edit-item/:id" component={AUpdateItemComponent}></Route>
            <Route path="/admin/aDiscountOfUser/discountOfUser" component={AListDiscountOfUserComponent}></Route>
            <Route path="/admin/aDiscountOfUser/add-new-disOfUser" component={AAddDiscountOfUserComponent}></Route>
            <Route path="/admin/aDiscountOfUser/view-disOfUser/:id" component={AViewDiscountOfUserComponent}></Route>
            <Route path="/admin/aDiscountOfUser/edit-disOfUser/:id" component={AUpdateDiscountOfUserComponent}></Route>
            <Route path="/admin/aUser/users" component={AListUserComponent}></Route>
            <Route path="/admin/aUser/view-user/:id" component={AViewUserComponent}></Route>
            <Route path="/admin/aBooking/bookings" component={AListBookingComponent}></Route>
            <Route path="/admin/aBooking/view-booking-de/:id" component={AViewBookingDetailComponent}></Route>
          </Switch>
      
    </div>
    </Router>
  );
}

export default App;
