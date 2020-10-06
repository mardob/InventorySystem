package com.freeSystems.RestaurantSystem.InventorySystem.data.beans;


import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long itemId;
    @Column(name = "NAME", length = 30, nullable = true)
    private String name;
    @Column(name = "PRICE", length = 30, nullable = true)
    private double price;
    @Column(name = "DATE_OF_PURCHASE", length = 30, nullable = true)
    private Date dateOfPurchase;
    @Column(name = "DATE_OF_EXPIRATION", length = 30, nullable = true)
    private Date dateOfExpiration;

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Spoilage getSpoilage() {
        return spoilage;
    }

    public void setSpoilage(Spoilage spoilage) {
        this.spoilage = spoilage;
    }

    @Column(name = "SPOILAGE", nullable = false)
    private Spoilage spoilage;
    @ManyToMany
    @JoinTable(
            name = "ITEM_CATEGORY_LINK",
            joinColumns = @JoinColumn(name = "ITEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<Category> categories;
    @Column(name = "QUANTITY", nullable = true)
    private double quantity;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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


