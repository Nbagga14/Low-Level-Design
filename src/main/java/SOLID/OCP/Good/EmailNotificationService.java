package SOLID.OCP.Good;

public class EmailNotificationService implements NotifierObject {

    private String text;

    public EmailNotificationService(String email) {
        this.text = email;
    }

    @Override
    public void sendNotification() {
        System.out.println("Email sent with text "+text);
    }
}
