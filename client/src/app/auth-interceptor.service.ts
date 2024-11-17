import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthInterceptorService implements HttpInterceptor {
  constructor(private router: Router) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    console.log('in interceptor ', req);
    return next.handle(req).pipe(
      tap((event) => {
        if (event instanceof HttpResponse) {
          console.log('Response received by the client:', event);
        }
      }),
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401) {
          console.log(
            'Unauthorized access detected. Redirecting to login page...'
          );
          this.router.navigate(['/login']);
        }
        return throwError(error);
      })
    );
  }
}
