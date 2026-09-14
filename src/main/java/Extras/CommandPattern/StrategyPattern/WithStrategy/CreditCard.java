package Extras.CommandPattern.StrategyPattern.WithStrategy;

public class CreditCard implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing payment through Credit Card");
    }
}
