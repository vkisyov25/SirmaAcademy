package com.hrrs;/*
package com.hrrs;

import com.hrrs.Reservation.Reservation;
import com.hrrs.Room.Room;

import java.util.List;

public class AdminMode {
    public void viewAllBookings(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            // System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("User: " + reservation.getUser().getUsername());
            System.out.println("Room: " + reservation.getRoom().getRoomNum());
            System.out.println("Check-in Date: " + reservation.getCheckInDate());
            System.out.println("Check-out Date: " + reservation.getCheckOutDate());
            //System.out.println("Cancelled: " + (reservation.isCancelled() ? "Yes" : "No"));
            System.out.println("------------------------------");
        }
    }

   */
/* public void viewFinancialSummary(List<Reservation> reservations) {
        double totalIncome = 0;
        double totalCancellationFees = 0;

        for (Reservation reservation : reservations) {
            if (!reservation.isCancelled()) {
                totalIncome += reservation.getRoom().getPricePerNight();
            } else {
                totalCancellationFees += reservation.calculateCancellationFee();
            }
        }

        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Cancellation Fees: $" + totalCancellationFees);
    }*//*


    public void addRoom(List<Room> rooms, Room newRoom) {
        rooms.add(newRoom);
    }

    public void removeRoom(List<Room> rooms, Room roomToRemove) {
        rooms.remove(roomToRemove);
    }

    public void modifyRoomDetails(Room room, double newPrice, double newCancellationFee) {
        room.setPricePerNight(newPrice);
        room.setCancellationFee(newCancellationFee);
    }
}
*/

import com.hrrs.Reservation.Reservation;
import com.hrrs.Room.Room;

import java.util.List;

public class AdminMode {
    public void viewAllReservations(List<Reservation> reservations) {
        reservations.forEach(System.out::println);
    }

    public void viewFinancialData(List<Reservation> reservations) {
        // Изчисление на общ доход и такси за отмяна на база данни с резервации.
        // Извеждане на финансовите данни.
    }

    public void manageRooms(List<Room> rooms) {
        // Управление на стаите, например добавяне, промяна и премахване.
    }
}

