package com.freeSystems.InventorySystem.NotificationSystem.data.beans;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("inventorySystem")
public interface ItemClient {

    @GetMapping("/items/getAll")
    List<Item> getItems();

}
