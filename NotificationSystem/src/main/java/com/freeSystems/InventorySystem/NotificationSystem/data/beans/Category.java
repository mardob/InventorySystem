package com.freeSystems.InventorySystem.NotificationSystem.data.beans;


import javax.persistence.*;
import java.util.List;

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Category {

    private Long categoryId;
    private String name;
    private List<Item> items;

    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
