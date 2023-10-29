package com.project.examportal;


import com.project.examportal.exception.UserFoundException;
import com.project.examportal.model.Role;
import com.project.examportal.model.User;
import com.project.examportal.model.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.examportal.repository.QuizRepository;
import com.project.examportal.service.UserService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class ExamServerApiApplication  {

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public final QuizRepository quizRepository;

    public ExamServerApiApplication(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, QuizRepository quizRepository) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.quizRepository = quizRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamServerApiApplication.class, args);
    }

   /* @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("starting code");

            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setUsername("Admin");
            user.setPassword(this.bCryptPasswordEncoder.encode("access"));
            user.setEmail("admin@gmail.com");

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRole(role1);
            userRole.setUser(user);
            userRoleSet.add(userRole);
            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());

        } catch (UserFoundException e) {
            e.printStackTrace();


        }*/


    }

