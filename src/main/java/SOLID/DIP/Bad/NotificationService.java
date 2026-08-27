package SOLID.OCP.Bad;

import SOLID.OCP.Good.EmailNotificationService;
import SOLID.OCP.Good.SMSNotificationService;

public class NotificationService {

   private EmailNotificationService emailNotificationService;
   private SMSNotificationService smsNotificationService;

   private String Email;
   private String sms;

    public NotificationService(String Email, String sms)
    {
        this.Email = Email;
        this.sms = sms;
    }

    public void sendNotification(String NotificationMode)
    {
        if(NotificationMode.equals("Email"))
        {
           emailNotificationService.sendNotification();
        }
        else if(NotificationMode.equals("SMS"))
        {
            smsNotificationService.sendNotification();
        }
    }
}
