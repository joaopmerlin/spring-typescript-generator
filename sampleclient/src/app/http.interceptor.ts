import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Inject, Injectable, PLATFORM_ID} from '@angular/core';
import 'rxjs/add/operator/do';
import {isPlatformBrowser} from '@angular/common';

@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({
      url: `http://localhost:8080${req.url}`
    });

    return next.handle(req);
  }
}
