package com.animals.rescue.controller;

import com.animals.rescue.security.JwtUtil;
import com.animals.rescue.model.User;
import com.animals.rescue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")  //Allow frontend to access
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // LOGIN endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean authenticated = userService.authenticate(user.getUsername(), user.getPassword());

        if (authenticated) {
            // Generate the token using JwtUtil
            String token = jwtUtil.generateToken(user.getUsername());

            // Return the token in the response
        return ResponseEntity.ok().body(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // REGISTER endpoint
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean created = userService.register(user);

        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
    }

}
