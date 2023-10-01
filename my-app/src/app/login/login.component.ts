import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  loginMessage: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    const loginData = {
      username: this.username,
      password: this.password,
    };

    // const isAuthenticated = true; 
    // if (isAuthenticated) {
    //   this.router.navigate(['/upload']);
    // } else {
    //   this.loginMessage = 'Login failed. Please check your credentials.';
    // }

    this.http.post<any>('/api/login', loginData).subscribe(
      (response) => {
        // Handle successful login response here
        this.router.navigate(['/upload']);
        this.loginMessage = 'Login successful!';
      },
      (error) => {
        // Handle login error here
        this.loginMessage = 'Login failed. Please check your credentials.';
      }
    );
  }
}
