package Problems.ParkingLot.Controllers;


import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Domain.Receipt;
import Problems.ParkingLot.Domain.Ticket;
import Problems.ParkingLot.Domain.Vehicle;
import Problems.ParkingLot.Enums.VehicleType;
import Problems.ParkingLot.Services.ReceiptService;
import Problems.ParkingLot.Services.SlotService;
import Problems.ParkingLot.Services.TicketService;

import java.util.List;

public class EntryController {

    private TicketService ticketService;
    private SlotService slotService;
    private ReceiptService receiptService;

    public EntryController(TicketService ticketService, SlotService slotService, ReceiptService receiptService) {
        this.ticketService = ticketService;
        this.slotService = slotService;
        this.receiptService = receiptService;
    }

    public void allocateSlot() {
        Vehicle vehicle = new Vehicle(1, "HR85", VehicleType.CAR);
        List<ParkingSlot> slots = slotService.allocateSlot(vehicle);

        if (!slots.isEmpty()) {
            ParkingSlot allocatedSlot = slots.get(0);
            System.out.println("[CONTROLLER] Slot allocated: " + allocatedSlot.getUuid());

            // Generate Ticket
            Ticket ticket = ticketService.generateTicket(vehicle, allocatedSlot);
            System.out.println("[CONTROLLER] Ticket generated: " + ticket.getId());

            // Generate Receipt
            double fee = 100.0; // Default fee, can be calculated by PricingService
            Receipt receipt = receiptService.generateReceipt(ticket, fee);
            System.out.println("[CONTROLLER] Receipt generated: " + receipt.getId());

            // Mark receipt as paid
            receiptService.markReceiptAsPaid(receipt);

            // Book the slot (mark as occupied)
            allocatedSlot.setOccupied(true);
            System.out.println("[CONTROLLER] Slot booked and marked as occupied: " + allocatedSlot.getUuid());

        } else {
            System.out.println("[CONTROLLER] No slots available for vehicle");
        }
    }
}