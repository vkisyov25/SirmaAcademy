package com.hrrs;

import com.hrrs.Reservation.Reservation;
import com.hrrs.Room.Room;
import com.hrrs.User.User;

import java.io.IOException;
import java.util.Scanner;

import static com.hrrs.Room.Status.AVAILABLE;
import static com.hrrs.Room.Status.BOOKED;
import static com.hrrs.Room.TypeRoom.SINGLE;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printMainMenu();
        int num = Integer.parseInt(scanner.nextLine());
        UserManager userManager = new UserManager();
        RoomManagement roomManagement= new RoomManagement();
        ReservationManager reservationManager = new ReservationManager();

        //for testing
        roomManagement.addRoom(new Room(210,SINGLE,50,10,AVAILABLE));
        roomManagement.addRoom(new Room(211,SINGLE,60,10,AVAILABLE));
        roomManagement.addRoom(new Room(212,SINGLE,70,10,AVAILABLE));


        int loginIndex = -1;
        while (num <= 6) {

            if (num == 1) {
                registration(scanner, userManager);
            } else if (num == 2) {
                loginIndex = login(scanner, userManager);
            } else if (num == 3) {
                reservation(scanner, reservationManager, loginIndex);

            } else if (num == 4) {
                if(loginIndex != -1){
                    System.out.println("Do you cancel a reservation: Yes/No");
                    String  command = scanner.nextLine();
                    System.out.println("This is our reservations");
                    //problem
                    /*for (int i = 0; i < ReservationManager.getReservations().size(); i++) {
                        System.out.printf("%d. %s\n",i+1,ReservationManager.getReservations().get(i));
                    }*/
                    for (int i = 0; i < User.getBookingHistory().size(); i++) {
                        System.out.printf("%d. %s\n",i+1,User.getBookingHistory().get(i));
                    }
                    System.out.println("Which reservation you want to cancel?");
                    int roomNum = Integer.parseInt(scanner.nextLine());
                    if(command.equals("Yes")){
                        reservationManager.cancelReservation(ReservationManager.getReservations().get(roomNum-1));
                    }
                }else {
                    System.out.println("You don't login in you account");
                }
            } else if (num == 5) {

            } else if (num == 6) {

            }

            System.out.println("Please select a number for the menu option: ");
            num = Integer.parseInt(scanner.nextLine());
        }

    }


    private static void reservation(Scanner scanner, ReservationManager reservationManager, int loginIndex) {
        if(loginIndex != -1){
            System.out.println("Do you make a reservation: Yes/No");
            String  command = scanner.nextLine();
            //TODO: Problem with dates, because we don't check if the room is available or booked on this dates
            System.out.println("Enter a checkInDate in format YYYY-MM-DD");
            String checkInDate = scanner.nextLine();
            System.out.println("Enter a checkOutDate in format YYYY-MM-DD");
            String checkOutDate = scanner.nextLine();
            System.out.println("Available room/s");
            for (int i = 0; i < reservationManager.getAvailableRooms().size(); i++) {
                System.out.printf("%d. %s\n",i+1, reservationManager.getAvailableRooms().get(i));
            }
            //reservationManager.getAvailableRooms().stream().forEach(e-> System.out.println(e));
            System.out.println("Which room want to reservation?");
            int roomNum = Integer.parseInt(scanner.nextLine());
            if(command.equals("Yes")){
                User user = UserManager.getUsers().get(loginIndex);
                Room room = reservationManager.getAvailableRooms().get(roomNum-1);
                reservationManager.makeReservation(user,room,checkInDate,checkOutDate);
                RoomManagement.getRooms().get(roomNum-1).setStatus(BOOKED);
            }
        }else {
            System.out.println("You don't login in you account");
        }
    }

    private static int login(Scanner scanner, UserManager userManager) {
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
        for (int i = 0; i < UserManager.getUsers().size(); i++) {
            if(UserManager.getUsers().get(i).getUsername().equals(username) && UserManager.getUsers().get(i).getPassword().equals(password)){
                return i;
            }
        }
        return -1;
    }

    private static void registration(Scanner scanner, UserManager userManager) {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        System.out.println(userManager.registerUser(username, password));
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
