package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


    @Repository
    public interface CategoryRepository extends CrudRepository<Category, Long>, CategoryCustomRepository{
        List<Category> findByNameIgnoreCase(String name);
        List<Category> findByName(String name);
        List<Category> findByCategoryIdIn(List<Long> ids);

}

