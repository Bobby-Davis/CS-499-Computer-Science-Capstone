package com.animals.rescue.controller;

import com.animals.rescue.model.Animal;
import com.animals.rescue.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "*")  // Allow calls from angular frontend
public class AnimalController {
    

    @Autowired
    private AnimalService animalService;

    // Get all animals
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Get animal by ID
    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable String id) {
        return animalService.getAnimalById(id);
    }

    // Create new animal
    @PostMapping 
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    // Update animal
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable String id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    // Delete animal
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable String id) {
        animalService.deleteAnimal(id);
    }

    // Get available animals by type
    @GetMapping("/available")
    public List<Animal> getAvailaAnimals(@RequestParam String type) {
        return animalService.getAvailableAnimals(type);
    }
    
}
