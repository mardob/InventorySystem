package com.freeSystems.RestaurantSystem.InventorySystem.web.application;

import com.freeSystems.RestaurantSystem.InventorySystem.business.service.InventoryService;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping(value="/items/")
@Validated
public class ItemController {

    @Autowired
    private InventoryService inventoryService;

/*
    @RequestMapping(method= RequestMethod.GET, value="/getreservations/")
    @ResponseBody
    public void getReservations(@Valid @NotBlank @RequestParam(value="date", required=false)String dateString, Model model){
        List<Item> roomReservationList = this.inventoryService.getRoomReservationsForDate(dateString);
        model.addAttribute("roomReservations", roomReservationList);
    }*/

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/getAll")
    @ResponseBody
    public List<Item> getAll(){
        System.out.println("Get all");
        List list = this.inventoryService.getAll();
        System.out.println(list.size());
        return list;
    }


    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/findByName")
    @ResponseBody
    public List<Item> findByName( @Valid @NotBlank @RequestParam(value="name", required=false)String name){
        System.out.println(name);
        List list = this.inventoryService.findByName(name);
        System.out.println(list.size());
        return list;
    }


    @RequestMapping(method=RequestMethod.GET, produces = {"application/json"}, value="/add")
    @ResponseBody
    public Item addNewItem(@Valid @NotBlank @RequestParam(value="name") String name, @RequestParam(value="price") double price){
        System.out.println(name+ " "+price);
        Item newItem = this.inventoryService.createNewItem(name, price);
        return newItem;
    }


    @RequestMapping(method=RequestMethod.GET, produces = {"application/json"}, value="/updateCategory")
    @ResponseBody
    public Item addNewItem(@Valid @RequestParam(value="categoryId") List<Long> categoryId, @Valid @RequestParam(value="itemId") Long itemId){
        System.out.println(categoryId + " " + itemId);
        Item newItem = this.inventoryService.updateCategory(itemId, categoryId);
        return newItem;
    }


    /* not working currently
    @RequestMapping(method=RequestMethod.POST, value="/addItems")
    @ResponseBody
    public List<Item> addNewItems(@Valid @NotBlank @RequestParam(value="items") List<Item> items){
        System.out.println("number: " + items.size());
        //items
        List <Item> newItems = this.inventoryService.createNewItems(items);
        return newItems;
    }*/



    @RequestMapping(method=RequestMethod.GET, value="/delete")
    @ResponseBody
    public void deleteItem(@Valid @NotNull @RequestParam(value="id") Long itemId){
        System.out.println("provided itemId for deletion" + itemId);
        this.inventoryService.deleteItemById(itemId);
    }


    @RequestMapping(method=RequestMethod.GET, value="/checkAllItems")
    @ResponseBody
    public void checkAllItems(){
       List <Item> items = this.inventoryService.checkForItemSpoilage();
        this.inventoryService.updateItems(items);
    }

}
