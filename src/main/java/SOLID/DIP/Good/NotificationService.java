package SOLID.DIP.Good;

import java.util.List;

public class NotificationService {

    private final List<NotifierObject> notificationModes;

    public NotificationService(List<NotifierObject> notificationModes) {
        this.notificationModes = notificationModes;
    }

    public void sendNotification() {
        for (NotifierObject notifier : notificationModes) {
            notifier.sendNotification();
        }
    }
}
