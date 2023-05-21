package com.geekster.FoodDeliveryPlatformAPI.repositories;

import com.geekster.FoodDeliveryPlatformAPI.models.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface IOrderRepo extends ListCrudRepository<Order,Long> {

}
