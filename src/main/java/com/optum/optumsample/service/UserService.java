package com.optum.optumsample.service;

import com.optum.optumsample.exception.CustomException;
import com.optum.optumsample.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    LinkedList<User> users = new LinkedList<>();

    public User saveUser(User user) {
        if (user.getFirstName() == null || user.getLastName() == null) {
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCES, HttpStatus.BAD_REQUEST);
        } else {
            users.add(user);
        }
        return users.getLast();
    }


    public List<User> getAllUsers() {
        if (!users.isEmpty()) {
            return users;
        } else
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND);
    }

    public User getById(String userId) {
        Optional<User> optionalUser = users.stream().filter((user) -> user.getId().equals(userId)).findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND);
        }


    }
}
