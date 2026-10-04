package Problems.ParkingLot.Services;

import Problems.ParkingLot.Domain.Ticket;

public class PricingService {

    private PricingStrategy pricingStrategy;

    public PricingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        System.out.println("[PRICING SERVICE] Initialized with: " + pricingStrategy.getStrategyName());
    }

    public double calculateFee(Ticket ticket) {
        long durationInMinutes = 60; // Default 1 hour
        return calculateFee(durationInMinutes);
    }

    public double calculateFee(long durationInMinutes) {
        return pricingStrategy.calculateFee(durationInMinutes);
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
        System.out.println("[PRICING SERVICE] Pricing strategy changed to: " + strategy.getStrategyName());
    }

    public String getCurrentStrategy() {
        return pricingStrategy.getStrategyName();
    }
}
