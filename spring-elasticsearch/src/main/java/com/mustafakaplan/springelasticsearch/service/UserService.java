package com.mustafakaplan.springelasticsearch.service;

import com.mustafakaplan.springelasticsearch.entity.User;
import com.mustafakaplan.springelasticsearch.repository.UserRepository;
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

    public List<User> getUsersByName(String search) {
        return userRepository.getByCustomQuery(search);
    }

    public List<User> getByNameAndSurname(String search) {
        return userRepository.findByNameLikeOrSurnameLike(search, search);
    }
}
