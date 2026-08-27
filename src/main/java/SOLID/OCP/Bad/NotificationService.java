package SOLID.DIP.Bad;

public class NotificationService {

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
            System.out.println("Sending email to: " + Email);
        }
        else if(NotificationMode.equals("SMS"))
        {
            System.out.println("Sending SMS to: " + sms);
        }
    }
}
