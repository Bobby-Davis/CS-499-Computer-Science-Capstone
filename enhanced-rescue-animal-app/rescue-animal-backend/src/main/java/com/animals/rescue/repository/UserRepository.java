package com.animals.rescue.repository;

import com.animals.rescue.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    // Query to find User object by their username (Optional safetly handles cases where no user is found)
    Optional<User> findByUsername(String username);
    
}
