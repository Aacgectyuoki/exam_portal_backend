package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class ExamServerApiApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamServerApiApplication.class, args);
    }

}
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("Project Started");
//
//        User user = new User();
//
//        user.setFirstName("Shahbaz");
//        user.setLastName("Khan");
//        user.setUserName("shahbazkhan");
//        user.setEmail("Shahbazkhaniq@gmail.com");
//        user.setPhone("+92343535076");
//        user.setPassword("abc");
//        user.setProfile("default.png");
//
//        Role role = new Role();
//        role.setRoleId(44L);
//        role.setRoleName("ADMIN");
//
//        Set<UserRole> userRoles = new HashSet<>();
//
//        UserRole userRole = new UserRole();
//        userRole.setRole(role);
//        userRole.setUser(user);
//        userRoles.add(userRole);
//        role.setUserRoles(userRoles);
//
//        User user1 = this.userService.createUser(user, userRoles);
//        System.out.println(user1);
//    }
//}
