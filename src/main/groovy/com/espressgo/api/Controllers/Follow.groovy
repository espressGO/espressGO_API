
package com.espressgo.api.Controllers

import com.espressgo.api.Repository.UserRepository
import com.espressgo.api.models.User
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
    String followUser(ArrayList<String> emails){
        String email1 = emails.get(0).replace("\"", "")
        String email2 = emails.get(1).replace("\"", "")

        User user1 = userRepository.findByEmail(email1)
        User user2 = userRepository.findByEmail(email2)
        user1.addFollowee(user2)
        user2.addFollower(user1)
        userRepository.save(user1)
        userRepository.save(user2)
        return "Enjoy, comrades"
    }
}