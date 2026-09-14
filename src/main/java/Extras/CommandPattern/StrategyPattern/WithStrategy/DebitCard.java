package Extras.CommandPattern.StrategyPattern.WithStrategy;

public class DebitCard implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing payment through Debit Card");
    }
}
