package com.freeSystems.RestaurantSystem.InventorySystem.web.service;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import com.freeSystems.RestaurantSystem.InventorySystem.web.application.ItemController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class InventoryServiceController {

   @Autowired
   private ItemController itemController;

   /*
   @RequestMapping(method= RequestMethod.GET, value="/reservations/{date}")
   public List<Item> getAllReservationsForDate(@PathVariable(value="date")String dateString){
      return this.itemController.getRoomReservationsForDate(dateString);
   }*/
}
