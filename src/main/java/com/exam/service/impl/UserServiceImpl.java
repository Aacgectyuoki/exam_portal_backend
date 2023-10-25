package com.exam.service.impl;


import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User user1 = this.userRepository.findByUsername(user.getUsername());

        if (user1 != null) {

            log.info("User is already there !!");
            log.info(String.valueOf(new Exception("User Already present!!")));
        } else {
            //user create

            for (UserRole role : userRoles) {
                roleRepository.save(role.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            user1 = userRepository.save(user);

        }

        return user1;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {

        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {

        User existinguser = userRepository.findById(user.getId()).orElse(null);
        existinguser.setUsername(user.getUsername());
        existinguser.setFirstName(user.getFirstName());
        existinguser.setLastName(user.getLastName());
        existinguser.setEmail(user.getEmail());
        existinguser.setPassword(user.getPassword());
        existinguser.setProfile(user.getProfile());
        existinguser.setPhone(user.getPhone());
        return userRepository.save(existinguser);
    }
}
