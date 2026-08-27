package SOLID.DIP.Good;

import SOLID.OCP.Good.NotifierObject;

public class EmailNotificationService implements NotifierObject {

    private String text;

    public EmailNotificationService(String email) {
        this.text = email;
    }

    @Override
    public void sendNotification() {
        System.out.println("Notification sent with text "+text);
    }
}
