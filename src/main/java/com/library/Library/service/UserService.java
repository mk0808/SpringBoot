package com.library.Library.service;


import com.library.Library.domain.Role;
import com.library.Library.domain.User;
import com.library.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(String login, String password){
        PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        if(login != null && password != null) {
            User user = userRepository.getUser(login);
            if(user == null) {
                User newUser = new User(login,pe.encode(password));
                userRepository.addUser(newUser);
            }
        }
    }

    public void addRoleToUser(String login, String roleName){
        if(login != null && roleName != null){
            User user = userRepository.getUser(login);

            if(user != null){
                Role role = new Role(roleName);

                userRepository.addRoleToUser(user, role);
            }
        }
    }

}