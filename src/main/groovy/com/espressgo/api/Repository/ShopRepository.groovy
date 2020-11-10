package com.espressgo.api.Repository

import models.Shop
import org.springframework.data.mongodb.repository.MongoRepository

interface ShopRepository extends MongoRepository<Shop, String> {
    Shop findByShopname(String shopName)
}