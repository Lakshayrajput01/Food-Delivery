package com.geekster.FoodDeliveryPlatformAPI.controllers;

import com.geekster.FoodDeliveryPlatformAPI.dtos.SignInInput;
import com.geekster.FoodDeliveryPlatformAPI.dtos.SignInOutput;
import com.geekster.FoodDeliveryPlatformAPI.dtos.SignUpInput;
import com.geekster.FoodDeliveryPlatformAPI.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("signup")
    public String signup(@Valid @RequestBody SignUpInput signUpInput){
        return adminService.signUp(signUpInput);
    }

    @PostMapping("signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInInput) {
        return adminService.signIn(signInInput);
    }

    @DeleteMapping("signOut/{token}")
    public String signOut(@PathVariable String token) {
        return adminService.signOut(token);
    }

}
