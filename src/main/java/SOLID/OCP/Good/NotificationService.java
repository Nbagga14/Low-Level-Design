package SOLID.OCP.Good;

import java.util.List;

public class NotificationService implements NotifierObject{

    public List<NotifierObject> notificationMode;


    public NotificationService(List<NotifierObject> notificationMode)
    {
        this.notificationMode = notificationMode;
    }

    @Override
    public void sendNotification() {

        for(NotifierObject notifier : notificationMode)
        {
            notifier.sendNotification();
//            System.out.print("Notification sent successfully via" + notifier);
        }
    }
}
