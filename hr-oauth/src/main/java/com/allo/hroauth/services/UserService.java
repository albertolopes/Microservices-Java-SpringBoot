package com.allo.hroauth.services;

import com.allo.hroauth.entities.User;
import com.allo.hroauth.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            throw new IllegalArgumentException("Email not found.");
        }
         return user;
    }
}
