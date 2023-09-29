package Largest3Numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        Arrays.stream(numArr)
                .sorted()
                .forEach(System.out::println);
    }
}
