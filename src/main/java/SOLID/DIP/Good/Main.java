package SOLID.DIP.Good;

import SOLID.OCP.Good.NotificationService;
import SOLID.OCP.Good.NotifierObject;
import SOLID.OCP.Good.SMSNotificationService;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        NotifierObject emailNotification = new EmailNotificationService("Email");
        NotifierObject smsNotification = new SMSNotificationService("SMS");

        List<NotifierObject> notificationModes = List.of(emailNotification, smsNotification);

        NotificationService notificationService = new NotificationService(notificationModes);
        notificationService.sendNotification();
    }

}
