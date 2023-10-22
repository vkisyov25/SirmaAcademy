package Vehicles;

public class Car {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
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
        fuelQuantity += liters;
    }
}
