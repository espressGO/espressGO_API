package com.espressgo.api.Repository

import com.espressgo.api.models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email)
}
