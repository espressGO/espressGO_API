
package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import com.espressgo.api.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/follow", method = RequestMethod.POST)
class Follow {

    @Autowired
    private UserRepository userRepository

    //first person: following the second person. user[0].addFollowee(user[1])
    //Second person gains a follower user[1].addFollower(user[0])
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    String followUser(@RequestBody ArrayList<String> emails){
        User user1 = userRepository.findByEmail(emails.get(0))
        User user2 = userRepository.findByEmail(emails.get(1))
        user1.followees.add(user2)
        userRepository.save(user1)
        userRepository.save(user2)
        return "Enjoy, comrades"
    }
}