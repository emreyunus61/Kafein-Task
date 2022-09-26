package com.example.kafeintask.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Data
@Table
@Builder
public class UserFollowers {
    @PrimaryKey
    private int id;
    private List<Integer> followerList;

}