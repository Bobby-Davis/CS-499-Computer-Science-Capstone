package com.animals.rescue.repository;

import com.animals.rescue.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {

    // query to find all animals by their type (species)
    List<Animal> findByType(String type);

    // query to find all animals that are "in service" and not reserved (available)
    List<Animal> findByTrainingStatusAndReserved(String trainingStatus, boolean reserved);

    // query to find an animal type that is "in service" and not reserved (available)
    List<Animal> findByTypeAndTrainingStatusAndReserved(String type, String trainingStatus, boolean reserved);
    
}
