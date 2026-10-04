package Problems.ParkingLot.Services;

import Problems.ParkingLot.Domain.Receipt;
import Problems.ParkingLot.Domain.Ticket;

public class ReceiptService {

    public Receipt generateReceipt(Ticket ticket, double fee) {
        Receipt receipt = new Receipt(ticket.getId(), fee);
        System.out.println("[RECEIPT SERVICE] Receipt generated: " + receipt);
        return receipt;
    }

    public void markReceiptAsPaid(Receipt receipt) {
        receipt.markAsPaid();
        System.out.println("[RECEIPT SERVICE] Receipt marked as paid: " + receipt.getId());
    }
}
