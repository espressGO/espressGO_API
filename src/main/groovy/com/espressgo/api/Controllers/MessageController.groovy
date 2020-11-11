package com.espressgo.api.Controllers

import com.espressgo.api.Repository.MessageRepository
import com.espressgo.api.Repository.ShopRepository
import com.espressgo.api.Repository.UserRepository
import models.Message
import models.Shop
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
@RequestMapping(value = "/createmessage", method = RequestMethod.POST)
class MessageController {

    @Autowired
    private MessageRepository messageRepository

    @Autowired
    private UserRepository userRepository

    @Autowired
    private ShopRepository shopRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    boolean add(@RequestBody Message message) {
        Message currMessage = new Message();
        System.out.println(message.getComment())
        System.out.println("line 36 shop " + message.getShopname())
        currMessage.setComment(message.getComment())
        currMessage.setShopId(message.getShopId())
        currMessage.setShopname(message.getShopname())
        currMessage.setUserEmail(message.getUserEmail())
        currMessage.setRating(message.getRating())
        User myUser = userRepository.findByEmail(currMessage.getUserEmail())
        System.out.println("EMAIL HERE " + myUser.getEmail());
        myUser.addMessage(currMessage)
        userRepository.save(myUser)

        System.out.println("SHOP NAME: " + currMessage.getShopname())
        Shop shop = shopRepository.findByShopname(currMessage.getShopname())
        if(shop.getReviews()== null)
        {
            ArrayList<Message> reviews = new ArrayList<>()
            shop.setReviews(reviews)
        }
        shop.addReview(currMessage)
        return true
    }
}