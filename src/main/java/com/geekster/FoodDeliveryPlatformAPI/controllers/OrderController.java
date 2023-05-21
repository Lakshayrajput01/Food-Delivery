package com.geekster.FoodDeliveryPlatformAPI.controllers;

import com.geekster.FoodDeliveryPlatformAPI.services.AdminAuthenticationTokenService;
import com.geekster.FoodDeliveryPlatformAPI.services.AdminService;
import com.geekster.FoodDeliveryPlatformAPI.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    AdminAuthenticationTokenService authenticationTokenService;
    @Autowired
    AdminService adminService;
    @Autowired
    OrderService orderService;

    @PostMapping("/{foodId}/{token}/{count}")
    public String createOrder(@PathVariable Long foodId,@PathVariable String token,@PathVariable Integer count) {
        return orderService.createOrder(foodId,token,count);
    }

    @GetMapping("/{token}")
    public Object getAllOrdersByAdmin(@PathVariable String token){
        boolean isValid=authenticationTokenService.isAuthenticate(token);

        if(!isValid){
            return "Token invaild";
        }
       return orderService.getAllOrders();
    }

}
