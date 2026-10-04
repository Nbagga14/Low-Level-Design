package Problems.ParkingLot.Controllers;

import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Repositories.SlotRepository;
import Problems.ParkingLot.Services.PricingService;
import Problems.ParkingLot.Services.PricingStrategy;
import Problems.ParkingLot.Services.ReceiptService;
import Problems.ParkingLot.Services.SlotService;
import Problems.ParkingLot.Services.WeekdayPricingStrategy;
import Problems.ParkingLot.Services.WeekendPricingStrategy;

import java.util.UUID;

public class AdminController {

    private SlotService slotService;
    private SlotRepository slotRepository;
    private PricingService pricingService;
    private ReceiptService receiptService;

    public AdminController(SlotService slotService, SlotRepository slotRepository,
                          PricingService pricingService, ReceiptService receiptService) {
        this.slotService = slotService;
        this.slotRepository = slotRepository;
        this.pricingService = pricingService;
        this.receiptService = receiptService;
        System.out.println("[ADMIN CONTROLLER] AdminController initialized");
    }

    public void addSlot(ParkingSlot parkingSlot) {
        try {
            System.out.println("\n[ADMIN] Adding new parking slot...");
            slotRepository.addSlot(parkingSlot);
            System.out.println("[ADMIN] ✓ Slot added successfully!");
            System.out.println("[ADMIN] Total slots now: " + slotRepository.getTotalSlots());
        } catch (Exception e) {
            System.out.println("[ADMIN] ❌ Error adding slot: " + e.getMessage());
        }
    }

    public void removeSlot(UUID slotId) {
        try {
            System.out.println("\n[ADMIN] Removing parking slot: " + slotId);
            slotRepository.removeSlot(slotId);
            System.out.println("[ADMIN] ✓ Slot removed successfully!");
            System.out.println("[ADMIN] Total slots now: " + slotRepository.getTotalSlots());
        } catch (Exception e) {
            System.out.println("[ADMIN] ❌ Error removing slot: " + e.getMessage());
        }
    }

    public void changePricingStrategyToWeekday() {
        System.out.println("\n[ADMIN] Changing pricing strategy to WEEKDAY...");
        PricingStrategy weekdayStrategy = new WeekdayPricingStrategy();
        pricingService.setPricingStrategy(weekdayStrategy);
        System.out.println("[ADMIN] ✓ Pricing strategy changed to: " + weekdayStrategy.getStrategyName());
    }

    public void changePricingStrategyToWeekend() {
        System.out.println("\n[ADMIN] Changing pricing strategy to WEEKEND...");
        PricingStrategy weekendStrategy = new WeekendPricingStrategy();
        pricingService.setPricingStrategy(weekendStrategy);
        System.out.println("[ADMIN] ✓ Pricing strategy changed to: " + weekendStrategy.getStrategyName());
    }

    public void changePricingStrategy(PricingStrategy strategy) {
        System.out.println("\n[ADMIN] Changing pricing strategy to custom strategy...");
        pricingService.setPricingStrategy(strategy);
        System.out.println("[ADMIN] ✓ Pricing strategy changed to: " + strategy.getStrategyName());
    }

    public void viewParkingLotStatus() {
        System.out.println("\n========== PARKING LOT STATUS ==========");
        System.out.println("[ADMIN] Total Slots: " + slotRepository.getTotalSlots());
        System.out.println("[ADMIN] Available Slots: " + slotRepository.getAvailableSlots());
        System.out.println("[ADMIN] Occupied Slots: " + (slotRepository.getTotalSlots() - slotRepository.getAvailableSlots()));
        System.out.println("[ADMIN] Current Pricing Strategy: " + pricingService.getCurrentStrategy());
        System.out.println("==========================================");
    }
}