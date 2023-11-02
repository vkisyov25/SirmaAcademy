package com.hrrs;

import com.hrrs.User.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMainMenu();
        int num = Integer.parseInt(scanner.nextLine());
        UserManager userManager = new UserManager();
        while (num <= 6) {

            if (num == 1) {
                registration(scanner, userManager);
            } else if (num == 2) {
                login(scanner, userManager);
            } else if (num == 3) {

            } else if (num == 4) {

            } else if (num == 5) {

            } else if (num == 6) {

            }

            num = Integer.parseInt(scanner.nextLine());
        }

    }

    private static void login(Scanner scanner, UserManager userManager) {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        User user = userManager.login(username, password);
        if(user==null){
            System.out.println("You don't have profile and you have to make registration");
        }else {
            System.out.println("Successful login");
        }
    }

    private static void registration(Scanner scanner, UserManager userManager) {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        userManager.registerUser(username, password);
    }


    public static void printMainMenu() {
        System.out.print("\nWelcome to the Hotel Reservation Application\n" +
                "--------------------------------------------\n" +
                "1. Registration\n" +
                "2. Login\n" +
                "3. Reservation\n" +
                "4. Reservation cancelled\n" +
                "5. Overview of available rooms\n" +
                "6. Exit\n" +
                "--------------------------------------------\n" +
                "Please select a number for the menu option:\n");
    }
}
