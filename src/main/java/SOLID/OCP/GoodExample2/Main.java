package SOLID.OCP.GoodExample2;

public class Main {

    public static void main(String[] args) {
        PaymentMethod creditCardPayment = new CreditCard(100);
        PaymentMethod debitCardPayment = new DebitCard(200);

        creditCardPayment.pay();
        debitCardPayment.pay();

    }
}
