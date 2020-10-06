package com.freeSystems.RestaurantSystem.InventorySystem.business.service;


import com.freeSystems.RestaurantSystem.InventorySystem.data.Repository.CategoryRepository;
import com.freeSystems.RestaurantSystem.InventorySystem.data.Repository.ItemRepository;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Spoilage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InventoryService {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private Date dateOfExecution;


    @Autowired
    public InventoryService(ItemRepository itemRepository, CategoryRepository categoryRepository){
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }
/*
    public List<Item> getRoomReservationsForDate(String dateString){
        if (null == dateString || "".equals(dateString)) {
            return new ArrayList<>();
        }
        Date date = this.createDateFromDateString(dateString);
        Iterable<Item> rooms = this.itemRepository.findAll();
        Map<Long, Item> roomReservationMap = new HashMap<>();
        rooms.forEach(room->{
            if(new Date().compareTo(room.getDateOfExpiration()) >= 0 ){
                roomReservationMap.put(room.getItemId(), room);
            }
        });
        List<Item> roomReservations = new ArrayList<>();
        for(Long roomId:roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }*/


    public List<Item> getAll(){
        List<Item> data = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> data.add(item));
        return data;
    }

    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }


    public List<Item> findByName(String name){
        System.out.println(name);
        List l =  this.itemRepository.findByNameIgnoreCase(name);
        System.out.println(l.size());
        return l;
    }

    public Item createNewItem(String name, double price){
        Item newItem = new Item(name,price);
        this.itemRepository.createNewItem(newItem);
        return newItem;
    }

    public List<Item> createNewItems(List<Item> items){
        this.itemRepository.createNewItems(items);
        return items;
    }

    public Item updateCategory(Long itemId, List<Long> categoryId){
        //Item newItem = new Item(name,price);

        Optional<Item> itemOption = this.itemRepository.findById(itemId);
        List<Category> categories = this.categoryRepository.findByCategoryIdIn(categoryId);

       // if( itemOption.isPresent() && categoryOption.isPresent()){
            Item item = itemOption.get();
            item.setCategories(categories);
            //Category cat = categoryOption.get();
            //Set<Category> categories = item.getCategory();
           /* if(!categories.contains(cat)){
                categories.add(cat);
            }*/
            return item;
        //} else{
            //TODO handle wrong id
        //    return null;
        //}


    }


    public void updateItems(List<Item> items){
        this.itemRepository.saveAll(items);
    }

    public void deleteItemById(long itemId){
        this.itemRepository.deleteById(itemId);
    }



    public List<Item> checkForItemSpoilage(){
        System.out.println("inside checkForItemSpoilage");
     //   List<Notification> notifications = new ArrayList<Notification>();
        //TODO get list of all items
        List<Item> items = new ArrayList<Item>();//mockupListOfItems
        itemRepository.findAll().forEach(item -> items.add(item));
        System.out.println("fetched following number of items " + items.size());

        //TODO Iterate over it and fill your own list of those that are fitting rules
        this.dateOfExecution = new Date();
        //items.parallelStream().forEach(item -> checkItem(item));
        for(Item item: items) {
            checkAndUpdateItem(item);
        }
        System.out.println("Item checking is finished");
        return items;
    }

    //Method to generate notifications based on business rules
    private void checkAndUpdateItem(Item item){
        System.out.println("checkItem got following item " + item);

        if(item.getDateOfExpiration() != null) {
           /* if (item.getDateOfExpiration() == dateOfExecution) {
                //make changes to spoilage setting

            }*/
            item.setSpoilage(Spoilage.LAST_CALL);
        }else{
            item.setSpoilage(Spoilage.CLOSE);
        }
    }

}
