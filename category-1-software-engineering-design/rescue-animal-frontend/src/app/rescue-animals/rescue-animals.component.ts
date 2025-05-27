import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AnimalService, Animal } from '../services/animal.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rescue-animals',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rescue-animals.component.html',
  styleUrl: './rescue-animals.component.css'
})
export class RescueAnimalsComponent implements OnInit {

  animals: Animal[] = [];               // Full list of animals from the backend
  expandedCardIndex: number | null = null;
  selectedType: string = 'all';         // Filter for dropdown
  isAdmin: boolean = false;             // Controls visibility of admin buttons
  errorMessage: string = '';            // Optional error message display

  constructor(
    private animalService: AnimalService,
    public router: Router
  ) {}

  // Run once when the component loads
  ngOnInit(): void {
    this.loadAnimals();
    this.checkLoginStatus();
  }

  // Load animals from the backend
  loadAnimals(): void {
    this.animalService.getAnimals().subscribe({
      next: (data) => {
        console.log('Animals loaded:', data);
        this.animals = data;
      },
      error: () => {
        this.errorMessage = 'Failed to load animals.';
      }
    });
  }

  // Check if user is logged in
  checkLoginStatus(): void {
    const token = localStorage.getItem('jwtToken');
    this.isAdmin = !!token;  // Set to true if token exists
  }

  // Return animals that match the selected type
  get filteredAnimals(): Animal[] {
    if (this.selectedType === 'all') {
      return this.animals;
    }
    return this.animals.filter(animal => animal.type === this.selectedType);
  }

  // Expand or collapse animal card
  toggleDetails(index: number): void {
    this.expandedCardIndex = this.expandedCardIndex === index ? null : index;
  }

  // Delete an animal by ID (admin only)
  deleteAnimal(id: string): void {
    if (confirm('Are you sure you want to delete this animal?')) {
      this.animalService.deleteAnimal(id).subscribe({
        next: () => {
          this.loadAnimals(); // Refresh list after deletion
        },
        error: () => {
          this.errorMessage = 'Failed to delete animal.';
        }
      });
    }
  }

  editAnimal(animal: Animal): void {
    this.router.navigate(['/edit-animal', animal.id]);
}


  // Optional: simulate login/logout for testing UI (can be removed if you use real login system)
  login(): void {
    localStorage.setItem('jwtToken', 'mockToken');
    this.isAdmin = true;
  }

  logout(): void {
    localStorage.removeItem('jwtToken');
    this.isAdmin = false;
  }
}
