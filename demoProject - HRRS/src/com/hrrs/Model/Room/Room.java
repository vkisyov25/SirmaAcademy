package com.hrrs.Model.Room;

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

    //TODO: Are all "set methods" required?
    public int getRoomNum() {
        return roomNum;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
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

    @Override
    public String toString() {
        return "roomNum=" + roomNum +
                ", typeRoom=" + typeRoom +
                ", pricePerNight=" + pricePerNight +
                ", cancellationFee=" + cancellationFee +
                ", status=" + status +
                '}';
    }
}
