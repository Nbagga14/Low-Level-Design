package SOLID.OCP.GoodExample2;

public class DebitCard implements PaymentMethod {

    private int amount;

    public DebitCard(int amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Payment of " + amount + " processed successfully using Debit Card.");
    }
}
