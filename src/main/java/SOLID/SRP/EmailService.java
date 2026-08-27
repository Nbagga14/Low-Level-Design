package SOLID.SRP;

public class EmailService {

    private String Email;

    public EmailService(String Email)
    {
        this.Email = Email;
    }

    public void sendEmail()
    {
        System.out.println("Sending email to: " + Email);
    }
}
