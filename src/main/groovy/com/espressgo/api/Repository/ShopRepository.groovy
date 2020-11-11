package com.espressgo.api.Repository

import com.espressgo.api.models.Shop
import org.springframework.data.mongodb.repository.MongoRepository

interface ShopRepository extends MongoRepository<Shop, String> {
    Shop findByShopname(String shopname)
}
