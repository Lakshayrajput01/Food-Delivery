package com.geekster.FoodDeliveryPlatformAPI.controllers;

import com.geekster.FoodDeliveryPlatformAPI.dtos.*;
import com.geekster.FoodDeliveryPlatformAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("signup")
    public String signup(@Valid @RequestBody UserSignUpInput inputUser){
        return userService.signUp(inputUser);
    }

    @PostMapping("signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInInput) {
        return userService.signIn(signInInput);
    }

    @DeleteMapping("signOut/{token}")
    public String signOut(@PathVariable String token) {
        return userService.signOut(token);
    }

}
