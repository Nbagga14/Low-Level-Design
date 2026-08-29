package StrategyPattern.WithStrategy;

public class PaymentStrategyImpl {

    PaymentStrategy paymentStrategy;


    public void setPaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy=paymentStrategy;
    }

    public void processPayment(){
        paymentStrategy.processPayment();
    }

    public static void main(String[] args) {

        PaymentStrategyImpl paymentStrategyImpl = new PaymentStrategyImpl();
        CreditCard creditCard = new CreditCard();
        DebitCard debitCard = new DebitCard();



        paymentStrategyImpl.setPaymentProcessor(creditCard);
        paymentStrategyImpl.processPayment();

        paymentStrategyImpl.setPaymentProcessor(debitCard);
        paymentStrategyImpl.processPayment();


    }

}
