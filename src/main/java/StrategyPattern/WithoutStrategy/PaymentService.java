package StrategyPattern.WithoutStrategy;

public class PaymentService {

    public void processPayment(String PaymentMethod )
    {
     if(PaymentMethod.equals("CreditCard"))
     {
        System.out.println("Processing payment through Credit Card");
     }
     else if(PaymentMethod.equals("PayPal"))
     {
        System.out.println("Processing payment through PayPal");
     }
     else if(PaymentMethod.equals("Bitcoin"))
     {
        System.out.println("Processing payment through Bitcoin");
     }
     else
     {
        System.out.println("Invalid payment method");
     }
    }

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("CreditCard");
        paymentService.processPayment("PayPal");
        paymentService.processPayment("Bitcoin");
        paymentService.processPayment("Cash");
    }
}








