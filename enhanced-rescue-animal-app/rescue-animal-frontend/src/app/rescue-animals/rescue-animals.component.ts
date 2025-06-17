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
  sortBy: string = '';                  // Sorting 
  showFilters: boolean = true;

  filterTypes = {
    Dog: false,
    Monkey: false
  }

  filterSizes = {
    small: false,
    medium: false,
    large: false
  };

  ageMin: number | null = null;
  ageMax: number | null = null;
  available: boolean = false;

  currentPage: number = 1;
  itemsPerPage: number = 6;


  constructor(
    private animalService: AnimalService,
    public router: Router
  ) {}

  // Run once when the component loads
  ngOnInit(): void {
    this.applyFilters();
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

  toggleFilters() : void {
    this.showFilters = !this.showFilters;
  }
  applyFilters(): void {
    const queryParams: any = {};

    // Type filter
    const selectedTypes = Object.entries(this.filterTypes)
    .filter(([_, checked]) => checked)
    .map(([type]) => type);
    if (selectedTypes.length > 0) {
      queryParams.types = selectedTypes.join(',');
    } else {
      delete queryParams.types;
    }

    // Size Filter
    const selectedSizes = Object.entries(this.filterSizes)
    .filter(([_, checked]) => checked)
    .map(([size]) => size);
    if (selectedSizes.length > 0) {
      queryParams.sizes = selectedSizes.join(',');
    } else {
      delete queryParams.sizes;
    }

    // Age Filter

    // Add min age if valid, else don't include it
    if (this.ageMin !== null && !isNaN(this.ageMin)) {
      queryParams.ageMin = this.ageMin;
    } else {
      delete queryParams.ageMin;
    }

    // Add max age if valid, else don't include it
    if (this.ageMax !== null && !isNaN(this.ageMax)) {
      queryParams.ageMax = this.ageMax;
    } else {
      delete queryParams.ageMax;
    }

    // Add availability only if checked
    if (this.available) {
      queryParams.available = true;
    } else {
      delete queryParams.available;
    }
    
    if (this.sortBy) {
      queryParams.sortBy = this.sortBy;
    } else {
      delete queryParams.sortBy;
    }

    // Pagination
    queryParams.page = this.currentPage - 1;
    queryParams.pageSize = this.itemsPerPage;

    this.animalService.getFilteredAnimals(queryParams).subscribe({
      next: (data) => {
        this.animals = data;
      },
      error: () => {
        this.errorMessage = 'Failed to load animals.';
      }
    });

  }

  // resets all filters
  resetFilters() {

    // Clear checkbox filters
    this.filterTypes = {
      Dog: false,
      Monkey: false
    };

    this.filterSizes = {
      small: false,
      medium: false,
      large: false
    };

    // Clear age and availablility
    this.ageMin = null;
    this.ageMax = null;
    this.available = false;
    this.sortBy = '';

    // Reload full animal list from backend
    this.loadAnimals();

    window.scrollTo(0,0);
  }

  // Check if user is logged in
  checkLoginStatus(): void {
    const token = localStorage.getItem('jwtToken');
    this.isAdmin = !!token;  // Set to true if token exists
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

  // Pagination controls
  nextPage(): void {
    this.currentPage++;
    this.applyFilters();
  }

  prevPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.applyFilters();
    }
  }
}
