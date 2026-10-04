package Problems.ParkingLot.Domain;

import Problems.ParkingLot.Enums.VehicleType;

import java.util.UUID;

public class ParkingSlot {

    private UUID uuid;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private int floorNumber;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingSlot(UUID uuid, VehicleType vehicleType, boolean isOccupied, int floorNumber) {
        this.uuid = uuid;
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
        this.floorNumber = floorNumber;
    }

}
