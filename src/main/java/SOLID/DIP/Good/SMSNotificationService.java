package SOLID.DIP.Good;

public class SMSNotificationService implements NotifierObject {

    private String text;

    public SMSNotificationService(String text)
    {
        this.text = text;
    }

    @Override
    public void sendNotification() {
        System.out.println("Notification sent with text " +text);
    }
}
