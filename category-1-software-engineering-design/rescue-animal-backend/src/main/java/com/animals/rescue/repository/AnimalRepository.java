package com.animals.rescue.repository;

import com.animals.rescue.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {
    List<Animal> findByType(String type);
    List<Animal> findByTrainingStatusAndReserved(String trainingStatus, boolean reserved);
    List<Animal> findByTypeAndTrainingStatusAndReserved(String type, String trainingStatus, boolean reserved);
    
}
