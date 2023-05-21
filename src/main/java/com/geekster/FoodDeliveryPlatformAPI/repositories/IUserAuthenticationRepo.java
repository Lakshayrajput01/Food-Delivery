package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.UserAuthenticationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserAuthenticationRepo extends ListCrudRepository<UserAuthenticationToken,Long> {
    UserAuthenticationToken findByToken(String token);

    boolean existsByToken(String token);
}
