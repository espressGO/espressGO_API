package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import models.Message
import models.User
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
    ObjectId add(@RequestBody User user) {
        User newUser = new User()
        ArrayList<Message> messages = new ArrayList<>()
        newUser.setEmail(user.getEmail())
        newUser.setDisplayName(user.getDisplayName())
        newUser.setMessages(messages);
        System.out.println("USER DISPLAY NAME\t" + newUser.getDisplayName())
        userRepository.save(newUser)
        return newUser.getId()
    }
}