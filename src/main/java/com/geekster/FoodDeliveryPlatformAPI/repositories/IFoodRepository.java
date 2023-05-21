package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.Food;
import org.springframework.data.repository.ListCrudRepository;

public interface IFoodRepository extends ListCrudRepository<Food, Long> {
}
