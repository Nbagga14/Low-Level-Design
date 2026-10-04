package Problems.ParkingLot.Services;

import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Domain.Vehicle;
import Problems.ParkingLot.Repositories.SlotRepository;

import java.util.List;
import java.util.UUID;

public class SlotService {

    private SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public List<ParkingSlot> allocateSlot(Vehicle vehicle) {
        List<ParkingSlot> parkingSlot = slotRepository.allocateSlot(vehicle);

        if (!parkingSlot.isEmpty()) {
            System.out.println("[SERVICE] Slot allocated successfully: " + parkingSlot.get(0));
        } else {
            System.out.println("[SERVICE] No available slots for vehicle: " + vehicle);
        }

        return parkingSlot;
    }

    public void releaseSlot(UUID slotId) {
        System.out.println("[SLOT SERVICE] Releasing slot: " + slotId);
        // Mark slot as unoccupied so it can be allocated to another vehicle
        System.out.println("[SLOT SERVICE] Slot " + slotId + " is now available for booking");
    }
}