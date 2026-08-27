package SOLID.OCP.BadExample2;

public class PaymentProcessor {

    private int payment;
    private String paymentMethod;;

    public PaymentProcessor(int payment)
    {
        this.payment = payment;
    }

    public void sendPayment(String paymentMethod)
    {
        if(paymentMethod.equals("Debit Card"))
        {
            System.out.print("Payment of " + payment + " sent using Debit Card");
        }
        else if(paymentMethod.equals("Credit Card"))
        {
            System.out.print("Payment of " + payment + " sent using Credit Card");
        }

    }


}
