package com.espressgo.api.Controllers

import com.espressgo.api.Repository.ShopRepository
import models.Message
import models.Shop
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
@RequestMapping(value = "/getShop", method = RequestMethod.POST)
class GetShop {

    @Autowired
    private ShopRepository shopRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Shop shopId(@RequestBody String shopName) {
        String actualShop = shopName.replace("\"", "")
        System.out.println(actualShop)
        Shop currShop = shopRepository.findByShopname(actualShop)
        System.out.println("TRYING TO GET SHOP")
        System.out.println(currShop.getId())
        if(currShop != null)
            return currShop
        else
            return null
    }
}
