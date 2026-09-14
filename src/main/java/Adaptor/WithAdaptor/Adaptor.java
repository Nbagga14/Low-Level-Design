package Adaptor.WithAdaptor;


import org.springframework.context.annotation.Import;

interface PaymentMethod
{
    public void Pay();
}


class PayU implements PaymentMethod{

    @Override
    public void Pay() {
        System.out.println("Making payment via Payu");
    }
}

class RazorPayAPI
{
    public void makePayment()
    {
        System.out.println("Making payment via Razorpay");
    }
}

class RazorPayAdaptor implements PaymentMethod{
    private RazorPayAPI razorPayAPI;

    public RazorPayAdaptor()
    {
        this.razorPayAPI = new RazorPayAPI();
    }
    @Override
    public void Pay() {
        razorPayAPI.makePayment();
    }
}

class CheckoutService{
    PaymentMethod paymentMethod;

    public CheckoutService(PaymentMethod paymentMethod)
    {
        this.paymentMethod=paymentMethod;
    }

    public void makePayment()
    {
        paymentMethod.Pay();
    }
}

public class Adaptor {
    public static void main(String[] args) {
      CheckoutService checkoutService1 = new CheckoutService(new PayU());
      checkoutService1.makePayment();

      CheckoutService checkoutService2 = new CheckoutService(new RazorPayAdaptor());
      checkoutService2.makePayment();
    }
}
