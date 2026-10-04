package Problems.ParkingLot.Domain;

import java.util.List;

public class Floor {

    private int floorId;
    private int floorNumber;
    private List<ParkingSlot> slots;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public Floor(int floorId, List<ParkingSlot> slots, int floorNumber) {
        this.floorId = floorId;
        this.slots = slots;
        this.floorNumber = floorNumber;
    }
}
