package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.Admin;
import org.springframework.data.repository.ListCrudRepository;

public interface IAdminRepository extends ListCrudRepository<Admin, Long> {
    boolean existsByEmail(String email);

    Admin findByEmail(String email);

}
