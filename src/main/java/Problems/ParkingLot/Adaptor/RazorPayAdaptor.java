package Problems.ParkingLot.Adaptor;

public class RazorPayAdaptor implements PaymentGatewayAdaptor {

    @Override
    public boolean pay(double amount) {
        System.out.println("[RAZORPAY] Processing payment of ₹" + amount);
        System.out.println("[RAZORPAY] Payment gateway: RazorPay");
        System.out.println("[RAZORPAY] Transaction initiated...");

        // Simulate payment processing
        try {
            Thread.sleep(500); // Simulate processing time
            System.out.println("[RAZORPAY] Payment successful for amount: ₹" + amount);
            return true;
        } catch (InterruptedException e) {
            System.out.println("[RAZORPAY] Payment failed: " + e.getMessage());
            return false;
        }
    }
}
