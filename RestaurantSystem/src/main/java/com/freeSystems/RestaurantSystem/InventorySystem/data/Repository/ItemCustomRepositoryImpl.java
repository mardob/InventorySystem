package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class ItemCustomRepositoryImpl implements ItemCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    EntityTransaction entityTransaction;

    @Override
    @Transactional
    public void createNewItem(Item item) {
        this.entityManager.persist(item);
    }

    @Override
    @Transactional
    public void createNewItems(List<Item> items){
        try {
            entityTransaction.begin();

            for (int i = 0; i < items.size(); i++) {
                if (i > 0 && i % items.size() == 0) {
                    entityTransaction.commit();
                    entityTransaction.begin();
                    entityManager.clear();
                }
                entityManager.persist(items.get(i));
            }
            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
