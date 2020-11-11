package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/getFollowees", method = RequestMethod.POST)
class GetFollowees {

    @Autowired
    private UserRepository userRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ArrayList<User> followee(@RequestBody String email){
        String actualEmail = email.replace("\"", "")
        User user = userRepository.findByEmail(actualEmail)
        return user.getFollowees()
    }
}
