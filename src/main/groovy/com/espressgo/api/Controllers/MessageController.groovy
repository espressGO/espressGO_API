package com.espressgo.api.Controllers

import com.espressgo.api.Repository.MessageRepository
import models.Message

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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Message add(@RequestBody Message message) {
        Message currMessage = new Message();
    }
}