package org.example.seminar7.service;

import org.example.seminar7.persist.User;
import org.example.seminar7.persist.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.save(new User("User1"));
        this.userRepository.save(new User("User2"));
        this.userRepository.save(new User("User3"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
