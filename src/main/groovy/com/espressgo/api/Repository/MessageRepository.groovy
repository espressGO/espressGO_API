package com.espressgo.api.Repository

import models.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageRepository extends MongoRepository<Message, String> {
}
