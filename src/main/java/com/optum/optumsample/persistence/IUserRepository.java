package com.optum.optumsample.persistence;

import com.optum.optumsample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
