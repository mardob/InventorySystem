package com.freeSystems.RestaurantSystem.InventorySystem.business.service;


import com.freeSystems.RestaurantSystem.InventorySystem.data.Repository.CategoryRepository;
import com.freeSystems.RestaurantSystem.InventorySystem.data.Repository.ItemRepository;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CategoryService {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

/*
    public List<Category> getRoomReservationsForDate(String dateString){
        if (null == dateString || "".equals(dateString)) {
            return new ArrayList<>();
        }
        Date date = this.createDateFromDateString(dateString);
        Iterable<Category> rooms = this.categoryRepository.findAll();
        Map<Long, Category> roomReservationMap = new HashMap<>();
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
        List l =  this.categoryRepository.findByNameIgnoreCase(name);
        System.out.println(l.size());
        return l;
    }

    public Optional<Category> findById(Long id){
        System.out.println(id);
        Optional<Category> category =  this.categoryRepository.findById(id);
        System.out.println(category);
        return category;
    }

    public Category createNewCategory(String name){
        Category newCategory = new Category(name);
        this.categoryRepository.createNewCategory(newCategory);
        return newCategory;
    }

/*
    public List<Item> createNewItems(List<Item> items){
        this.categoryRepository.createNewItems(items);
        return items;
    }*/

    public void deleteItemById(long itemId){
        this.categoryRepository.deleteById(itemId);
    }


}
