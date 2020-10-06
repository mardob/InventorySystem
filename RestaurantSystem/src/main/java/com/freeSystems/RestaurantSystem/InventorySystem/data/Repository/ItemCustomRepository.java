package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import java.util.List;

public interface ItemCustomRepository {
    void createNewItem(Item i);

    void createNewItems(List<Item> i);

}
