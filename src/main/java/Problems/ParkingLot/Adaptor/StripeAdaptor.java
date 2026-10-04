package Problems.ParkingLot.Adaptor;

public class StripeAdaptor implements PaymentGatewayAdaptor {

    @Override
    public boolean pay(double amount) {
        System.out.println("[STRIPE] Processing payment of $" + String.format("%.2f", amount / 83.0)); // Convert to USD
        System.out.println("[STRIPE] Payment gateway: Stripe");
        System.out.println("[STRIPE] Transaction initiated...");

        // Simulate payment processing
        try {
            Thread.sleep(500); // Simulate processing time
            System.out.println("[STRIPE] Payment successful for amount: $" + String.format("%.2f", amount / 83.0));
            return true;
        } catch (InterruptedException e) {
            System.out.println("[STRIPE] Payment failed: " + e.getMessage());
            return false;
        }
    }
}
