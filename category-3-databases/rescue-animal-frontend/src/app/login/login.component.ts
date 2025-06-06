import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';


@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

    constructor(private authService: AuthService, private router: Router) {}


  onLogin() {
    const credentials = { username: this.username, password: this.password };

    this.authService.login(credentials).subscribe({
      next: (success) => {
        if (success) {
          // Save login state
          localStorage.setItem('loggedIn', 'true');
          this.router.navigate(['/']); // redirect to home
        } else {
          this.errorMessage = 'Invalid credentials.';
        }
      },
      error: () => {
        this.errorMessage = 'Login failed. Try again.';
      }
    });
  }
}
