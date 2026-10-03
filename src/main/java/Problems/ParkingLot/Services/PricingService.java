package Problems.ParkingLot.Services;

import Problems.ParkingLot.Domain.Ticket;

import java.time.LocalDateTime;

public class PricingService {

    private static final double HOURLY_RATE = 50.0; // ₹50 per hour

    public double calculateFee(Ticket ticket) {
        // For now, use a simple calculation based on duration
        // In a real scenario, you'd have entry and exit times
        long durationInMinutes = 60; // Default 1 hour

        double fee = (durationInMinutes / 60.0) * HOURLY_RATE;
        System.out.println("[PRICING SERVICE] Fee calculated for ticket " + ticket.getId() + ": ₹" + fee);

        return fee;
    }

    public double calculateFee(long durationInMinutes) {
        double fee = (durationInMinutes / 60.0) * HOURLY_RATE;
        System.out.println("[PRICING SERVICE] Fee calculated for duration " + durationInMinutes + " minutes: ₹" + fee);

        return fee;
    }
}
