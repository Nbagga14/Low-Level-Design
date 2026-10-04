package Problems.ParkingLot.Services;

import Problems.ParkingLot.Domain.ParkingSlot;
import Problems.ParkingLot.Domain.Ticket;
import Problems.ParkingLot.Domain.Vehicle;

import java.util.UUID;

public class TicketService {

    public Ticket generateTicket(Vehicle vehicle, ParkingSlot slot) {
        UUID ticketId = UUID.randomUUID();
        UUID vehicleId = UUID.nameUUIDFromBytes(String.valueOf(vehicle.getVehicleId()).getBytes());
        UUID slotId = slot.getUuid();

        Ticket ticket = new Ticket(ticketId, vehicleId, slotId, true);

        System.out.println("[TICKET SERVICE] Ticket generated: " + ticket);
        return ticket;
    }

    public void deactivateTicket(UUID ticketId) {
        System.out.println("[TICKET SERVICE] Ticket deactivated: " + ticketId);
    }
}
