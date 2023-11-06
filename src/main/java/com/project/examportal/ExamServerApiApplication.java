package com.project.examportal;


import com.project.examportal.exception.UserFoundException;
import com.project.examportal.model.Role;
import com.project.examportal.model.User;
import com.project.examportal.model.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.examportal.repository.QuizRepository;
import com.project.examportal.service.UserService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@Slf4j
public class ExamServerApiApplication {

    public final QuizRepository quizRepository;

    public final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ExamServerApiApplication(QuizRepository quizRepository, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.quizRepository = quizRepository;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamServerApiApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        try {
            log.info("Starting the application");
            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setUsername("Admin");
            user.setPassword(this.bCryptPasswordEncoder.encode("access"));
            user.setEmail("admin@gmail.com");
            log.info("User object created: {}", user);

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");
            log.info("Role object created: {}",role1);

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRole(role1);
            userRole.setUser(user);
            userRoleSet.add(userRole);
            log.info("UserRole object created: {}", userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            log.info("User created with username: {}", user1.getUsername());

        } catch (UserFoundException e) {
            log.error("Error occurred during user creation", e);
        }
    }*/

}

