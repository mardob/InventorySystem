package com.freeSystems.RestaurantSystem.InventorySystem.data.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Long categoryId;
    @Column(name = "NAME", length = 30, nullable = true)
    private String name;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
