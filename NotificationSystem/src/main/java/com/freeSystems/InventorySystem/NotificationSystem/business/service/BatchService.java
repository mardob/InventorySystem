package com.freeSystems.InventorySystem.NotificationSystem.business.service;


import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Item;
import com.freeSystems.InventorySystem.NotificationSystem.data.beans.ItemClient;
import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import com.freeSystems.InventorySystem.NotificationSystem.utilities.Spoilage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BatchService {
    @Autowired
    NotificationService service;
    Date dateOfExecution;
    @Autowired
    ItemClient itemClient;



    public void checkForItemSpoilage(){
        System.out.println("inside checkForItemSpoilage");
        List<Notification> notifications = new ArrayList<Notification>();
        //TODO get list of all items
        List<Item> items; //= new ArrayList<Item>();//mockupListOfItems
        items = itemClient.getItems();
        System.out.println("fetched following number of items " + items.size());

        //TODO Iterate over it and fill your own list of those that are fitting rules
        this.dateOfExecution = new Date();
        //items.parallelStream().forEach(item -> checkItem(item));
        for(Item item: items){
            if(item.getSpoilage() != null){
                notifications.add(new Notification(item.getSpoilage(),item.getItemId(),item.getName()));
            }
        }
        System.out.println("Number of items with no spoilage" + (items.size() - notifications.size()));
        if(notifications.size() > 0) {
            System.out.println("creating following number of notifications " + notifications.size());
            service.createNotifications(notifications);
            System.out.println("created notifications sucessfully");
        } else{
            System.out.println("No notifications to create");
        }


    }

    //Method to generate notifications based on business rules
   /* private Notification checkItem(Item item){
        System.out.println("checkItem got following item " + item);

        if(item.getDateOfExpiration() != null){
            if(item.getDateOfExpiration() == dateOfExecution){
                //TODO return spoilage
            }
            return new Notification(Spoilage.SPOILED,item.getItemId(),item.getName());
        } else{
            return null;
        }
    }*/
}
