import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map, catchError, of, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usernameSubject = new BehaviorSubject<string | null>(localStorage.getItem('username'));
  username$ = this.usernameSubject.asObservable();


  constructor(private http: HttpClient) {}

  login(credentials: { username: string; password: string }): Observable<boolean> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<{ token: string }>(
      'http://localhost:8081/login',
      credentials,
      { headers }
    ).pipe(
      map(response => {
        localStorage.setItem('jwtToken', response.token);
        localStorage.setItem('loggedIn', 'true');

        // Save username
        localStorage.setItem('username', credentials.username);
        this.usernameSubject.next(credentials.username);

        return true;
      }),
      catchError(() => of(false))
    );
  }


  // Clears the token and login flag to log out the user
  logout() {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('loggedIn');
    localStorage.removeItem('username');
    this.usernameSubject.next(null); //clear username
  }

  // Checks if the user is logged in by seeing if a token exists
  isLoggedIn(): boolean {
    return !!localStorage.getItem('jwtToken');
  }
}
