package Problems.ParkingLot.Controllers;

import Problems.ParkingLot.Domain.Receipt;
import Problems.ParkingLot.Domain.Ticket;
import Problems.ParkingLot.Enums.PaymentGateway;
import Problems.ParkingLot.Services.PaymentService;
import Problems.ParkingLot.Services.PricingService;
import Problems.ParkingLot.Services.ReceiptService;
import Problems.ParkingLot.Services.SlotService;
import Problems.ParkingLot.Services.TicketService;

import java.util.UUID;

public class ExitController {
    private TicketService ticketService;
    private PricingService pricingService;
    private PaymentService paymentService;
    private ReceiptService receiptService;
    private SlotService slotService;

    public ExitController(TicketService ticketService, PricingService pricingService,
                          PaymentService paymentService, ReceiptService receiptService,
                          SlotService slotService) {
        this.ticketService = ticketService;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.receiptService = receiptService;
        this.slotService = slotService;
        System.out.println("[CONTROLLER] ExitController initialized");
    }

    public void exitVehicle(UUID ticketId) {
        System.out.println("\n========== VEHICLE EXIT PROCESS ==========");
        System.out.println("[CONTROLLER] Processing exit for Ticket: " + ticketId);

        try {
            // Step 1: Get the ticket that was generated
            System.out.println("\n[STEP 1] Retrieving ticket information...");
            // In real scenario, we would fetch from repository
            // For now, we'll create a mock ticket
            UUID vehicleId = UUID.randomUUID();
            UUID slotId = UUID.randomUUID();
            Ticket ticket = new Ticket(ticketId, vehicleId, slotId, true);
            System.out.println("[CONTROLLER] Ticket found: " + ticket);

            // Step 2: Calculate the parking fee
            System.out.println("\n[STEP 2] Calculating parking fee...");
            double parkingFee = pricingService.calculateFee(ticket);
            System.out.println("[CONTROLLER] Total amount to be paid: ₹" + parkingFee);

            // Step 3: Process payment through adaptor pattern
            System.out.println("\n[STEP 3] Processing payment...");
            System.out.println("[CONTROLLER] Selected payment gateway: " + paymentService.getClass().getSimpleName());

            boolean paymentSuccess = paymentService.processPayment(parkingFee);

            if (!paymentSuccess) {
                System.out.println("\n[CONTROLLER] ❌ Payment FAILED! Vehicle cannot exit.");
                return;
            }

            // Step 4: Generate receipt/invoice after successful payment
            System.out.println("\n[STEP 4] Generating receipt/invoice...");
            Receipt receipt = receiptService.generateReceipt(ticket, parkingFee);
            receiptService.markReceiptAsPaid(receipt);
            System.out.println("[CONTROLLER] Receipt generated with ID: " + receipt.getId());
            System.out.println("[CONTROLLER] Receipt Details:\n" + receipt);

            // Step 5: Release the slot back
            System.out.println("\n[STEP 5] Releasing parking slot...");
            slotService.releaseSlot(ticket.getSlotId());
            System.out.println("[CONTROLLER] Slot " + ticket.getSlotId() + " is now available");

            // Step 6: Mark the ticket as inactive/deactivated
            System.out.println("\n[STEP 6] Deactivating ticket...");
            ticketService.deactivateTicket(ticketId);
            ticket.deactivateTicket();

            System.out.println("\n[CONTROLLER] ✓ Vehicle exit successful!");
            System.out.println("==========================================\n");

        } catch (Exception e) {
            System.out.println("[CONTROLLER] ❌ Error during exit process: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void exitVehicleWithGatewaySelection(UUID ticketId, PaymentGateway gateway) {
        System.out.println("\n========== VEHICLE EXIT PROCESS ==========");
        System.out.println("[CONTROLLER] Switching to payment gateway: " + gateway);
        paymentService.switchPaymentGateway(gateway);

        exitVehicle(ticketId);
    }
}
