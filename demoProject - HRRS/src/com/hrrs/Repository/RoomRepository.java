package com.hrrs.Repository;

import com.hrrs.Service.RoomManagement;
import com.hrrs.Model.Room.Room;
import com.hrrs.Model.Room.Status;
import com.hrrs.Model.Room.TypeRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    public static List<Room> readCSV() throws Exception {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\room.csv"))) {
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
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < records.size(); i += 5) {
            Room room1 = null;
            if (records.get(i + 1).equals("SINGLE")) {
                if (records.get(i + 4).equals("AVAILABLE")) {
                    room1 = new Room(Integer.parseInt(records.get(i)), TypeRoom.SINGLE, Double.parseDouble(records.get(i + 2)),
                            Double.parseDouble(records.get(i + 3)), Status.AVAILABLE);
                } else if (records.get(i + 4).equals("BOOKED")) {
                    room1 = new Room(Integer.parseInt(records.get(i)), TypeRoom.SINGLE, Double.parseDouble(records.get(i + 2)),
                            Double.parseDouble(records.get(i + 3)), Status.BOOKED);
                } else {
                    throw new Exception("Invalid format");
                }

            } else if (records.get(i + 1).equals("DOUBLE")) {
                if (records.get(i + 4).equals("AVAILABLE")) {
                    room1 = new Room(Integer.parseInt(records.get(i)), TypeRoom.DOUBLE, Double.parseDouble(records.get(i + 2)),
                            Double.parseDouble(records.get(i + 3)), Status.AVAILABLE);
                } else if (records.get(i + 4).equals("BOOKED")) {
                    room1 = new Room(Integer.parseInt(records.get(i)), TypeRoom.DOUBLE, Double.parseDouble(records.get(i + 2)),
                            Double.parseDouble(records.get(i + 3)), Status.BOOKED);
                } else {
                    throw new Exception("Invalid format");
                }
            } else {
                throw new Exception("Invalid format");
            }

            roomList.add(room1);
            return roomList;
        }
        return roomList;
    }

    public static void writeToFile() {
        try {
            File file = new File("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\room.csv");
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < RoomManagement.getRooms().size(); i++) {
                int roomNum = RoomManagement.getRooms().get(i).getRoomNum();
                TypeRoom typeRoom = RoomManagement.getRooms().get(i).getTypeRoom();
                double pricePerNightht = RoomManagement.getRooms().get(i).getPricePerNight();
                double cancelationFee = RoomManagement.getRooms().get(i).getCancellationFee();
                Status status = RoomManagement.getRooms().get(i).getStatus();
                myWriter.write(roomNum + "," + typeRoom + "," + pricePerNightht + "," + cancelationFee + "," + status + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
