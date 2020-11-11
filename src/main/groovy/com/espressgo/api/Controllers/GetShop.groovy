package com.espressgo.api.Controllers

import com.espressgo.api.Repository.ShopRepository
import com.espressgo.api.models.Shop
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
        System.out.println("TRYING TO GET SHOP")
        System.out.println(actualShop)
        Shop currShop = shopRepository.findByShopname(actualShop)
        if(currShop != null) {
            System.out.println("Got shop successfully!")
            System.out.println(currShop.getId())
            return currShop
        }
        else {
            System.out.println("Unable to find shop: " + actualShop)
            return null
        }

    }
}
