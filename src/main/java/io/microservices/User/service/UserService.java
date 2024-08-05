package io.microservices.User.service;

import io.microservices.User.model.User;
import io.microservices.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;


    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    public String register(User user){
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return "User Added Successfully";
    }

    public User findUserById(Long id) throws Exception {
        LOGGER.info("Inside findUserById id : {} ", id);
        return userRepository.findById(id).orElseThrow( () -> new Exception("User not found "+id));
    }

    public User findUserByEmail(String email) throws Exception {
        LOGGER.info("Inside findUserByEmail email : {} ", email);
        return userRepository.findByEmail(email).orElseThrow( () -> new Exception("User not found "+email));
    }

}

