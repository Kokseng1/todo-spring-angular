import { Component, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  standalone: true,
  imports: [FormsModule],
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    const loginPayload = {
      login: this.username,
      password: this.password,
    };
    // const csrfToken = this.getCsrfTokenFromCookie('XSRF-TOKEN'); // or the cookie name your backend uses
    // if (csrfToken) {
    //   console.log('csrf token ', csrfToken);
    //   req = req.clone({
    //     setHeaders: {
    //       'X-XSRF-TOKEN': csrfToken,
    //     },
    //   });
    // }

    const csrfToken = document.cookie.replace(
      /(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/,
      '$1'
    );
    console.log(csrfToken);

    this.http
      .post('http://localhost:8080/login', loginPayload, {
        observe: 'response',
      })
      .subscribe({
        next: (response) => {
          if (response.status === 200) {
            console.log('Login successful');
            this.router.navigate(['/dashboard']);
          }
        },
        error: (error) => {
          console.error('Login failed:', error);
          this.errorMessage = 'Invalid username or password';
        },
      });
  }
}
