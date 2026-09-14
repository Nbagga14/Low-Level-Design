package Adaptor.WOAdaptor;

interface PaymentMethod {
    public void pay();
}

class PayU implements PaymentMethod
{
    @Override
    public void pay() {
        System.out.print("Making payment via Payu");
    }
}

class RazorPayAPI
{
    public void makePayment()
    {
        System.out.print("Making payment via razorpay");
    }
}

class CheckoutService
{
    PaymentMethod paymentMethod;

    public CheckoutService(PaymentMethod paymentMethod)
    {
        this.paymentMethod=paymentMethod;
    }
    public void makePayment()
    {
        paymentMethod.pay();
    }

}

public class WOAdaptor {

    public static void main(String[] args) {

        PayU payU = new PayU();
        CheckoutService checkoutService =
                new CheckoutService(new PayU());

        checkoutService.makePayment();
    }
}







