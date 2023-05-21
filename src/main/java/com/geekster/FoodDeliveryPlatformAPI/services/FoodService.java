package com.geekster.FoodDeliveryPlatformAPI.services;

import com.geekster.FoodDeliveryPlatformAPI.dtos.FoodDto;
import com.geekster.FoodDeliveryPlatformAPI.models.UserAuthenticationToken;
import com.geekster.FoodDeliveryPlatformAPI.repositories.IFoodRepository;
import com.geekster.FoodDeliveryPlatformAPI.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    UserAuthenticationService userAuthenticationService;
    @Autowired
    private IFoodRepository foodRepository;

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public boolean addFood(FoodDto foodDto) {
        Food food = new Food(foodDto.getTitle(),foodDto.getDescription(),foodDto.getPrice(),foodDto.getDummyImage());

        Food isAdded = foodRepository.save(food);
        if(isAdded == null){
            return false;
        }
        return true;
    }

    public void removeById(Long id) {
        foodRepository.deleteById(id);
    }

    public boolean existsById(Long foodId) {
        return foodRepository.existsById(foodId);
    }

    public List<Food> getAllFood(String token) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationService.getToken(token);
        if(token==null){
            return null;
        }

        return foodRepository.findAll();

    }


    public String updateFoodById(Long id, String token, FoodDto foodDto) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationService.getToken(token);
        if(token==null){
            return "not exist";
        }
         Food food =foodRepository.findById(id).orElse(null);
        if(food==null){
            return "not exist";
        }
        food.setTitle(foodDto.getTitle());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());
        food.setDummyImage(foodDto.getDummyImage());

       foodRepository.save(food);
       return "update successfully";
    }
}
