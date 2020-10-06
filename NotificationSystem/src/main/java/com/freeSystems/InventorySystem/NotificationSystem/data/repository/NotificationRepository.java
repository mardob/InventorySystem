package com.freeSystems.InventorySystem.NotificationSystem.data.repository;

import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>, NotificationCustomRepository {

}
