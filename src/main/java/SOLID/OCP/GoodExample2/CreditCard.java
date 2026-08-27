package SOLID.OCP.GoodExample2;

public class CreditCard implements PaymentMethod {

    private int amount;

    public CreditCard(int amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Payment of " + amount + " processed successfully using Credit Card.");
    }
}
