package com.hrrs;

import com.hrrs.Reservation.Reservation;
import com.hrrs.Room.Room;
import com.hrrs.User.User;

import java.util.List;

public class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public boolean makeReservation(User user, Room room, String checkInDate, String checkOutDate) {
        // Проверка на наличност и резервация на стая.
        // Изчисление на цена и такси за отмяна.
        // Добавяне на резервацията към списъка с резервации.
        // Връщане на резултат (успешно или неуспешно).
        return false;
    }

    public List<Room> getAvailableRooms(String checkInDate, String checkOutDate) {
        // Намиране на наличните стаи за определени дати и изчисление на цените им.
        // Връщане на списък с наличните стаи.
        return null;
    }

    public void cancelReservation(Reservation reservation) {
        // Изчисление на такси за отмяна, ако е необходимо.
        // Отмяна на резервацията и актуализация на статуса на стаята.
    }
}
