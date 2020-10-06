package com.freeSystems.InventorySystem.NotificationSystem.business.service;

import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import com.freeSystems.InventorySystem.NotificationSystem.data.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {
    private final NotificationRepository notificationRep;

    @Autowired
    public NotificationService(NotificationRepository notificationRep) {
        this.notificationRep = notificationRep;
    }


    public Iterable<Notification> getNotifications(){
        return notificationRep.findAll();
    }
    public Optional<Notification> findNotification(long id){return notificationRep.findById(id);}
    public void deleteNotification(long id){ notificationRep.deleteById(id);}
    public void createNotification(Notification n){notificationRep.createNewNotification(n);}
    public void createNotifications(List<Notification> n){notificationRep.createNewNotification(n);}

}
