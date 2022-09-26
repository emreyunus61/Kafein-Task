package com.example.kafeintask.repository;

import com.example.kafeintask.model.UserFollowers;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserFollowersRepository extends CassandraRepository<UserFollowers, Integer> {

}