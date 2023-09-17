package CarInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Car car;
        for (int i = 0; i < n; i++) {
            String[] carArr = scanner.nextLine().split(" ");
            if (carArr.length == 3) {
                car = new Car(carArr[0], carArr[1], Integer.parseInt(carArr[2]));
            } else if (carArr.length == 1) {
                car = new Car(carArr[0]);
            } else {
                car = new Car(carArr[1], carArr[0]);
            }


            System.out.println(car.carInfo());

        }
    }
}
