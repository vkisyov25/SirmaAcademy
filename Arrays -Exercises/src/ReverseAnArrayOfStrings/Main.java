package ReverseAnArrayOfStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");

        for (int i = arr.length-1; i>=0; i--) {
            System.out.printf("%s ",arr[i]);
        }
    }
}
