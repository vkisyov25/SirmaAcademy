package com.hrrs;

public class Room {
    private int roomNum;
    private TypeRoom typeRoom;
    private double pricePerNight;
    private double cancellationFee;
    private Status status;

    public Room(int roomNum, TypeRoom typeRoom, double pricePerNight, double cancellationFee, Status status) {
        this.roomNum = roomNum;
        this.typeRoom = typeRoom;
        this.pricePerNight = pricePerNight;
        this.cancellationFee = cancellationFee;
        this.status = status;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
