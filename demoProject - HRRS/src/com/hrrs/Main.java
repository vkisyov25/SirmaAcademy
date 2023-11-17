package com.hrrs;

import com.hrrs.Model.Reservation.Reservation;
import com.hrrs.Model.Room.Room;
import com.hrrs.Model.Room.TypeRoom;
import com.hrrs.Model.User.Role;
import com.hrrs.Model.User.User;
import com.hrrs.Repository.RoomRepository;
import com.hrrs.Repository.UserRepository;
import com.hrrs.Service.ReservationManager;
import com.hrrs.Service.RoomManagement;
import com.hrrs.Service.UserManager;
import com.hrrs.Repository.ReservationRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.hrrs.Model.Room.Status.AVAILABLE;
import static com.hrrs.Model.Room.Status.BOOKED;
import static com.hrrs.Model.Room.TypeRoom.DOUBLE;
import static com.hrrs.Model.Room.TypeRoom.SINGLE;
import static com.hrrs.Service.RoomManagement.getRooms;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        printMainMenu();
        int num = Integer.parseInt(scanner.nextLine());
        UserManager userManager = new UserManager();
        RoomManagement roomManagement = new RoomManagement();
        ReservationManager reservationManager = new ReservationManager();
        //getRooms().forEach(e-> System.out.println(e));
        int loginIndex = -1;
        while (num <= 7) {
            if (num == 1) {
                registration(scanner, userManager);
            } else if (num == 2) {
                loginIndex = login(scanner, userManager);
            } else if (num == 3) {
                reservation(scanner, reservationManager, loginIndex);
            } else if (num == 4) {
                reservationCancellation(scanner, reservationManager, loginIndex);
            } else if (num == 5) {
                adminMenu(scanner, roomManagement, loginIndex);
            } else if (num == 6) {
                loginIndex = exit(loginIndex);
            } else if (num==7) {
                viewYourReservation(loginIndex);
            }

            System.out.println("Please select a number for the menu option: ");
            num = Integer.parseInt(scanner.nextLine());
        }

    }

    private static void viewYourReservation(int loginIndex) throws Exception {
        if(loginIndex !=-1){
            for (int i = 0; i < ReservationRepository.readCSV().size(); i++) {
                if(ReservationRepository.readCSV().get(i).getUser().getUsername().equals(UserManager.getUsers().get(loginIndex).getUsername())){
                    System.out.print(ReservationRepository.readCSV().get(i).getUser().getUsername()+","+ReservationRepository.readCSV().get(i).getUser().getRoles()+",");
                    System.out.print(ReservationRepository.readCSV().get(i).getRoom()+",");
                    System.out.print(ReservationRepository.readCSV().get(i).getCheckOutDate()+",");
                    System.out.print(ReservationRepository.readCSV().get(i).getCheckOutDate()+",");
                }else {
                    System.out.println("You don't have a reservations.");
                }

            }

        }else {
            System.out.println("You don't login");
        }
    }

    private static int exit(int loginIndex) throws IOException {
        if (loginIndex != -1) {
            //write every user in file
            String pathIn = "";
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(pathIn));
            ous.writeObject(UserManager.getUsers().get(loginIndex));
            System.out.println("You have signed out of your account");
            loginIndex = -1;
        } else {
            System.out.println("You are not logged in yet");
        }

        return loginIndex;
    }

    private static void adminMenu(Scanner scanner, RoomManagement roomManagement, int loginIndex) throws Exception {
        if (loginIndex != -1) {
            if (UserManager.getUsers().get(loginIndex).getRoles() == Role.ADMINISTRATOR) {
                printAdministratorMenu();
                int commandNum = Integer.parseInt(scanner.nextLine());
                if (commandNum == 1) {
                    System.out.println("roomNum = ");
                    int roomNum = Integer.parseInt(scanner.nextLine());
                    System.out.println("typeRoom = {SINGLE,DOUBLE} ");
                    TypeRoom typeRoom = null;
                    String typeRoomString = scanner.nextLine();
                    if (typeRoomString.equals("SINGLE")) {
                        typeRoom = SINGLE;
                    } else if (typeRoomString.equals("DOUBLE")) {
                        typeRoom = DOUBLE;
                    } else {
                        throw new Exception("Invalid format");
                    }

                    System.out.println("pricePerNight = ");
                    double pricePerNight = Double.parseDouble(scanner.nextLine());
                    System.out.println("cancellationFee = ");
                    double cancellationFee = Double.parseDouble(scanner.nextLine());
                    Room room = new Room(roomNum, typeRoom, pricePerNight, cancellationFee, AVAILABLE);
                    roomManagement.addRoom(room);
                } else if (commandNum == 2) {
                    getRooms().stream().forEach(e -> System.out.println(e));
                    System.out.println("Which room do you remove?");
                    int roomNum = Integer.parseInt(scanner.nextLine());
                    roomManagement.removeRoom(getRooms().get(roomNum - 1));
                } else if (commandNum == 3) {
                    getRooms().stream().forEach(e -> System.out.println(e));
                    System.out.println("Which room do you update?");
                    int roomNum = Integer.parseInt(scanner.nextLine());
                    System.out.println("newPricePerNight = ");
                    double newPricePerNight = Double.parseDouble(scanner.nextLine());
                    System.out.println("newCancellationFee = ");
                    double newCancellationFee = Double.parseDouble(scanner.nextLine());
                    roomManagement.updateRoom(getRooms().get(roomNum - 1), newPricePerNight, newCancellationFee);
                }

            } else {
                System.out.println("You aren't administrator");
            }

        } else {
            System.out.println("You don't login in your account");
        }
    }

    private static void reservationCancellation(Scanner scanner, ReservationManager reservationManager, int loginIndex) {
        if (loginIndex != -1) {
            List<Reservation> reservationList = new ArrayList<>();
            System.out.println("Do you cancel a reservation: Yes/No");
            String command = scanner.nextLine();
            if (command.equals("No")) {
                printMainMenu();
                return;
            }

            if (ReservationManager.getReservations().size() != 0) {
                System.out.println("This is our reservations");
                for (int i = 0; i < User.getBookingHistory().size(); i++) {
                    //TODO: There is a problem when I want to visualize reservation room
                    System.out.printf("%d. reservation\n", i + 1);
                }

                System.out.println("Which reservation do you want to cancel?");
                int roomNum = Integer.parseInt(scanner.nextLine());
                if (command.equals("Yes")) {
                    reservationManager.cancelReservation(ReservationManager.getReservations().get(roomNum - 1));
                }

            } else {
                System.out.println("You don't have some reservation");
            }

        } else {
            System.out.println("You don't login in you account");
        }

    }


    private static void reservation(Scanner scanner, ReservationManager reservationManager, int loginIndex) throws Exception {
        if (loginIndex != -1) {
            System.out.println("Do you make a reservation: Yes/No");
            String command = scanner.nextLine();
            if (command.equals("No")) {
                printMainMenu();
                return;
            }

            //TODO: Problem with dates, because we don't check if the room is available or booked on this dates
            System.out.println("Enter a checkInDate in format YYYY-MM-DD");
            String checkInDate = scanner.nextLine();
            System.out.println("Enter a checkOutDate in format YYYY-MM-DD");
            String checkOutDate = scanner.nextLine();
            boolean cr = ReservationRepository.reservationValidation(checkInDate, checkOutDate);
            //Validation
            if (!cr) {
                throw new Exception("Invalid format");
            }

            if (reservationManager.getAvailableRooms().size() != 0) {
                System.out.println("Available room/s");
                for (int i = 0; i < reservationManager.getAvailableRooms().size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, reservationManager.getAvailableRooms().get(i));
                }

                //reservationManager.getAvailableRooms().stream().forEach(e-> System.out.println(e));
                System.out.println("Which room want to reservation?");
                int roomNum = Integer.parseInt(scanner.nextLine());
                if (command.equals("Yes")) {
                    User user = UserManager.getUsers().get(loginIndex);
                    Room room = reservationManager.getAvailableRooms().get(roomNum - 1);
                    reservationManager.makeReservation(user, room, checkInDate, checkOutDate);
                    reservationManager.getAvailableRooms().get(roomNum - 1).setStatus(BOOKED);
                    ReservationRepository.writeToFile();
                    //getRooms().forEach(e-> System.out.println(e));
                    RoomRepository.writeToFile();
                }

            } else {
                System.out.println("At the moment there aren't available rooms");
            }

        } else {
            System.out.println("You don't login in your account");
        }
    }

    private static int login(Scanner scanner, UserManager userManager) throws Exception {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        boolean cr = UserRepository.userValidation(username, password);
        //Validation
        if (!cr) {
            throw new Exception("Invalid format");
        }

        User user = userManager.login(username, password);
        if (user == null) {
            System.out.println("You don't have profile and you have to make registration");
        } else {
            System.out.println("Successful login");
        }

        for (int i = 0; i < UserManager.getUsers().size(); i++) {
            if (UserManager.getUsers().get(i).getUsername().equals(username) && UserManager.getUsers().get(i).getPassword().equals(password)) {
                return i;
            }

        }

        return -1;
    }

    private static void registration(Scanner scanner, UserManager userManager) throws Exception {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        System.out.println("role:{ADMINISTRATOR,ORDINARY_USER}");
        String roleString = scanner.nextLine();
        boolean cr = UserRepository.userValidation(username, password);
        //Validation
        if (!cr) {
            throw new Exception("Invalid format");
        }

        Role role = null;
        if (roleString.equals("ADMINISTRATOR")) {
            role = Role.ADMINISTRATOR;
            System.out.println(userManager.registerUser(username, password, role));
        } else if (roleString.equals("ORDINARY_USER")) {
            role = Role.ORDINARY_USER;
            System.out.println(userManager.registerUser(username, password, role));
        } else {
            throw new Exception("Invalid format");
        }

    }


    public static void printMainMenu() {
        System.out.print("\nWelcome to the Hotel Reservation Application\n" + "--------------------------------------------\n" + "1. Registration\n" + "2. Login\n" + "3. Reservation\n" + "4. Reservation cancelled\n" + "5. Admin menu - add room, remove room, update pricePerNight and cancellationFee\n" + "6. Exit\n" +
                "7. View your reservation\n" + "--------------------------------------------\n" + "Please select a number for the menu option:\n");
    }

    public static void printAdministratorMenu() {
        System.out.print("--------------------------------------------\n" + "1. Add room\n" + "2. Remove room\n" + "3. Update price per night and cancellation fee\n" + "--------------------------------------------\n" + "Please select a number for the menu option:\n");

    }
}