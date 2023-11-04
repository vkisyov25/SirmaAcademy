package com.hrrs;

import com.hrrs.Reservation.Reservation;
import com.hrrs.Room.Room;
import com.hrrs.Room.Status;
import com.hrrs.User.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.hrrs.RoomManagement.*;
import static com.hrrs.UserManager.getUsers;

public class ReservationManager {
    private static List<Reservation> reservations;

    public ReservationManager() {
        this.reservations = new ArrayList<>();
    }

    public static List<Reservation> getReservations() {
        return reservations;
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

        for (int i = 0; i < getReservations().size() ; i++) {
            if(getReservations().get(i).equals(reservation)){
                System.out.printf("For cancel this reservation you have to pay %.2f\n",getRooms().get(i).getCancellationFee());
                //problem
                getRooms().get(i).getStatus().equals("AVAILABLE");
                reservations.remove(i);
            }
        }
    }
}
