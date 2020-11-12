package com.espressgo.api.Controllers
import com.espressgo.api.Repository.UserRepository
import com.espressgo.api.models.Message
import com.espressgo.api.models.User
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.time.ZonedDateTime

@RestController
@RequestMapping(value = "/getFeed", method = RequestMethod.POST)
class Feed {

    private final int MAX_MESSAGES = 40;
    @Autowired
    private UserRepository userRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ArrayList<Message> feed(@RequestBody String email) {

        String actualEmail = email.replace("\"", "")
        User user = userRepository.findByEmail(actualEmail)
        ArrayList<User> followees = user.getFollowees()
        ArrayList<Message> allMessages = new ArrayList<>()
        //get every message from all followees
        for(User followee : followees)
        {
            System.out.println("Looking at user " + followee.getEmail())
            ArrayList<Message> messages = followee.getMessages()
            for(Message message : messages)
                allMessages.add(message)
        }
        allMessages.sort()
        ArrayList<Message> toSend = new ArrayList<>()

        for(int i = 0; i < allMessages.size(); i++) {
            if(i== MAX_MESSAGES)
                break;
            toSend.add(allMessages.get(i))
        }
        return toSend;
    }
}