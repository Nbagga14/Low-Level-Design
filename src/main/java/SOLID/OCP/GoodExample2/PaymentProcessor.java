package SOLID.OCP.GoodExample2;

public class PaymentProcessor implements PaymentMethod {

    private int amount;

    public PaymentProcessor(int amount) {
        this.amount = amount;

    }

    @Override
    public void pay() {
        System.out.println("Payment of " + amount + " processed successfully.");

    }
}
