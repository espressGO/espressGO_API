package com.espressgo.api.Repository

import com.espressgo.api.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {

}
