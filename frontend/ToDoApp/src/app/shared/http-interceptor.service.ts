import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {
  constructor() { }
  // intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
  //   request = request.clone({
  //     setHeaders: {
  //       Authorization: sessionStorage.getItem('token')
  //     }
  //   });
  //   return next.handle(request);
  // }
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
      req = req.clone({
        setHeaders: {
          Authorization: sessionStorage.getItem('token')
        }
      })
      console.log(req)
      
    }
    return next.handle(req);
  }
// intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
//   return next.handle(
//     req.clone({
//       headers: req.headers.append('Authorization', sessionStorage.getItem('token'))
//     })
//   );
// }
}