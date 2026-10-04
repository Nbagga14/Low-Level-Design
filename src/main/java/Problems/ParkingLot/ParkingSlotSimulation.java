package Problems.ParkingLot;

import Problems.ParkingLot.Controllers.AdminController;
import Problems.ParkingLot.Controllers.EntryController;
import Problems.ParkingLot.Controllers.ExitController;
import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Enums.PaymentGateway;
import Problems.ParkingLot.Enums.VehicleType;
import Problems.ParkingLot.Repositories.SlotRepository;
import Problems.ParkingLot.Services.*;

import java.util.UUID;

public class ParkingSlotSimulation {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║     PARKING LOT MANAGEMENT SYSTEM - COMPLETE SIMULATION        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // ===================== INITIALIZATION =====================
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 1: INITIALIZING SYSTEM");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        // Initialize Repositories
        SlotRepository slotRepository = new SlotRepository();

        // Initialize Services with default weekday pricing
        TicketService ticketService = new TicketService();
        ReceiptService receiptService = new ReceiptService();
        SlotService slotService = new SlotService(slotRepository);
        PricingService pricingService = new PricingService(new WeekdayPricingStrategy());
        PaymentService paymentService = new PaymentService(PaymentGateway.RAZORPAY);

        // Initialize Controllers
        EntryController entryController = new EntryController(ticketService, slotService, receiptService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService, receiptService, slotService);
        AdminController adminController = new AdminController(slotService, slotRepository, pricingService, receiptService);

        System.out.println("\n✓ System initialized successfully!\n");

        // ===================== ADMIN OPERATIONS =====================
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 2: ADMIN OPERATIONS - ADDING PARKING SLOTS");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        // Add parking slots
        UUID slot1 = UUID.randomUUID();
        adminController.addSlot(new ParkingSlot(slot1, VehicleType.CAR, false, 1));

        UUID slot2 = UUID.randomUUID();
        adminController.addSlot(new ParkingSlot(slot2, VehicleType.CAR, false, 1));

        UUID slot3 = UUID.randomUUID();
        adminController.addSlot(new ParkingSlot(slot3, VehicleType.BIKE, false, 2));

        // View parking lot status
        adminController.viewParkingLotStatus();

        // ===================== VEHICLE ENTRY =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 3: VEHICLE ENTRY - ALLOCATING SLOTS");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        entryController.allocateSlot();

        // ===================== ADMIN CHANGES PRICING FOR WEEKEND =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 4: ADMIN CHANGES PRICING STRATEGY TO WEEKEND");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        adminController.changePricingStrategyToWeekend();
        adminController.viewParkingLotStatus();

        // ===================== VEHICLE EXIT WITH RAZORPAY =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 5: VEHICLE EXIT - PAYMENT WITH RAZORPAY (WEEKEND PRICING)");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        UUID ticketId1 = UUID.randomUUID();
        exitController.exitVehicle(ticketId1);

        // ===================== ADMIN ADDS MORE SLOTS =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 6: ADMIN ADDS MORE SLOTS");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        UUID slot4 = UUID.randomUUID();
        adminController.addSlot(new ParkingSlot(slot4, VehicleType.CAR, false, 3));
        adminController.viewParkingLotStatus();

        // ===================== VEHICLE EXIT WITH STRIPE =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 7: VEHICLE EXIT WITH STRIPE PAYMENT GATEWAY");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        UUID ticketId2 = UUID.randomUUID();
        exitController.exitVehicleWithGatewaySelection(ticketId2, PaymentGateway.STRIPE);

        // ===================== ADMIN CHANGES BACK TO WEEKDAY PRICING =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 8: ADMIN CHANGES PRICING BACK TO WEEKDAY");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        adminController.changePricingStrategyToWeekday();

        // ===================== FINAL STATUS =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 9: FINAL PARKING LOT STATUS");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        adminController.viewParkingLotStatus();

        // ===================== ADMIN REMOVES A SLOT =====================
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("STEP 10: ADMIN REMOVES A SLOT");
        System.out.println("═══════════════════════════════════════════════════════════════════");

        adminController.removeSlot(slot3);
        adminController.viewParkingLotStatus();

        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              SIMULATION COMPLETED SUCCESSFULLY                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }
}
