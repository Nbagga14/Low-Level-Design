package Problems.ParkingLot.Domain;

import Problems.ParkingLot.Enums.PaymentGateway;

import java.util.UUID;

public class Payment {

    private UUID uuid;
    private double amount;
    private UUID ticketId;

    public Payment(UUID uuid, double amount, UUID ticketId, PaymentGateway paymentGateway) {
        this.uuid = uuid;
        this.amount = amount;
        this.ticketId = ticketId;
        this.paymentGateway = paymentGateway;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private PaymentGateway paymentGateway;

}
