package com.freeSystems.InventorySystem.NotificationSystem.data.beans;


import com.freeSystems.InventorySystem.NotificationSystem.utilities.Spoilage;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Item {
    private Long itemId;
    private String name;
    private double price;
    private Date dateOfPurchase;
    private Date dateOfExpiration;
    private double quantity;
    private List<Category> categories;
    public Spoilage getSpoilage() {
        return spoilage;
    }

    public void setSpoilage(Spoilage spoilage) {
        this.spoilage = spoilage;
    }

    private Spoilage spoilage;
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfPurchase=" + dateOfPurchase +
                ", dateOfExpiration=" + dateOfExpiration +
                ", categories=" + categories +
                ", quantity=" + quantity +
                '}';
    }

    public Item(){}

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Item(String name, double price){
        this.name = name;
        this.price = price;
        this.dateOfPurchase =  new Date();
    }

    public Item(String name, double price, Date dateOfPurchase){
        this.name = name;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

   /* public int getTypeOfItemId() {
        return typeOfItemId;
    }

    public void setTypeOfItemId(int typeOfItemId) {
        this.typeOfItemId = typeOfItemId;
    }*/
}


