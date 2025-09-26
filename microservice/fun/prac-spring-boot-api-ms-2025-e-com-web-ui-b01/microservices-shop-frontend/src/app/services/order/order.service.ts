import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../../model/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  orderProduct(order: Order): Observable<string> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json'
      }),
      responseType: 'text' as 'json'
    };

    return this.httpClient.post<string>('http://localhost:9000/api/order', order, httpOptions);
  }
}
