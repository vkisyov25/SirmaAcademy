package com.hrrs.Controller;

import com.hrrs.Model.Room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManagement {
    private static List<Room> rooms;

    public RoomManagement() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void updateRoom(Room room, double newPricePerNight, double newCancellationFee) {
        // Намиране на стаята в списъка и актуализация на цената и таксата за отмяна.
        for (Room r : rooms) {
            if (r.getRoomNum() == (room.getRoomNum())) {
                r.setPricePerNight(newPricePerNight);
                r.setCancellationFee(newCancellationFee);
                break;
            }
        }
    }

    public void removeRoom(Room room) {
        // Намиране на стаята в списъка и премахване от него.
        rooms.removeIf(r -> r.getRoomNum() == (room.getRoomNum()));
    }

    public static List<Room> getRooms() {
        return rooms;
    }
}
