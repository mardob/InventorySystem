package com.freeSystems.InventorySystem.NotificationSystem.data.beans;

import com.freeSystems.InventorySystem.NotificationSystem.utilities.Spoilage;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "NOTIFICATION_ID", unique = true, nullable = false)
   private long notificationId;
   @Column(name = "SPOILAGE", nullable = false)
   private Spoilage spoilage;
   @Column(name = "DATE_OF_CREATION", nullable = true)
   private Date dateOfCreation;

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

   @Column(name = "ITEM_ID", nullable = true)
   private long itemId;
   @Column(name = "NAME", nullable = true)
   private String name;


   public Notification() {
      dateOfCreation = new Date();
   }

   public Notification(Spoilage spoilage, long iemId, String name) {
      this.spoilage = spoilage;
      this.itemId = iemId;
      this.name = name;
      this.dateOfCreation = new Date();
   }
   public Notification(Spoilage spoilage, long iemId) {
      this.spoilage = spoilage;
      this.itemId = iemId;
      this.dateOfCreation = new Date();
   }

   public long getNotificationId() {
      return notificationId;
   }

   public void setNotificationId(long notificationId) {
      this.notificationId = notificationId;
   }

   public Spoilage getSpoilage() {
      return spoilage;
   }

   public void setSpoilage(Spoilage spoilage) {
      this.spoilage = spoilage;
   }

   public Date getDateOfCreation() {
      return dateOfCreation;
   }

   public void setDateOfCreation(Date dateOfCreation) {
      this.dateOfCreation = dateOfCreation;
   }

}
