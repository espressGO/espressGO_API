package com.espressgo.api.Controllers;

import com.espressgo.api.Repository.UserRepository;
import com.espressgo.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/findUser", method = RequestMethod.POST)
class SignIn {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    User getUser(@RequestBody String email) {
        System.out.println(email)
        User user = userRepository.findByEmail(email);
        System.out.println(user.getEmail())
        return user;
    }
}