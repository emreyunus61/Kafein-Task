package com.example.kafeintask.service;

import com.example.kafeintask.dto.UserFollowersDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducerService {
    private static final String TOPIC = "follower";

    @Autowired
    private KafkaTemplate<String, UserFollowersDto> kafkaTemplate;

    public void sendMessage(UserFollowersDto userFollowersDto) {
        log.info(String.format("#### -> Producing message -> %s", userFollowersDto.toString()));
        kafkaTemplate.send(TOPIC, userFollowersDto);
    }
}