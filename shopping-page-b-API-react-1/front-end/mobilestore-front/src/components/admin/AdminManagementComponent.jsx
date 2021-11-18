import React, { Component } from 'react'
import HeaderComponent from "../../components/admin/HeaderComponent";
import FooterComponent from "../../components/admin/FooterComponent";
class AdminManagementComponent extends Component {
    render() {
        return (
            <div>
                <HeaderComponent />
                <div className="component" style={{ marginTop: 20 }}>
                    <div className="title">
                        <h1>ADMIN Management</h1>
                        <div className="card-group" style={{ marginTop: 20, marginBottom: 20 }}>
                            <div className="card">
                                <img className="card-img-top" src="https://www.marketingtutor.net/wp-content/uploads/2018/06/what-is-a-product.jpg" width="100px" height="100px" alt="Card image cap" />
                                <div className="card-body">
                                    <a href="/admin/aItem/items" className="card-title">
                                        Management Items</a>
                                    <p className="card-text">This is a wider card with supporting text
                                        below as a natural lead-in to additional content. This content is
                                        a little bit longer.</p>
                                    <p className="card-text">
                                        <small className="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                            </div>
                            <div className="card">
                                <img className="card-img-top" src="https://www.studytienganh.vn/upload/2021/06/105605.png" width="100px" height="100px" alt="Card image cap" />
                                <div className="card-body">
                                    <a href="/admin/aCategory/categories" className="card-title">
                                    Management Categories</a>
                                    <p className="card-text">This card has supporting text below as a
                                        natural lead-in to additional content.</p>
                                    <p className="card-text">
                                        <small className="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                            </div>
                            <div className="card">
                                <img className="card-img-top" src="https://sansangduhoc.vn/wp-content/uploads/2017/06/ssdhhoctienganh.jpg" width="100px" height="100px" alt="Card image cap" />
                                <div className="card-body">
                                    <a href="/admin/aDiscountOfUser/discountOfUser" className="card-title">
                                    Management Discounts</a>
                                    <p className="card-text">This is a wider card with supporting text
                                        below as a natural lead-in to additional content. This card has
                                        even longer content than the first to show that equal height
                                        action.</p>
                                    <p className="card-text">
                                        <small className="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                            </div>
                            <div className="card">
                                <img className="card-img-top" src="https://ndgroup.vn/uploads/nguon-ban-hang-order-khong-can-von-1.png" width="100px" height="100px" alt="Card image cap" />
                                <div className="card-body">
                                    <a href="/admin/aBooking/bookings" className="card-title">
                                    Management Orders</a>
                                    <p className="card-text">This is a wider card with supporting text
                                        below as a natural lead-in to additional content. This card has
                                        even longer content than the first to show that equal height
                                        action.</p>
                                    <p className="card-text">
                                        <small className="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <FooterComponent />
            </div>
        )
    }
}

export default AdminManagementComponent
