package Problems.ParkingLot.Repositories;

import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Domain.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SlotRepository {


    private Map<UUID, ParkingSlot> slots = new ConcurrentHashMap<>();

    public List<ParkingSlot> allocateSlot(Vehicle vehicle) {
        return slots.values().stream()
                .filter(slot -> slot.getVehicleType()==vehicle.getVehicleType() && !slot.isOccupied())
                .collect(Collectors.toList());
    }
}
