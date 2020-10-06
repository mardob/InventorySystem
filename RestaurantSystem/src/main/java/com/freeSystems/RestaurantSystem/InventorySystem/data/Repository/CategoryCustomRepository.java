package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;

import java.util.List;

public interface CategoryCustomRepository {
    void createNewCategory(Category i);

    void createNewCategories(List<Category> i);

}
