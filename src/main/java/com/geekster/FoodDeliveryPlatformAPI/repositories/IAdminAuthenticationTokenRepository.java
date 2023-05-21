package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.AdminAuthenticationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface IAdminAuthenticationTokenRepository extends ListCrudRepository<AdminAuthenticationToken, Long> {
    AdminAuthenticationToken findByToken(String token);

    boolean existsByToken(String token);
}
