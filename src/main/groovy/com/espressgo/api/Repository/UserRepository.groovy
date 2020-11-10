package com.espressgo.api.Repository

import models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {
    User findById(ObjectId id)
    User findByEmail(String email)
}
