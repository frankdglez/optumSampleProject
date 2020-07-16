package com.optum.optumsample.service;

import com.optum.optumsample.exception.CustomException;
import com.optum.optumsample.model.User;
import com.optum.optumsample.persistence.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository users) {
        this.userRepository = users;
    }


    public User saveUser(User user) {
        if (user.getFirstName() == null || user.getLastName() == null) {
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCES, HttpStatus.BAD_REQUEST);
        } else {
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        if (userRepository.count() > 0) {
            return userRepository.findAll();
        } else {
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND);
        }
    }

    public User getById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND);
        }
    }
}
