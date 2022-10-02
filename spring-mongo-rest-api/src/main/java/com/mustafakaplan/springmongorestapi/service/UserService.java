package com.mustafakaplan.springmongorestapi.service;

import com.mustafakaplan.springmongorestapi.entity.User;
import com.mustafakaplan.springmongorestapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
