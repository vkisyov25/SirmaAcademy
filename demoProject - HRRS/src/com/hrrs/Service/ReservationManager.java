package com.hrrs.Service;

import com.hrrs.Model.Reservation.Reservation;
import com.hrrs.Model.Room.Room;
import com.hrrs.Model.Room.Status;
import com.hrrs.Model.User.User;
import com.hrrs.Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

import static com.hrrs.Service.RoomManagement.*;
import static com.hrrs.Service.UserManager.getUsers;

public class ReservationManager {
    private static List<Reservation> reservations;


    public ReservationManager() throws Exception {
        reservations = ReservationRepository.readCSV();
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
                double price = 0;
                if (arr[1].equals(arr1[1])) {
                    price = room.getPricePerNight() * (Integer.parseInt(arr1[2]) - Integer.parseInt(arr[2]));
                } else {
                    int diff = (Integer.parseInt(arr1[1]) - Integer.parseInt(arr[1])) - 1;
                    price = room.getPricePerNight() * (30 * diff + (30 - Integer.parseInt(arr[2]) + Integer.parseInt(arr1[2])));
                }

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
        for (int i = 0; i < User.getBookingHistory().size(); i++) {
            if (User.getBookingHistory().get(i).equals(reservation)) {
                System.out.printf("For cancel this reservation you have to pay %.2f\n", getRooms().get(i).getCancellationFee());
                User.getBookingHistory().get(i).getRoom().setStatus(Status.valueOf("AVAILABLE"));
                reservations.remove(i);
                reservation = User.getBookingHistory().remove(i);
            }

        }

        ReservationRepository.writeToFile();
    }

}
