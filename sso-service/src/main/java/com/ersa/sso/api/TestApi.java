package com.ersa.sso.api;

import com.ersa.sso.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {

    private final UserClient userClient;
    private final RedisTemplate redisTemplate;

    @Autowired
    public TestApi(UserClient userClient, RedisTemplate redisTemplate) {
        this.userClient = userClient;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/testQueryUser")
    Object getUser(){
        return  userClient.queryUser();
    }

    @PostMapping("/setKey")
    void setKey(@RequestParam String key,@RequestParam String value){
        redisTemplate.opsForValue().set(key,value);
    }

    @PostMapping("/hasKey")
    boolean hasKey(@RequestParam  String key){
        return redisTemplate.hasKey(key);
    }

    @PostMapping("/getKey")
    String getKey(@RequestParam String key){
        return (String) redisTemplate.opsForValue().get(key);
    }
}
