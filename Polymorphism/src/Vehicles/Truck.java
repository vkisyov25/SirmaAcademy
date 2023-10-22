package Vehicles;

public class Truck {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity -= fuelQuantity;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    public void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public void refuel(double liters) {
        fuelQuantity += liters * 0.95; // Take into account the 5% loss
    }
}

