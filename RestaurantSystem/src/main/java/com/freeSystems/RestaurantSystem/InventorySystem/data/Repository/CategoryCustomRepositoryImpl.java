package com.freeSystems.RestaurantSystem.InventorySystem.data.Repository;

import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Category;
import com.freeSystems.RestaurantSystem.InventorySystem.data.beans.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CategoryCustomRepositoryImpl implements CategoryCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    EntityTransaction entityTransaction;

    @Override
    @Transactional
    public void createNewCategory(Category category) {
        this.entityManager.persist(category);
    }

    @Override
    @Transactional
    public void createNewCategories(List<Category> category){
        try {
            entityTransaction.begin();

            for (int i = 0; i < category.size(); i++) {
                if (i > 0 && i % category.size() == 0) {
                    entityTransaction.commit();
                    entityTransaction.begin();
                    entityManager.clear();
                }
                entityManager.persist(category.get(i));
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
