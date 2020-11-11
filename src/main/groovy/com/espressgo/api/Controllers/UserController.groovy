package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import com.espressgo.api.models.User
import com.fasterxml.jackson.databind.ObjectMapper
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
class UserController {

    @Autowired
    private UserRepository userRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    User add(@RequestBody User user) {
        User newUser = new User()
        newUser.setEmail(user.getEmail())
        System.out.println("This is the new user's email!" + newUser.getEmail())
        userRepository.save(newUser)
        return newUser
    }
}