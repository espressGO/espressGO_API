package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import models.Message
import models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/findUser", method = RequestMethod.GET)
class SignIn {

    @Autowired
    private UserRepository userRepository

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)

    User getUser(@RequestBody String email) {
        return userRepository.findByEmail(email)
    }
}
