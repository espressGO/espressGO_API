package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/follow", method = RequestMethod.POST)
class Follow {

    @Autowired
    private UserRepository userRepository

    //first person: following the second person. user[0].addFollowee(user[1])
    //Second person gains a follower user[1].addFollower(user[0])
    String followUser(ArrayList<User> users){
        User user1 = users.get(0)
        User user2 = users.get(1)
        user1.addFollowee(user2)
        user2.addFollower(user1)
        userRepository.save(user1)
        userRepository.save(user2)
        return "Enjoy, comrades"
    }
}
