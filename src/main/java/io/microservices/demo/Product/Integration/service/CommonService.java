package io.microservices.demo.Product.Integration.service;

import io.microservices.demo.Product.Integration.model.User;
import org.springframework.stereotype.Service;

@Service
public class CommonService {


    public User findUserById(Long userId) {
        return new User();
    }
}
