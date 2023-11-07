package com.project.examportal.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.project.examportal.exception.UserFoundException;
import com.project.examportal.model.Role;
import com.project.examportal.model.User;
import com.project.examportal.model.UserRole;
import com.project.examportal.service.UserService;

/**
 * Controller class for user-related operations.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * Constructor for UserController.
     *
     * @param userService           The UserService to handle user-related operations.
     * @param bCryptPasswordEncoder The BCryptPasswordEncoder for password hashing.
     */
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Create a new user.
     *
     * @param user The User object to create.
     * @return The created User object.
     * @throws Exception If there is an issue during user creation.
     */
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        logger.info("Received a request to create a new user: {}", user.getUsername());

        try {
            // Encode the user's password using BCrypt
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

            // Create a set of roles for the user (in this example, a single "NORMAL" role with ID 45)
            Set<UserRole> roles = new HashSet<>();
            Role role = new Role();
            role.setRoleId(45L);
            role.setRoleName("NORMAL");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);

            roles.add(userRole);

            // Call the service to create the user with roles
            User createdUser = this.userService.createUser(user, roles);

            logger.info("User created successfully: {}", user.getUsername());
            return createdUser;
        } catch (Exception e) {
            logger.error("Error creating user: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Get user by username.
     *
     * @param username The username of the user to retrieve.
     * @return The User object with the specified username.
     */
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        logger.info("Received a request to get user by username: {}", username);
        return this.userService.getUser(username);
    }

    /**
     * Delete user by userId.
     *
     * @param userId The ID of the user to delete.
     */
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        logger.info("Received a request to delete user by userId: {}", userId);
        this.userService.deleteUser(userId);
    }

    /**
     * Update user profile by userId.
     *
     * @param userId      The ID of the user to update.
     * @param updatedUser The updated User object.
     * @return The updated User object.
     */
    @PutMapping("/{userId}")
    public User updateUserProfile(@PathVariable("userId") Long userId, @RequestBody User updatedUser) {
        logger.info("Received a request to update user profile for userId: {}", userId);
        return this.userService.updateUserProfile(userId, updatedUser);
    }

    /**
     * Handle UserFoundException.
     *
     * @param ex The UserFoundException to handle.
     * @return A ResponseEntity containing the exception message.
     */
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        logger.error("UserFoundException: {}", ex.getMessage());
        return ResponseEntity.ok(ex.getMessage());
    }

    /**
     * Get a list of all users.
     *
     * @return A list of User objects.
     */
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Received a request to retrieve  all users");
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Test endpoint to welcome users to the backend API.
     *
     * @return A ResponseEntity containing a JSON response with a welcome message.
     */
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        logger.info("Received a request to test the API");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the backend API of Exam-portal");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
