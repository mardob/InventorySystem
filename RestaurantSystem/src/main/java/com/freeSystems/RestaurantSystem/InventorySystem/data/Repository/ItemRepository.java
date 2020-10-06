package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import org.hibernate.loader.plan.spi.EntityFetch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ItemRepository extends CrudRepository<Item, Long> , ItemCustomRepository{
     //   @PersistenceContext
    //    private EntityManager entityManager;

        List<Item> findByNameIgnoreCase(String name);
        List<Item> findByName(String name);

}

