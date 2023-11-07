package com.project.examportal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.examportal.exception.UserFoundException;
import com.project.examportal.model.User;
import com.project.examportal.model.UserRole;
import com.project.examportal.repository.RoleRepository;
import com.project.examportal.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User user1 = this.userRepository.findByUsername(user.getUsername());
        if (user1 != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            user1 = this.userRepository.save(user);
        }

        return user1;
    }


    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


    public User updateUserProfile(Long userId, User updatedUser) {
        // Find the user in the database by their ID
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {

//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setUsername(updatedUser.getUsername());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

}
