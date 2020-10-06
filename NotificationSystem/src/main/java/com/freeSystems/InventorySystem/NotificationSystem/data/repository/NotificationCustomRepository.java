package com.freeSystems.InventorySystem.NotificationSystem.data.repository;

import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import java.util.List;

public interface NotificationCustomRepository {
    void createNewNotification(Notification i);

    void createNewNotification(List<Notification> i);

}
