package com.example.kafeintask.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class UserFollowersDto implements Serializable {
    private int id;
    private List<Integer> followers;

    public UserFollowersDto() {

    }

    public UserFollowersDto(int id, List<Integer> followers) {
        this.id = id;
        this.followers = followers;
    }

}