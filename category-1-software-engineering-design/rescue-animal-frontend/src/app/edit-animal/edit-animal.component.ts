import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AnimalService, Animal } from '../services/animal.service';

@Component({
  selector: 'app-edit-animal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-animal.component.html',
  styleUrl: './edit-animal.component.css'
})
export class EditAnimalComponent implements OnInit {
  mode: 'add' | 'edit' = 'add';
  animalId: string = '';
  animal: Animal = {} as Animal;
  errorMessage: string = '';

  // For dog-specific dropdown handling
  selectedBreed: string = '';
  customBreed: string = '';

  // For monkey-specific dropdown
  selectedSpecies: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private animalService: AnimalService
  ) {}

  getEmptyAnimal(): Animal {
  return {
    name: '',
    type: 'Dog',
    breedOrSpecies: '',
    gender: 'Male',
    age: 0,
    weight: 0,
    acquisitionDate: '',
    trainingStatus: 'intake',
    reserved: false,
    inServiceLocation: 'USA',
    image: '',

    // Optional monkey fields
    height: undefined,
    tailLength: undefined,
    bodyLength: undefined
  };
}

  ngOnInit(): void {
  const id = this.route.snapshot.paramMap.get('id');
  if (id) {
    this.mode = 'edit';
    this.animalId = id;
    this.loadAnimal();
  } else {
    this.mode = 'add';
    this.animal = this.getEmptyAnimal();
  }
}


  // Load specific animal based on ID and set dropdown defaults
  loadAnimal(): void {
    this.animalService.getAnimals().subscribe({
      next: (animals) => {
        const found = animals.find(a => a.id === this.animalId);
        if (found) {
          this.animal = found;

          if (this.animal?.type === 'dog') {
            const knownBreeds = ['Labrador', 'German Shepard', 'Pit Bull', 'Golden Retriever'];
            if (knownBreeds.includes(this.animal.breedOrSpecies)) {
              this.selectedBreed = this.animal.breedOrSpecies;
            } else {
              this.selectedBreed = 'Other';
              this.customBreed = this.animal.breedOrSpecies;
            }
          }

          if (this.animal?.type === 'monkey') {
            this.selectedSpecies = this.animal.breedOrSpecies;
          }
        } else {
          this.errorMessage = 'Animal not found.';
        }
      },
      error: () => {
        this.errorMessage = 'Failed to load animal data.';
      }
    });
  }

  // Handle breed dropdown changes (dog)
  onBreedChange(): void {
    this.animal.breedOrSpecies = this.selectedBreed === 'Other' ? this.customBreed : this.selectedBreed;
  }

  // Handle species dropdown changes (monkey)
  onSpeciesChange(): void {
    this.animal!.breedOrSpecies = this.selectedSpecies;
  }

  // Update the animal data in the backend
  onSubmit(): void {
    this.onBreedChange(); // Sync breed/species before saving

    if (this.mode === 'edit') {
      this.animalService.updateAnimal(this.animalId, this.animal).subscribe({
        next: () => this.router.navigate(['/rescue-animals']),  // Navigate back after successful update
        error: () => this.errorMessage = 'Update failed.'
      });
    } else {
      this.animalService.addAnimal(this.animal).subscribe({
        next: () => this.router.navigate(['/rescue-animals']),
        error: () => this.errorMessage = 'Add failed.'
      });
    }
  }

}
