package com.freeSystems.RestaurantSystem.InventorySystem.web.application;

import com.freeSystems.RestaurantSystem.InventorySystem.business.service.CategoryService;
import com.freeSystems.RestaurantSystem.InventorySystem.business.service.InventoryService;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
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
import java.util.Optional;


@Controller
@RequestMapping(value="/category/")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/findByName")
    @ResponseBody
    public List<Category> findByName( @Valid @NotBlank @RequestParam(value="name", required=false)String name){
        System.out.println("test "+ name);
        List list = this.categoryService.findByName(name);
        System.out.println(list.size());
        return list;
    }

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/findById")
    @ResponseBody
    public Category findById(@Valid @RequestParam(value="id", required=false)Long id){
        System.out.println(id);
        Optional <Category> category = this.categoryService.findById(id);
        if(category.isPresent()){
            Category cat = category.get();
            System.out.println(cat);
            return cat;
        }
        else return null;
    }

    @RequestMapping(method=RequestMethod.GET, produces = {"application/json"}, value="/add")
    @ResponseBody
    public Category addNewCategory(@Valid @NotBlank @RequestParam(value="name") String categoryName){
        System.out.println(categoryName + " ");
        Category newCategory = this.categoryService.createNewCategory(categoryName);
        return newCategory;
    }



    @RequestMapping(method=RequestMethod.GET, value="/delete")
    @ResponseBody
    public void deleteCategory(@Valid @NotNull @RequestParam(value="id") Long id){
        System.out.println("provided itemId for deletion" + id);
        this.categoryService.deleteItemById(id);
    }
}
