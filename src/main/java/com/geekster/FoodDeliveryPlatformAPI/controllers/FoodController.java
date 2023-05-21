package com.geekster.FoodDeliveryPlatformAPI.controllers;

import com.geekster.FoodDeliveryPlatformAPI.dtos.FoodDto;
import com.geekster.FoodDeliveryPlatformAPI.models.Food;
import com.geekster.FoodDeliveryPlatformAPI.services.AdminService;
import com.geekster.FoodDeliveryPlatformAPI.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @Autowired
    AdminService adminService;

    @PostMapping("/{token}")
    public String addFood(@RequestBody FoodDto foodDto, @PathVariable String token) {
        return adminService.addFood(foodDto,token);
    }

    @DeleteMapping("byId/{id}/{token}")
    public void deleteByFoodId(@PathVariable Long id, @PathVariable String token) {
        adminService.deleteByFoodId(id,token);
    }

    @GetMapping("/all/token{token}")
    public List<Food> getallFood(@PathVariable String token){
        return foodService.getAllFood(token);
    }

    @PutMapping("/byid/{id}/token/{token}")
    public String updateFoodById(@PathVariable Long id ,@PathVariable String token ,@RequestBody FoodDto foodDto){
        return foodService.updateFoodById(id,token,foodDto);
    }




}
