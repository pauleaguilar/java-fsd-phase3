package com.example.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional <User> findByName(String name);
}