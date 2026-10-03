package Problems.ParkingLot;

import Problems.ParkingLot.Controllers.EntryController;
import Problems.ParkingLot.Controllers.ExitController;
import Problems.ParkingLot.Enums.PaymentGateway;
import Problems.ParkingLot.Repositories.SlotRepository;
import Problems.ParkingLot.Services.*;

import java.util.UUID;

public class ParkingSlotSimulation {
    public static void main(String[] args)
    {
        System.out.println("========== PARKING LOT MANAGEMENT SYSTEM ==========\n");

        // Initialize Repositories
        SlotRepository slotRepository = new SlotRepository();

        // Initialize Services
        TicketService ticketService = new TicketService();
        ReceiptService receiptService = new ReceiptService();
        SlotService slotService = new SlotService(slotRepository);
        PricingService pricingService = new PricingService();
        PaymentService paymentService = new PaymentService(PaymentGateway.RAZORPAY);

        // Initialize Controllers
        EntryController entryController = new EntryController(ticketService, slotService, receiptService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService, receiptService, slotService);

        System.out.println("========== SYSTEM INITIALIZED ==========\n");

        // Simulate Vehicle Entry
        System.out.println("==================== ENTRY SIMULATION ====================");
        entryController.allocateSlot();

        // Simulate Vehicle Exit with RazorPay
        System.out.println("\n==================== EXIT SIMULATION (RAZORPAY) ====================");
        UUID ticketId = UUID.randomUUID();
        exitController.exitVehicle(ticketId);

        // Simulate Vehicle Exit with Stripe
        System.out.println("\n==================== EXIT SIMULATION (STRIPE) ====================");
        UUID ticketId2 = UUID.randomUUID();
        exitController.exitVehicleWithGatewaySelection(ticketId2, PaymentGateway.STRIPE);

        System.out.println("\n========== SIMULATION COMPLETED ==========");

    }
}
