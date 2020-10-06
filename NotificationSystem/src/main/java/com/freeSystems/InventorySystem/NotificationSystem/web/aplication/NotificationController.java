package com.freeSystems.InventorySystem.NotificationSystem.web.aplication;

import com.freeSystems.InventorySystem.NotificationSystem.business.service.BatchService;
import com.freeSystems.InventorySystem.NotificationSystem.business.service.NotificationService;
import com.freeSystems.InventorySystem.NotificationSystem.data.beans.Notification;
import com.freeSystems.InventorySystem.NotificationSystem.utilities.Spoilage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/notifications/")
public class NotificationController {

    @Autowired
    NotificationService service;

    //TODO temporary mapping
    @Autowired
    BatchService batchService;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/getAllNotifications")
    @ResponseBody
    public List<Notification> getNotifications(){
        List<Notification> notes = new ArrayList<Notification>();
        service.getNotifications().forEach(notes::add);
        return notes;
    }

    @RequestMapping(method= RequestMethod.GET, value="/delete")
    @ResponseBody
    public void deleteNotificationById(@RequestParam(value="id", required=true) long id){
        service.deleteNotification(id);
    }


    // TODO debugging methods not needed for final product

    @RequestMapping(method= RequestMethod.GET, value="/create")
    @ResponseBody
    public void tempCreateNotification(@Valid @NotBlank @RequestParam(value="spoilage", required=true) Spoilage spoilage, @NotBlank @RequestParam(value="itemId", required=true) int itemId, @NotBlank @RequestParam(value="itemName", required=true) String itemName){
        Notification n = new Notification(spoilage,itemId,itemName);
        service.createNotification(n);
    }

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value="/test")
    @ResponseBody
    public Notification test() {
        Notification n = new Notification();
        n.setSpoilage(Spoilage.SPOILED);
        return n;
    }

    @RequestMapping(method= RequestMethod.GET, value="/runNotificationCalculation")
    @ResponseBody
    public void runNotificationCalculation() {
        batchService.checkForItemSpoilage();
    }

}
