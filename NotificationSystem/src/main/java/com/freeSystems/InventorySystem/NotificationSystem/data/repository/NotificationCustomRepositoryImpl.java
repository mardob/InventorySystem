package com.freeSystems.InventorySystem.NotificationSystem.data.repository;

import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class NotificationCustomRepositoryImpl implements NotificationCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    EntityTransaction entityTransaction;

    @Override
    @Transactional
    public void createNewNotification(Notification category) {
        this.entityManager.persist(category);
    }

    @Override
    @Transactional
    public void createNewNotification(List<Notification> notifications){
        try {
        //    entityTransaction = entityManager.getTransaction();
        /*    if(entityTransaction == null){
                System.out.println("Failed in db");
            }
            entityTransaction.begin();*/

            for (int i = 0; i < notifications.size(); i++) {
              //  if (i > 0 && i % notifications.size() == 0) {
               //     entityTransaction.commit();
              //      entityTransaction.begin();
            //        entityManager.clear();
            //    }
                entityManager.merge(notifications.get(i));
            }
     //       entityTransaction.commit();
        } catch (RuntimeException e) {
          /*  if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }*/
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
