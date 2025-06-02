import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  menuOpen = false;
  username: string | null = null;

  constructor(private authService: AuthService) {}

  toggleMenu(): void {
    this.menuOpen = !this.menuOpen;
  }

  ngOnInit(): void {
    this.authService.username$.subscribe(name => {
      this.username = name;
    });
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  // Logs user out and refreshes page
  logout(): void {
    this.authService.logout();
    window.location.reload();
  }
}
