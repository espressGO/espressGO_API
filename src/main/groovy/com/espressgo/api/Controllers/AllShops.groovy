package com.espressgo.api.Controllers

import com.espressgo.api.Repository.ShopRepository
import com.espressgo.api.models.Shop
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.lang.reflect.Array

@RestController
@RequestMapping(value = "/getShops", method = RequestMethod.POST)
class AllShops {

    @Autowired
    private ShopRepository shopRepository

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    ArrayList<Shop> allShops(){
        ArrayList<Shop> shops = shopRepository.findAll()
        ArrayList<Shop> toReturn = new ArrayList<>()
        for(Shop shop : shops)
        {
            System.out.println(shop.getWebsite())
            if (shop.getWebsite()!= null)
                toReturn.add(shop)
        }
        return toReturn
    }
}
