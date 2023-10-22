package Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String[] carArr = scanner.nextLine().split(" ");
        Car car  = new Car(Double.parseDouble(carArr[1]),Double.parseDouble(carArr[2]));
        String[] truckArr = scanner.nextLine().split(" ");
        Truck truck  = new Truck(Double.parseDouble(truckArr[1]),Double.parseDouble(truckArr[2]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            if (inputArr[0].equals("Drive")) {
                if (inputArr[1].equals("Car")) {
                    double fuelNeeded = (car.getFuelConsumptionInLitersPerKm() + 0.9) * Double.parseDouble(inputArr[2]);
                    if(car.getFuelQuantity()>= fuelNeeded){
                        car.setFuelQuantity(fuelNeeded);
                        System.out.printf("Car travelled %.2f km\n",Double.parseDouble(inputArr[2]));
                    }else {
                        System.out.println("Car needs refueling");
                    }
                } else {
                    double fuelNeeded = (truck.getFuelConsumptionInLitersPerKm() + 1.6) * Double.parseDouble(inputArr[2]);
                    if(truck.getFuelQuantity()> fuelNeeded){
                        System.out.printf("Truck travelled %.2f km\n",Double.parseDouble(inputArr[2]));
                        truck.setFuelQuantity(fuelNeeded);
                    }else {
                        System.out.println("Truck needs refueling");
                    }
                }

            } else {
                if (inputArr[1].equals("Car")) {
                    car.refuel(Double.parseDouble(inputArr[2]));
                } else {
                    truck.refuel(Double.parseDouble(inputArr[2]));
                }
            }


        }
        System.out.println("Car: " + df.format(car.getFuelQuantity()));
        System.out.println("Truck: " + df.format(truck.getFuelQuantity()));
    }
}
