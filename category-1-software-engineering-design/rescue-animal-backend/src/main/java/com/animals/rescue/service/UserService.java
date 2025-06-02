package com.animals.rescue.service;

import com.animals.rescue.model.User;
import com.animals.rescue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    // Register a new user
    public boolean register(User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return false; // Username is taken
        }

        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    // Authenticate a user
    public boolean authenticate(String username, String rawPassword) {
        Optional<User> found = userRepository.findByUsername(username);

        // Check that the user exists and the password matches
        return found.isPresent() && passwordEncoder.matches(rawPassword, found.get().getPassword());
    }
}
