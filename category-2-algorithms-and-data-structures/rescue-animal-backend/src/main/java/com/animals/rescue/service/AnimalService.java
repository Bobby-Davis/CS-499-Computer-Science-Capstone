package com.animals.rescue.service;

import com.animals.rescue.model.Animal;
import com.animals.rescue.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;          // injects the AnimalRepository to access database methods
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;


    // Get all animals
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Get animal by ID
    public Optional<Animal> getAnimalById(String id) {
        return animalRepository.findById(id);
    }

    // Create new animal
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    // Update existing animal
    public Animal updateAnimal(String id, Animal updatedAnimal) {
        updatedAnimal.setId(id);
        return animalRepository.save(updatedAnimal);
    }

    // Delete animal by ID
    public void deleteAnimal(String id) {
        animalRepository.deleteById(id);
    }

    // Get available animals by type (not reserved and in service)
    public List<Animal> getAvailableAnimals(String type) {
        return animalRepository.findByTypeAndTrainingStatusAndReserved(type, "In Service", false);
    }
}
