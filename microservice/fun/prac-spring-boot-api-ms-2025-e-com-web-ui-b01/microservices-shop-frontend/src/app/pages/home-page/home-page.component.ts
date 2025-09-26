import { AsyncPipe, JsonPipe } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { ProductService } from '../../services/product/product.service';
import { OrderService } from '../../services/order/order.service';
import { Router } from '@angular/router';
import { Product } from '../../model/product.model';
import { Order } from '../../model/order.model';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit{
  private readonly oidcSecurityService = inject(OidcSecurityService);
  private readonly productService = inject(ProductService);
  private readonly orderService = inject(OrderService);
  private readonly router = inject(Router);
  isAuthenticated = false;
  products: Array<Product> = [];
  quantityIsNull = false;
  orderSuccess = false;
  orderFailed = false;

  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({isAuthenticated}) => {
        this.isAuthenticated = isAuthenticated;
        this.productService.getProducts()
        .pipe()
        .subscribe(product => {
          this.products = product;
        })
      }
    );
    console.log(this.products.length);

  }

  goToCreateProductPage() {
    this.router.navigateByUrl("/add-product");
  }

  orderProduct(product: Product, quantity: string) {
    this.oidcSecurityService.userData$.subscribe(result => {
      console.log(result);
      const userDetails = {
        email: result.userData.email,
        firstName: result.userData.given_name,
        lastName:result.userData.family_data
      };
      if (!quantity) {
        this.orderFailed = true;
        this.orderSuccess = false;
        this.quantityIsNull = true;
      } else {
        const order: Order = {
          skuCode: product.skuCode,
          price: product.price,
          quantity: Number(quantity),
          userDetails: userDetails
        }

        this.orderService.orderProduct(order).subscribe(() => {
          this.orderSuccess = true;
        }, error => {
          this.orderFailed = false
        });
      }
    });
  }
}
