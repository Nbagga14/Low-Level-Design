package Problems.ParkingLot.Domain;

import Problems.ParkingLot.Enums.VehicleType;

public class Vehicle {
    private int vehicleId;
    private VehicleType vehicleType;
    private String numberPlate;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle(int vehicleId, String numberPlate, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }
}
