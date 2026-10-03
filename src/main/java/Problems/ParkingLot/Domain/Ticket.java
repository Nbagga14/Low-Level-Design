package Problems.ParkingLot.Domain;

import java.util.UUID;

public class Ticket {

    private UUID Id;
    private UUID vehicleId;
    private UUID slotId;
    private boolean isActive;

    public Ticket(UUID id, UUID vehicleId, UUID slotId, boolean isActive) {
        Id = id;
        this.vehicleId = vehicleId;
        this.slotId = slotId;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }


    public void deactivateTicket()
    {
       this.isActive=false;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id=" + Id +
                ", vehicleId=" + vehicleId +
                ", slotId=" + slotId +
                ", isActive=" + isActive +
                '}';
    }
}
