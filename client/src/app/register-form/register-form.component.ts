import { Component, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css'],
  standalone: true,
  imports: [FormsModule],
})
export class RegisterFormComponent {
  firstname: string = '';
  lastname: string = '';
  username: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    const registerPayload = {
      firstName: 'john',
      lastName: 'doeFromFrontend',
      login: 'login2',
      password: 'password',
    };

    this.http
      .post('http://localhost:8080/register', registerPayload, {
        observe: 'response',
      })
      .subscribe({
        next: (response) => {
          if (response.status === 200) {
            console.log('Register successful');
            this.router.navigate(['/dashboard']);
          }
        },
        error: (error) => {
          console.error('Register failed:', error);
        },
      });
  }
}
