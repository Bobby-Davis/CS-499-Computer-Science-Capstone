import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Define the structure of an Animal object
export interface Animal {
  id?: string;                  // MongoDB document ID
  name: string;
  type: string;                 // "Dog" or "Monkey"
  breedOrSpecies: string;
  gender: string;
  age: number;
  weight: number;
  acquisitionDate: string;      //string format ("2024-05-24")
  trainingStatus: string;
  reserved: boolean;
  inServiceLocation: string;
  image: string;                // path or URL to image

  // Monkey-specific fields
  height?: number;
  tailLength?: number;
  bodyLength?: number;
}

@Injectable({
  providedIn: 'root'  // makes the service available throughout the app
})
export class AnimalService {
  private apiUrl = 'http://localhost:8081/api/animals';  // backend endpoint

  constructor(private http: HttpClient) {}

  // Helper method to get token from localStorage and attach it to headers
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwtToken');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  // Get all animals (secured)
  getAnimals(): Observable<Animal[]> {
    const headers = this.getAuthHeaders();
    return this.http.get<Animal[]>(this.apiUrl);
  }

  // Add new animal (admin only)
  addAnimal(animal: Animal): Observable<Animal> {
    const headers = this.getAuthHeaders();
    return this.http.post<Animal>(this.apiUrl, animal);
  }

  // Update existing animal
  updateAnimal(id: string, animal: Animal): Observable<Animal> {
    const headers = this.getAuthHeaders();
    return this.http.put<Animal>(`${this.apiUrl}/${id}`, animal);
  }

  // Delete animal
  deleteAnimal(id: string): Observable<void> {
    const headers = this.getAuthHeaders();
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
