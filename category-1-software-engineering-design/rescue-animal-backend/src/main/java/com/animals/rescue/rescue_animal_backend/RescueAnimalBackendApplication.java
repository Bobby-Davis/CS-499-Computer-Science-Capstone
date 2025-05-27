package com.animals.rescue.rescue_animal_backend;

import com.animals.rescue.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.animals.rescue.repository.UserRepository;


@SpringBootApplication(scanBasePackages = "com.animals.rescue")
@EnableMongoRepositories(basePackages = "com.animals.rescue.repository")
public class RescueAnimalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RescueAnimalBackendApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            // Check if "testuser" already exists in database
            if (userRepository.findByUsername("testuser").isEmpty()) {
                // Has the test password using BCrypt
                String hashedPassword = new BCryptPasswordEncoder().encode("testpass");

                // Create and save the new user
                User user = new User("testuser", hashedPassword);
                userRepository.save(user);
                System.out.println("Added test user to MongoDB");
            } else {
                System.out.println("Test user already exists");
            }
        };
    }

}
