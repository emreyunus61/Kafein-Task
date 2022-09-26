package com.example.kafeintask.repository;

import com.example.kafeintask.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByName(String name);
}
