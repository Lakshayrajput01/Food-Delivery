package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserRepo extends ListCrudRepository<User,Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);

}
