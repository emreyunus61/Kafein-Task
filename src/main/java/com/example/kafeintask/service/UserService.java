package com.example.kafeintask.service;


import com.example.kafeintask.dto.UserDto;
import com.example.kafeintask.dto.UserFollowersDto;
import com.example.kafeintask.model.User;
import com.example.kafeintask.model.UserFollowers;
import com.example.kafeintask.repository.UserFollowersRepository;
import com.example.kafeintask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFollowersRepository userFollowersRepository;
    private final MessageProducerService messageProducerService;

    public User saveUser(UserDto userDto) {
        User user = User.builder().id(userDto.getId()).name(userDto.getName()).surname(userDto.getSurname())
                .followerlist(userDto.getFollowerList()).createdat(userDto.getCreatedat()).build();
        user = userRepository.save(user);
        UserFollowersDto userFollowersDto = UserFollowersDto.builder().id(user.getId())
                .followers(user.getFollowerlist()).build();
        messageProducerService.sendMessage(userFollowersDto);
        return user;
    }

    public UserFollowers saveUsersFollowers(UserFollowersDto userFollowersDto) {
        UserFollowers userFollowers = UserFollowers.builder().id(userFollowersDto.getId())
                .followerList(userFollowersDto.getFollowers()).build();
        return userFollowersRepository.save(userFollowers);
    }
}