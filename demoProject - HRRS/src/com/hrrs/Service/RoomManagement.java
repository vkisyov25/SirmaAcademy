package com.hrrs.Service;

import com.hrrs.Model.Room.Room;
import com.hrrs.Repository.RoomRepository;

import java.util.List;

public class RoomManagement {
    private static List<Room> rooms;

    public RoomManagement() throws Exception {
        rooms = RoomRepository.readCSV();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        RoomRepository.writeToFile();
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
        RoomRepository.writeToFile();
    }

    public void removeRoom(Room room) {
        // Намиране на стаята в списъка и премахване от него.
        rooms.removeIf(r -> r.getRoomNum() == (room.getRoomNum()));
        RoomRepository.writeToFile();
    }

    public static List<Room> getRooms() {
        return rooms;
    }


}
