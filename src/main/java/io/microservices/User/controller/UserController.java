package io.microservices.User.controller;

import com.SpringBoot.EcommerceSiteProject.User.model.LoginDTO;
import io.microservices.User.model.User;
import io.microservices.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/test")
    public String testApi(){
        return "TestApi works.";
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        LOGGER.info("inside register register : {} ",user);
        return ResponseEntity.ok().body(userService.register(user));
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        LOGGER.info("inside getUserById id : {} ",id);
        return userService.findUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) throws Exception {
        LOGGER.info("inside getUserByEmail email : {} ",email);
        return userService.findUserByEmail(email);
    }



    /*
    @PutMapping("/{id}/{role}")
    public ResponseEntity<User> updateRole(@PathVariable int id, @PathVariable String role){
        return userservice.update(id, role);
    }*

     */
}
