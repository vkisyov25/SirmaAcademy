package com.hrrs.Controller;

import com.hrrs.Model.Reservation.Reservation;
import com.hrrs.Model.Room.Room;
import com.hrrs.Model.Room.Status;
import com.hrrs.Model.Room.TypeRoom;
import com.hrrs.Model.User.Role;
import com.hrrs.Model.User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.hrrs.Controller.RoomManagement.*;
import static com.hrrs.Controller.UserManager.getUsers;

public class ReservationManager {
    private static List<Reservation> reservations;


    public ReservationManager() throws Exception {
        reservations = readCSV();
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }

    public  List<Reservation> readCSV() throws Exception {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\reservations.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    records.add(values[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Reservation> userList = new ArrayList<>();
        for (int i = 0; i < records.size(); i += 10) {
            User user1 = null;
            if (records.get(i + 2).equals("ADMINISTRATOR")) {
                user1 = new User(records.get(i), records.get(i + 1), Role.ADMINISTRATOR);
            } else if (records.get(i + 2).equals("ORDINARY_USER")) {
                user1 = new User(records.get(i), records.get(i + 1), Role.ORDINARY_USER);
            }
            Room room1 = null;
            if (records.get(i + 4).equals("SINGLE")) {
                if (records.get(i + 7).equals("AVAILABLE")) {
                    room1 = new Room(Integer.parseInt(records.get(i + 3)), TypeRoom.SINGLE, Double.parseDouble(records.get(i + 5)),
                            Double.parseDouble(records.get(i + 6)), Status.AVAILABLE);
                } else if (records.get(i + 7).equals("BOOKED")) {
                    room1 = new Room(Integer.parseInt(records.get(i + 3)), TypeRoom.SINGLE, Double.parseDouble(records.get(i + 5)),
                            Double.parseDouble(records.get(i + 6)), Status.BOOKED);
                }
            } else if (records.get(i + 4).equals("DOUBLE")) {
                if (records.get(i + 7).equals("AVAILABLE")) {
                    room1 = new Room(Integer.parseInt(records.get(i + 3)), TypeRoom.DOUBLE, Double.parseDouble(records.get(i + 5)),
                            Double.parseDouble(records.get(i + 6)), Status.AVAILABLE);
                } else if (records.get(i + 7).equals("BOOKED")) {
                    room1 = new Room(Integer.parseInt(records.get(i + 3)), TypeRoom.DOUBLE, Double.parseDouble(records.get(i + 5)),
                            Double.parseDouble(records.get(i + 6)), Status.BOOKED);
                }
            }
            String checkInDate1 = records.get(i + 8);
            String checkOutDate1 = records.get(i + 9);
            /*boolean cr = StaffManagementApp.validateEmployee(String.valueOf(ID), name, department, role, String.valueOf(salary));
            //Validation
            if (!cr) {
                throw new Exception("Invalid format");
            }*/
            Reservation reservation = new Reservation(user1, room1, checkInDate1, checkOutDate1);
            userList.add(reservation);
            return userList;
        }
        return userList;
    }
    public static void writeToFile() {
        try {
            File file = new File("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\reservations.csv");
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < getReservations().size(); i++) {
                User username = getReservations().get(i).getUser();
                Room password = getReservations().get(i).getRoom();
                String inDate = getReservations().get(i).getCheckInDate();
                String outDate = getReservations().get(i).getCheckOutDate();
                myWriter.write(username + "," + password + "," + inDate + "," + outDate + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




    public void makeReservation(User user, Room room, String checkInDate, String checkOutDate) {
        //UserManager userManager = new UserManager();
        if (getUsers().contains(user)) {
            if (room.getStatus() == Status.valueOf("AVAILABLE")) {
                Reservation reservation = new Reservation(user, room, checkOutDate, checkOutDate);
                String[] arr = checkInDate.split("-");
                String[] arr1 = checkOutDate.split("-");
                double price = room.getPricePerNight() * (Integer.parseInt(arr1[2]) - Integer.parseInt(arr[2]));
                System.out.printf("The total cost is %.2f\n", price);
                reservations.add(reservation);
                //writeToFile();
                user.addBookingHistory(reservation);
                System.out.println("Successful reservation");

            } else {
                System.out.println("Room is not available");
            }
        } else {
            System.out.println("The user don't have a registration");
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRoom = new ArrayList<>();
        for (int i = 0; i < getRooms().size(); i++) {
            if (getRooms().get(i).getStatus() == Status.valueOf("AVAILABLE")) {
                availableRoom.add(getRooms().get(i));
            }
        }
        return availableRoom;
    }


    public void cancelReservation(Reservation reservation) {
        // Изчисление на такси за отмяна, ако е необходимо.
        // Отмяна на резервацията и актуализация на статуса на стаята.
        for (int i = 0; i < User.getBookingHistory().size(); i++) {
            if (User.getBookingHistory().get(i).equals(reservation)) {
                System.out.printf("For cancel this reservation you have to pay %.2f\n", getRooms().get(i).getCancellationFee());
                User.getBookingHistory().get(i).getRoom().setStatus(Status.valueOf("AVAILABLE"));
                reservations.remove(i);
                reservation = User.getBookingHistory().remove(i);
            }
        }
        writeToFile();
    }

}
