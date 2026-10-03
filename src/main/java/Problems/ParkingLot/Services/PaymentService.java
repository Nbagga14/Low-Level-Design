package Problems.ParkingLot.Services;

import Problems.ParkingLot.Adaptor.PaymentGatewayAdaptor;
import Problems.ParkingLot.Adaptor.RazorPayAdaptor;
import Problems.ParkingLot.Adaptor.StripeAdaptor;
import Problems.ParkingLot.Enums.PaymentGateway;

public class PaymentService {

    private PaymentGatewayAdaptor paymentGateway;

    public PaymentService(PaymentGateway gateway) {
        initializePaymentGateway(gateway);
    }

    private void initializePaymentGateway(PaymentGateway gateway) {
        switch (gateway) {
            case RAZORPAY:
                this.paymentGateway = new RazorPayAdaptor();
                System.out.println("[PAYMENT SERVICE] Initialized with RazorPay");
                break;
            case STRIPE:
                this.paymentGateway = new StripeAdaptor();
                System.out.println("[PAYMENT SERVICE] Initialized with Stripe");
                break;
            default:
                this.paymentGateway = new RazorPayAdaptor();
                System.out.println("[PAYMENT SERVICE] Default: RazorPay");
        }
    }

    public boolean processPayment(double amount) {
        System.out.println("[PAYMENT SERVICE] Processing payment of ₹" + amount);
        return paymentGateway.pay(amount);
    }

    public void switchPaymentGateway(PaymentGateway gateway) {
        System.out.println("[PAYMENT SERVICE] Switching payment gateway...");
        initializePaymentGateway(gateway);
    }
}
